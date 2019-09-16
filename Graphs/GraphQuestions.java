package Graphs;

import java.util.ArrayList;

public class GraphQuestions {

	public static class Edge {
		public int n;
		public int w;

		public Edge(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

	public static boolean haspath(ArrayList<ArrayList<Edge>> graph, int src, int ds, boolean vs[]) {
		if (src == ds) {
			return true;
		}
		vs[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge ev = graph.get(src).get(i);
			if (vs[ev.n] == false) {
				if (haspath(graph, ev.n, ds, vs)) {
					return true;
				}
			}
		}

		return false;
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

	public static void printallpath(ArrayList<ArrayList<Edge>> graph, int src, int dst, boolean vs[], String s,
			int wt) {
		if (src == dst) {
			System.out.println(s + dst + "@" + wt);
			return;
		}
		vs[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge ev = graph.get(src).get(i);
			if (vs[ev.n] == false) {
				printallpath(graph, ev.n, dst, vs, s + src + "-", wt + ev.w);
			}
		}
		vs[src] = false;
	}

	public static int minpath = Integer.MAX_VALUE;

	public static void smallestpath(ArrayList<ArrayList<Edge>> graph, int src, int dst, boolean vs[], int wt) {

		if (src == dst) {
			if (minpath > wt) {
				minpath = wt;
			}
		}
		vs[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge ev = graph.get(src).get(i);

			if (vs[ev.n] == false) {
				smallestpath(graph, ev.n, dst, vs, wt + ev.w);
			}
		}
		vs[src] = false;
	}

	public static int maxpath = Integer.MIN_VALUE;

	public static void largestpath(ArrayList<ArrayList<Edge>> graph, int src, int dst, boolean vs[], int wt) {

		if (src == dst) {
			if (maxpath < wt) {
				maxpath = wt;
			}
		}
		vs[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge ev = graph.get(src).get(i);

			if (vs[ev.n] == false) {
				largestpath(graph, ev.n, dst, vs, wt + ev.w);
			}
		}
		vs[src] = false;
	}

	public static int floor = Integer.MIN_VALUE;

	public static void floor(ArrayList<ArrayList<Edge>> graph, int src, int dst, boolean vs[], int wt, int factor) {
		if (src == dst) {
			if (floor < wt && wt < factor) {
				floor = wt;
				System.out.print(factor + "@");
				return;
			}
		}
		vs[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge ev = graph.get(src).get(i);
			if (vs[ev.n] == false) {
				floor(graph, ev.n, dst, vs, wt + ev.w, factor);
			}
		}
		vs[src] = false;
	}

	public static int ceil = Integer.MAX_VALUE;

	public static void ceil(ArrayList<ArrayList<Edge>> graph, int src, int dst, boolean vs[], int wt, int factor) {
		if (src == dst) {
			if (ceil > wt && wt > factor) {
				ceil = wt;
				return;
			}
		}
		vs[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Edge ev = graph.get(src).get(i);
			if (vs[ev.n] == false) {
				ceil(graph, ev.n, dst, vs, wt + ev.w, factor);
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
		boolean vs[] = new boolean[graph.size() + 1];
//		System.out.println(haspath(graph, 0, 6, vs));
//		vs = new boolean[graph.size() + 1];
//		printallpath(graph, 0, 6, vs, "", 0);
//		vs = new boolean[graph.size() + 1];
//		floor(graph, 0, 6, vs, 0, 48);
//		System.out.println(floor);
//		vs = new boolean[graph.size() + 1];
//		ceil(graph, 0, 6, vs, 0, 48);
//		System.out.println(ceil);
//		smallestpath(graph, 0, 6, vs, 0);
//		System.out.println(minpath);
//		largestpath(graph, 0, 6, vs, 0);
//		System.out.println(maxpath);
//		vs = new boolean[graph.size() + 1];
//		System.out.println(kthlargest(graph, 3, vs, 0));
		vs = new boolean[graph.size() + 1];
	}

}
