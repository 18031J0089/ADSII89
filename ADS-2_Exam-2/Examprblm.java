

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge {
    int source;
    int destination;
    double weight;

    public Edge(int s, int d, double w) {
        this.source = s;
        this.destination = d;
        this.weight = w;
    }

	@Override
	public String toString() {
		return  source + ", " + destination + ", " + weight;
	}
}

class Graph {
    int vertices;
    ArrayList<Edge> al = new ArrayList<>();
    Graph(int vertices) {
        this.vertices = vertices;
    }
    public void addEgde(int src, int destn, double wgt) {
        Edge edge = new Edge(src, destn, wgt);
        al.add(edge);
    }
    public void printvertex(ArrayList<Edge> adj) {
    	 for (int i = 0; i <adj.size() ; i++) {
             Edge edge = adj.get(i);
             System.out.println(i+" "+edge.source +"-"+ edge.destination+"  "+edge.weight);
                    
         }
    }
}
public class Examprblm {
	public static void main(String args[]) {
		Scanner scn=new Scanner(System.in);
		int s1=Integer.parseInt(scn.nextLine());
		int s2=Integer.parseInt(scn.nextLine());
		Graph g=new Graph(6);
		for(int i=0;i<s2;i++) {
			String s3=scn.nextLine();
			String s4[]=s3.split(" ");
			g.addEgde(Integer.parseInt(s4[0]), Integer.parseInt(s4[1]), Integer.parseInt(s4[2]));
		}
		g.printvertex(g.al);
		/*g.addEgde(0, 1, 2);
		g.addEgde(1, 4, 5);
		g.addEgde(1, 2, 4);
		g.addEgde(0, 3, 1);
		g.addEgde(3, 2, 3);
		g.addEgde(2, 4, 1);
		g.printGraph(g.al);*/
		
	}
}
