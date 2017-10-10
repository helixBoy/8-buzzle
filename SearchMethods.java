import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SearchMethods {

	//search in the search space and return the solution path
	public static Stack<Node> BFS(int[] board){
		
		// if not solvable , return null.
		if(getInvCount(board) %2 == 1)
			return null;
		
		
		//the number of nodes explored
		int searchCount = 1 ;
		
		Node root = new Node(new State(board));
		Queue<Node> queue =  new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node tempNode = queue.poll();
			
			// if not goal
			if(!tempNode.curState.isGoal()){
				
				//generate successors
			       ArrayList<State> successors = tempNode.curState.getSuccessors();
				
		     	// iterate through the neighbours of the kicked node
		    	   for(int i = 0 ; i<successors.size() ; ++i){
		    		   
		    		   Node newNode = new Node(successors.get(i) , tempNode);
		    		   
		    		  if (!checkRepeatedParent(newNode))
		    			   queue.add(newNode);
						
		    		   
		    	   }
		           searchCount++;
		    	   
		    }
			
			else
			//the goal is found
			{
				System.out.println("search count " +  searchCount);

				//stack to track the path of the solution
				Stack<Node> solutionPath = new Stack<Node>();
				solutionPath.push(tempNode); // add the goal node
				
				tempNode = tempNode.parent;
				
				while(tempNode.parent!=null){
					solutionPath.push(tempNode);
					tempNode = tempNode.parent;
				}
				solutionPath.push(tempNode); // add the root , since no parent for the root
				return solutionPath;

			}
			
		}// while
		return null;
		
	}

	// to check solvability  , returns even number if solvable 
	private static int getInvCount(int []arr)
	{
	    int inv_count = 0;
	    for (int i = 0; i < 9 - 1; i++)
	        for (int j = i+1; j < 9; j++)
	             // Value 0 is used for empty space
	             if (arr[j]!=0 && arr[i]!=0 &&  arr[i] > arr[j])
	                  inv_count++;
	    return inv_count;
	}

	/*
	 checks if the current state is the same as the grandpa ...
	 so it's repeated and shouldn't be added to the queue
	 */
	private static boolean checkRepeatedParent(Node n){
		if(n.parent.parent != null )
		if(n.parent.parent.curState.equals(n.curState))
			return true;
		return false;
	}
}
