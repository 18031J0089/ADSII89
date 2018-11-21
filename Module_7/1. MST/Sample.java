
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

 public class Sample {
	static class Edge {
		int source;
		int destination;
		int weight;

		Edge(int s, int d, int w) {
			this.source = s;
			this.destination = d;
			this.weight = w;
		}
	}

	static class Graph {
		int vertices;
		ArrayList<Edge> al = new ArrayList<>();

		Graph(int v) {
			this.vertices = v;
		}

		public void addEdge(int s, int d, int w) {
			Edge ed = new Edge(s, d, w);
			al.add(ed);
		}

		public void kruskal() {
			PriorityQueue<Edge> pq = new PriorityQueue<>(al.size(), Comparator.comparingInt(o -> o.weight));
			for (int i = 0; i < al.size(); i++) {
				pq.add(al.get(i));
				int[] parent = new int[vertices];
				makeSet(parent);
				ArrayList<Edge> mst = new ArrayList<>();
				int index = 0;
				while (index < vertices - 1) {
					Edge edge = pq.remove();
					int x_set = find(parent, edge.source);
					int y_set = find(parent, edge.destination);
					if (x_set == y_set) {
					} else {
						mst.add(edge);
						index++;
						union(parent, x_set, y_set);
					}
				}
				System.out.println("Minimum Spanning Tree: ");
				printGraph(mst);
			}
		}

		public void makeSet(int[] parent) {
			for (int i = 0; i < vertices; i++) {
				parent[i] = i;
			}
		}
		public int find(int[] parent, int vertex) {
			if (parent[vertex] != vertex)
				return find(parent, parent[vertex]);
			return vertex;
		}

		public void union(int[] parent, int x, int y) {
			int x_set_parent = find(parent, x);
			int y_set_parent = find(parent, y);
			parent[y_set_parent] = x_set_parent;
		}

		public void printGraph(ArrayList<Edge> edgeList) {
			for (int i = 0; i < edgeList.size(); i++) {
				Edge edge = edgeList.get(i);
				System.out.println(edge.source + " " + edge.destination);

			}
		}
	}
	public static void main(String args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2=scn.nextLine();
		Graph g=new Graph(Integer.parseInt(s1));
		while(scn.hasNext()) {
			String s3=scn.nextLine();
			String s4[]=s3.split(" ");
			g.addEdge(Integer.parseInt(s4[0]), Integer.parseInt(s4[1]), Integer.parseInt(s4[2]));
		}
		g.kruskal();
	}

}
