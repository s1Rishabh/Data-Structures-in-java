package Graphs;

import java.util.ArrayList;

public class kthterms {

	public static class Edge {
		int v;
		int w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void edge(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int w) {
		graph.get(v1).add(new Edge(v2, w));
		graph.get(v2).add(new Edge(v1, w));
	}

	public static void display(ArrayList<ArrayList<Edge>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print(i + "=>");

			for (int n = 0; n < graph.get(i).size(); n++) {
				Edge ev = graph.get(i).get(n);
				System.out.print("[" + ev.v + "@" + ev.w + "]");
			}
			System.out.println();
		}
	}

	public static int kthsmallest(ArrayList<ArrayList<Edge>> graph, int k, int w) {
		int res = Integer.MAX_VALUE;
		boolean vs[] = new boolean[graph.size() + 1];
		for (int i = 0; i < k; i++) {
			int x = Integer.MIN_VALUE;
			floor(graph, 0, 6, vs, w, x);
			res = x;
		}
		return res;
	}

	static int floor = Integer.MIN_VALUE;

	private static void floor(ArrayList<ArrayList<Edge>> graph, int src, int dst, boolean vs[], int w, int factor) {

		if (src == dst) {
			if (w > factor && w > floor)
			{
				floor = w;
				factor = w;
			}
			return;
		}
		vs[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge ev = graph.get(src).get(i);
			if (vs[ev.v] == false) {
				floor(graph, ev.v, dst, vs, w + ev.w, factor);
			}

		}
		vs[src] = false;

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
		System.out.println(kthsmallest(graph, 3, 0));
	}

}
