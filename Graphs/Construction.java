package Graphs;

import java.util.ArrayList;

public class Construction {

	public static class Edge {
		public int n;
		public int w;

		public Edge(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

	public static void edge(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int wt) {
		graph.get(v1).add(new Edge(v2, wt));
		graph.get(v2).add(new Edge(v1, wt));
	}

	public static void display(ArrayList<ArrayList<Edge>> graph) {
		System.out.println("------------------------------");

		for (int i = 0; i < graph.size(); i++) {
			System.out.print(i + "->");
			for (int n = 0; n < graph.get(i).size(); n++) {
				Edge ev = graph.get(i).get(n);
				System.out.print("[" + ev.n + "@" + ev.w + "]");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			graph.add(new ArrayList<>());
		}
		edge(graph, 0, 1, 10);
		edge(graph, 1, 2, 10);
		edge(graph, 0, 3, 40);
		edge(graph, 2, 3, 10);
		edge(graph, 3, 4, 2);
		edge(graph, 4, 5, 3);
		edge(graph, 5, 6, 3);
		edge(graph, 4, 6, 8);
		display(graph);

	}

}
