

import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List;
import java.util.Scanner; 
  
class Cycle { 
      
    private final int V; 
    private final List<List<Integer>> adj; 
  
    public Cycle(int V)  
    { 
        this.V = V; 
        adj = new ArrayList<>(V); 
          
        for (int i = 0; i < V; i++) 
            adj.add(new LinkedList<>()); 
    } 
      
    // This function is a variation of DFSUytil() in  
    // https://www.geeksforgeeks.org/archives/18212 
    private boolean isCyclicUtil(int i, boolean[] visited, 
                                      boolean[] recStack)  
    { 
          
        // Mark the current node as visited and 
        // part of recursion stack 
        if (recStack[i]) 
        	return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        List<Integer> ll = adj.get(i); 
          
        for (Integer c: ll) 
            if (isCyclicUtil(c, visited, recStack)) 
                return true; 
                  
        recStack[i] = false; 
  
        return false; 
    } 
  
    private void addEdge(int source, int dest) { 
        adj.get(source).add(dest); 
    } 
  
    // Returns true if the graph contains a  
    // cycle, else false. 
    // This function is a variation of DFS() in  
    private boolean isCyclic()  
    { 
        boolean[] visited = new boolean[V]; 
        boolean[] recStack = new boolean[V]; 
          
          
        // Call the recursive helper function to 
        // detect cycle in different DFS trees 
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil(i, visited, recStack)) 
                return true; 
  
        return false; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
    	Scanner scn=new Scanner(System.in);
    	int n=Integer.parseInt(scn.nextLine());
    	int m=Integer.parseInt(scn.nextLine());
    	Cycle cc = new Cycle(n); 
    	while(scn.hasNext()) {
    		String s1=scn.nextLine();
    		String s2[]=s1.split(" ");
    		cc.addEdge(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
    	}
    	/*cc.addEdge(0, 1); 
    	cc.addEdge(0, 2); 
    	cc.addEdge(1, 2); 
    	cc.addEdge(2, 0); 
    	cc.addEdge(2, 3); 
    	cc.addEdge(3, 3);*/ 
          
        if(cc.isCyclic()) 
            System.out.println("Cycle exists."); 
        else
            System.out.println("Cycle doesn't exists.");
                                   
    } 
} 
