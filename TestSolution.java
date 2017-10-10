import java.util.Stack;


public class TestSolution {

	public static void main(String[] args) {
		
		int [] board = {5,4,3,2,1,8,6,7,0};
		Stack<Node> solution = new Stack<Node>();
		
		
		long startTime = System.currentTimeMillis();
		
		solution = SearchMethods.BFS(board);
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("total time " + totalTime);
		
		System.out.println("Stack size " + solution.size());
		
		if(solution==null)
			System.out.print("No solution");
		else
		while(!solution.empty()){
			Node temp = solution.pop();
			temp.curState.printState();
		}
	}

}
