import java.util.ArrayList;
import java.util.Arrays;


public class State {
	
   private int boardSize = 9 ;
   private final int[] GOAL = { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
   private int [] curState ;
   public int outOfPlace = 0; 
   
   //constructor
   public State(int [] board){
	   this.curState = board ;
   }
  
   private int getHoleIndex(){
	   for(int i = 0 ; i<boardSize ; ++i )
		   if(curState[i] == 0)
			   return  i ; 
	   return -1; // not reachable
   }

   // copy board state 
   private int[] copyState(int [] state){
	  int [] newCopy =  new int[boardSize];
	  for(int i=0 ; i<9 ; ++i)
		  newCopy[i] = state[i] ;
	  return newCopy;  
   }   
   
   // successor function
   public ArrayList<State> getSuccessors(){
	   ArrayList<State> successors = new ArrayList<State>();
	   int holeIndex = getHoleIndex();
	   
	   //here we can move left
	   if(holeIndex !=0 && holeIndex !=3 && holeIndex !=6  ) 
		   successors.add(changeState(holeIndex , holeIndex - 1 ));
	
	   //here we can move up
	   if(holeIndex !=0 && holeIndex !=1 && holeIndex !=2  ) 
		   successors.add(changeState(holeIndex , holeIndex - 3 ));
	 
	   //here we can move left
	   if(holeIndex !=2 && holeIndex !=5 && holeIndex !=8  ) 
		   successors.add(changeState(holeIndex , holeIndex + 1 ));
	 
	   //here we can move left
	   if(holeIndex !=6 && holeIndex !=7 && holeIndex !=8  ) 
		   successors.add(changeState(holeIndex , holeIndex + 3 ));
		   
		   
		   return successors ;
	   }

   private State changeState(int pos1, int pos2) {
	    int [] newState = copyState(curState);
	    int temp = newState[pos1];
	    newState[pos1] = newState[pos2];
	    newState[pos2] = temp;
	    
	return new State(newState) ;
}
   
   public boolean isGoal(){
	   if(Arrays.equals(GOAL, curState))
		   return true;
	   return false;
   }

   public void printState()
	{
		System.out.println(curState[0] + " | " + curState[1] + " | "
				+ curState[2]);
		System.out.println("---------");
		System.out.println(curState[3] + " | " + curState[4] + " | "
				+ curState[5]);
		System.out.println("---------");
		System.out.println(curState[6] + " | " + curState[7] + " | "
				+ curState[8]);
		System.out.println();
		

	}

   // compare the current board with another board
   public boolean equals (State s){
	   if(Arrays.equals(curState, s.curState))
		   return true;
	   return false;
   }

   

}// class
