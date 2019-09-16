package BinaryTreeFoundation;

import java.util.ArrayList;
import java.util.Collections;

import BinaryTreeFoundation.BasicQuestions.Node;

public class goodQuestions {
	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node construct(int arr[]) {
		Node root = null;
		ArrayList<Node> nlist = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				nlist.remove(nlist.size() - 1);
			} else {
				Node res = new Node(arr[i]);
				if (nlist.size() == 0) {
					root = res;
				} else {
					Node prev = nlist.get(nlist.size() - 1);

					if (prev.left == null) {
						prev.left = res;
					} else if (prev.right == null) {
						prev.right = res;
					}
				}
				nlist.add(res);
			}
		}
		return root;
	}

	public static void display(Node root) {
		if (root == null) {
			return;
		}
		String s = "";
		s += root.left != null ? root.left.data : " . ";
		s += " => " + root.data + " <= ";
		s += root.right != null ? root.right.data : " . ";
		System.out.println(s);
		display(root.left);
		display(root.right);
	}

	public static int height(Node root) {
		if (root == null) {
			return 0;
		}

		int lh = height(root.left);
		int rh = height(root.right);
		return Math.max(lh, rh) + 1;
	}

	public static int depth(Node root) {
		if (root == null) {
			return -1;
		}

		int lh = depth(root.left);
		int rh = depth(root.right);
		return Math.max(lh, rh) + 1;
	}

	public static Node removeleave(Node root) {
		if (root == null) {
			return null;
		}

		else if (root.left == null && root.right == null) {
			root = null;
			return null;
		}

		else if (root.left != null && root.right == null) {
			root.left = removeleave(root.left);
		} else if (root.left == null && root.right != null) {
			root.right = removeleave(root.right);
		} else {
			root.left = removeleave(root.left);
			root.right = removeleave(root.right);
		}
		return root;
	}

	public static void printsinglechild(Node root) {
		if (root == null) {
			return;
		} else if (root.left != null && root.right == null) {
			System.out.print(root.data + "@");
			printsinglechild(root.left);
		} else if (root.left == null && root.right != null) {
			System.out.print(root.data + "@");
			printsinglechild(root.right);
		} else {
			printsinglechild(root.left);
			printsinglechild(root.right);
		}
	}

	public static ArrayList<Integer> n2rpath(Node root, int value) {
		if (root == null) {
			return null;
		}
		if (root.data == value) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.data);
			return list;
		}
		if (root.left != null) {
			ArrayList<Integer> left = n2rpath(root.left, value);

			if (left != null) {
				left.add(root.data);
				return left;
			}
		}

		if (root.right != null) {
			ArrayList<Integer> right = n2rpath(root.right, value);
			if (right != null) {
				right.add(root.data);
				return right;
			}
		}
		return null;
	}

	public static void kthdown(Node root, int k) {
		if (root == null) {
			return;
		}

		if (k == 0) {
			System.out.print(root.data + "@");
			return;
		}
		kthdown(root.left, k - 1);
		kthdown(root.right, k - 1);
	}

	public static ArrayList<Node> n2rpathnode(Node root, int value) {
		if (root == null) {
			return null;
		}

		if (root.data == value) {
			ArrayList<Node> list = new ArrayList<>();
			list.add(root);
			return list;
		}

		if (root.left != null) 
		{
			ArrayList<Node> ls = n2rpathnode(root.left, value);
			if (ls != null) {
				ls.add(root);
				return ls;
			}
		}

		if (root.right != null) 
		{
			ArrayList<Node> rs = n2rpathnode(root.right, value);
			if (rs != null) {
				rs.add(root);
				return rs;
			}
		}
		return null;
	}

	public static void kthdownforkthfar(Node root, Node prohibtor, int k) {
		if (root == null || root == prohibtor) {
			return;
		}

		if (k == 0) {
			System.out.print(root.data + "@");
			return;
		}
		kthdownforkthfar(root.left, prohibtor, k - 1);
		kthdownforkthfar(root.right, prohibtor, k - 1);
	}

	public static void kthfar(Node root, int k, int value) {
		ArrayList<Node> list = n2rpathnode(root, value);
		for (int i = 0; i <= k && i < list.size(); i++)
		{
			if (i == 0) 
			{
				kthdownforkthfar(list.get(i), null, k - i);
			} else {
				kthdownforkthfar(list.get(i), list.get(i - 1), k - i);
			}
		}
	}

	static void print(Node root, int low, int high, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}

		if (low <= root.data && high >= root.data) {
			ans.add(root.data);
		}

		print(root.left, low, high, ans);
		print(root.right, low, high, ans);
	}

	static void printNearNodes(Node root, int low, int high) {
		ArrayList<Integer> list = new ArrayList<>();
		print(root, low, high, list);

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "@");
		}
	}

	public static void printinrange(Node root, int low, int high) {
		if (root == null) {
			return;
		}

		if (low <= root.data && high >= root.data) {
			System.out.print(root.data + "@");
		}

		printinrange(root.left, low, high);
		printinrange(root.right, low, high);
	}

	public static void printinrange(Node root, int low, int high, ArrayList<Integer> path, int sum) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			path.add(root.data);
			sum = sum + root.data;
			if (sum >= low && sum <= high) {
				for (int i = 0; i < path.size(); i++) {
					System.out.print(path.get(i) + " ");
				}
				System.out.println();
			}
			return;
		}
		path.add(root.data);
		printinrange(root.left, low, high, path, sum + root.data);
		printinrange(root.right, low, high, path, sum + root.data);
	}

	public static void main(String[] args) {
//		int arr[] = { 50, 25, 12, 13, -1, -1, 37, 30, 12, -1, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1,
//				-1, -1 };

		int arr[] = { 1, 2, 4, -1, 5, 6, 8, 20, 22, -1, -1, 21, -1, -1, 9, 12, 14, -1, 15, 18, -1, 19, -1, -1, -1, 13,
				-1, -1, -1, 7, 10, -1, 11, 16, -1, 17, -1, -1, -1, -1, -1, 3, -1 };
		Node root = construct(arr);
		display(root);
		System.out.println(height(root));
		System.out.println(depth(root));
//		removeleave(root);
		printsinglechild(root);
		System.out.println();
		ArrayList<Integer> ans = n2rpath(root, 19);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + "@");
		}
		System.out.println();
		kthdown(root, 3);
		System.out.println();
		kthfar(root, 3, 9);
		System.out.println();
		printinrange(root, 6, 19);
		System.out.println();
		printNearNodes(root, 6, 19);
		System.out.println();
		ArrayList<Integer> x = new ArrayList<>();
		printinrange(root, 6, 19, x, -1);
	}

}
