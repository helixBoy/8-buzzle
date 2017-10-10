
// wrapper for the state

public class Node {
	
     public State curState;
     public Node parent;
     
     public Node(State s){
    	 curState = s;
    	 parent = null;
     }
    
     public Node(State s , Node parent){

    	 curState = s;
    	 this.parent = parent;
     }
     
	 

}
