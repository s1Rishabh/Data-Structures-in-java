package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

import Graphs.Construction.Edge;

public class bfsingraphs {

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

	public static class Thelp {
		int v;
		String psf;
		int dsf;

		public Thelp(int v, String psf, int dsf) {
			this.v = v;
			this.psf = psf;
			this.dsf = dsf;
		}
	}

	public static boolean bfs(ArrayList<ArrayList<Edge>> graph, int src, int dst) {
		boolean vs[] = new boolean[graph.size() + 1];
		LinkedList<Thelp> queue = new LinkedList<>();
		queue.add(new Thelp(src, "", 0));

		while (queue.size() > 0) {
			Thelp front = queue.removeFirst();
			System.out.println(src + " to " + front.v + " via " + front.psf + " @ " + front.dsf);

			if (vs[front.v] == true) {
				continue;
			} else {
				vs[front.v] = true;
			}
			if (front.v == dst) {
				return true;
			}
			for (int i = 0; i < graph.get(front.v).size(); i++) {
				Edge ev = graph.get(front.v).get(i);
				if (vs[ev.n] == false) {
					queue.add(new Thelp(ev.n, front.psf + ev.n, front.dsf + ev.w));
				}
			}
		}
		return false;
	}

	// fire and water mark question

	public static class fire {
		int i;
		int j;
		int t;

		public fire(int i, int j, int t) {
			this.i = i;
			this.j = j;
			this.t = t;
		}
	}

	public static void firestorm(int arr[][]) {

		LinkedList<fire> queue = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2) {
					queue.add(new fire(i, j, 0));
				}
			}
		}

		while (queue.size() > 0) {
			fire front = queue.removeFirst();
			if (arr[front.i][front.j] > 2) {
				continue;
			} else {
				arr[front.i][front.j] = front.t;
			}

			int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
			for (int x = 0; x < 4; x++) {
				int a, b;
				a = front.i + dirs[x][0];
				b = front.j + dirs[x][1];
				if (isvalid(arr, a, b))
					queue.add(new fire(a, b, front.t + 1));
			}
//			if (isvalid(arr, front.i + 1, front.j)) {
//				queue.add(new fire(front.i + 1, front.j, front.t + 1));
//			}
//			if (isvalid(arr, front.i - 1, front.j)) {
//				queue.add(new fire(front.i - 1, front.j, front.t + 1));
//			}
//			if (isvalid(arr, front.i, front.j + 1)) {
//				queue.add(new fire(front.i, front.j + 1, front.t + 1));
//			}
//			if (isvalid(arr, front.i, front.j - 1)) {
//				queue.add(new fire(front.i, front.j - 1, front.t + 1));
//			}
		}

	}

	private static boolean isvalid(int[][] arr, int i, int j) {

		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
			return false;
		} else if (arr[i][j] == 1) {
			return false;
		} else if (arr[i][j] > 1) {
			return false;
		} else {
			return true;
		}
	}

	// getvisitedcomponents

	public static String getvisitedcomponents(ArrayList<ArrayList<Edge>> graph, int src, boolean vs[], String comp) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(src);
		while (queue.size() > 0) {
			int front = queue.removeFirst();
			if (vs[front]) {
				continue;
			} else {
				comp += front + " ";
				vs[front] = true;
			}
			for (int k = 0; k < graph.get(front).size(); k++) {
				Edge ev = graph.get(front).get(k);
				if (vs[ev.n] == false) {
					queue.add(ev.n);
				}
			}
		}
		return comp;
	}

	public static ArrayList<String> getconnectedcom(ArrayList<ArrayList<Edge>> graph) {

		ArrayList<String> ans = new ArrayList<>();
		boolean vs[] = new boolean[graph.size() + 1];
		String comp = new String();
		for (int i = 0; i < graph.size(); i++) {
			if (vs[i] == false) {
				String s = getvisitedcomponents(graph, i, vs, comp);
				ans.add(s);
			}
		}
		return ans;
	}

	public static boolean iscyclic(ArrayList<ArrayList<Edge>> graph) {
		boolean vs[] = new boolean[graph.size() + 1];

		for (int i = 0; i < graph.size(); i++) {
			if (vs[i] == false) {
				boolean iscycle = checkiscyclic(graph, vs, i);
				if (iscycle) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private static boolean checkiscyclic(ArrayList<ArrayList<Edge>> graph, boolean[] vs, int i) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(i);
		while (queue.size() > 0) {
			int front = queue.removeFirst();

			if (vs[front]) {
				return true;
			} else {
				vs[front] = true;
			}

			for (int j = 0; j < graph.get(front).size(); j++) {
				Edge ev = graph.get(front).get(j);
				if (vs[ev.n] == false) {
					queue.add(ev.n);
				}
			}
		}
		return false;
	}

	public static ArrayList<Integer> iscyclicreturn(ArrayList<ArrayList<Edge>> graph) {
		boolean vs[] = new boolean[graph.size()];
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < graph.size(); i++) {
			if (vs[i] == false) {
				int num = addneighbour(graph, vs, i);
				ans.add(num);
			}
		}

		return ans;
	}

	private static int addneighbour(ArrayList<ArrayList<Edge>> graph, boolean[] vs, int i) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(i);
		int num = 0;
		while (queue.size() > 0) {
			int front = queue.removeFirst();

			if (vs[front]) {
				continue;
			} else {
				vs[front] = true;
				num++;
			}

			for (int j = 0; j < graph.get(front).size(); j++) {
				Edge ev = graph.get(front).get(j);

				if (vs[ev.n] == false) {
					queue.add(ev.n);
				}
			}
		}
		return num;
	}

	public static int Astronaut(int a1[], int a2[]) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < a1.length; i++) {
			int v1 = a1[i];
			int v2 = a2[i];
			edge(graph, v1, v2, 0);
		}
		display(graph);
		ArrayList<Integer> vertex = iscyclicreturn(graph);
		for (int i = 0; i < vertex.size(); i++) {
			System.out.print(vertex.get(i) + " ");
		}
		int count = 0;
		for (int i = 0; i < vertex.size(); i++) {
			for (int j = 0; j < vertex.size(); j++) {
				count += vertex.get(i) * vertex.get(j);
			}
		}
		return count;
	}

	public static class Helper {
		int level;
		int src;

		public Helper(int src, int level) {
			this.src = src;
			this.level = level;
		}
	}

	public static boolean isbipartgraph(ArrayList<ArrayList<Edge>> graph) {
		int vs[] = new int[graph.size()];

		for (int i = 0; i < vs.length; i++) {
			vs[i] = -1;
		}

		for (int i = 0; i < graph.size(); i++) {
			if (vs[i] == -1) {
				boolean isbipart = checkisbipart(graph, vs, i);
				if (isbipart) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private static boolean checkisbipart(ArrayList<ArrayList<Edge>> graph, int[] vs, int src) {
		LinkedList<Helper> queue = new LinkedList<>();
		queue.add(new Helper(src, 0));

		while (queue.size() > 0) {
			Helper front = queue.removeFirst();

			if (vs[front.src] != -1) {
				if (vs[front.src] % 2 != vs[front.level] % 2) {
					return false;
				}
			} else {
				vs[front.src] = front.level;
			}

			for (int i = 0; i < graph.get(front.src).size(); i++) {
				Edge ev = graph.get(front.src).get(i);

				if (vs[ev.n] == -1) {
					queue.add(new Helper(ev.n, front.level + 1));
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			graph.add(new ArrayList<>());

		}
		edge(graph, 0, 1, 10);
		edge(graph, 1, 2, 10);
		edge(graph, 0, 3, 40);
		edge(graph, 2, 3, 10);
//		edge(graph, 3, 4, 2);
		edge(graph, 4, 5, 3);
		edge(graph, 5, 6, 3);
		edge(graph, 4, 6, 8);
		edge(graph, 7, 8, 22);
		display(graph);
//		System.out.print(bfs(graph, 0, 6));
		int arr[][] = { { 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0, 2 }, { 0, 1, 0, 1, 0, 0 },
				{ 2, 0, 1, 1, 0, 0 } };

		firestorm(arr);

		System.out.println("------------------------------------");

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		ArrayList<String> list = getconnectedcom(graph);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + " ");
		}
		System.out.println(iscyclic(graph));
		ArrayList<Integer> ans = iscyclicreturn(graph);

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		int a1[] = { 1, 6, 8, 2, 9, 10, 0 };
		int a2[] = { 2, 9, 3, 5, 5, 3, 11 };
		System.out.println(Astronaut(a1, a2));
		System.out.println(isbipartgraph(graph));

	}

}
