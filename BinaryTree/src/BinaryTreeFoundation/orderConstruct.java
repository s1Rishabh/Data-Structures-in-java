package BinaryTreeFoundation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import BinaryTreeFoundation.BasicQuestions.Node;

public class orderConstruct {

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

	public static Node construct(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int prelow, int prehigh,
			int inlow, int inhigh) {
		if (prelow > prehigh || inlow > inhigh) {
			return null;
		}
		Node root = new Node(preorder.get(prelow));

		int lhs = 0;
		for (int i = prelow; i < prehigh; i++) {
			if (preorder.get(prelow) == inorder.get(i)) {
				break;
			} else {
				lhs++;
			}
		}

		root.left = construct(preorder, inorder, prelow + 1, prelow + lhs, inlow, inlow + lhs - 1);
		root.right = construct(preorder, inorder, prelow + lhs + 1, prehigh, inlow + lhs + 1, inhigh);
		return root;
	}

	public static Node construct1(ArrayList<Integer> postorder, ArrayList<Integer> Inorder, int postlow, int posthigh,
			int inlow, int inhigh) {
		if (postlow > posthigh || inlow > inhigh) {
			return null;
		}
		Node root = new Node(postorder.get(posthigh));
		int lhs = 0;
		for (int i = inlow; i < inhigh; i++) {
			if (postorder.get(posthigh) == Inorder.get(i)) {
				break;
			} else {
				lhs++;
			}
		}
		root.left = construct1(postorder, Inorder, postlow, postlow + lhs - 1, inlow, inlow + lhs - 1);
		root.right = construct1(postorder, Inorder, postlow + lhs, posthigh - 1, inlow + lhs + 1, inhigh);
		return root;
	}

	public static Node construct2(ArrayList<Integer> preorder, ArrayList<Integer> postorder, int prelow, int prehigh,
			int postlow, int posthigh) {
//
//		if (prelow > prehigh || postlow > posthigh) {
//			return null;
//		}

		if (prelow > prehigh) {
			return null;
		}

		if (prelow == prehigh) {
			Node root = new Node(preorder.get(prelow));
			root.left = null;
			root.right = null;
			return root;

		}
		Node root = new Node(preorder.get(prelow));
		int lhs = 0;
		for (int i = postlow; i < posthigh; i++) {
			if (preorder.get(prelow + 1) == postorder.get(i)) {
				break;
			} else {
				lhs++;
			}
		}

		root.left = construct2(preorder, postorder, prelow + 1, prelow + lhs, postlow, postlow + lhs - 1);
		root.right = construct2(preorder, postorder, prelow + lhs + 1, prehigh, postlow + lhs, posthigh - 1);
		return root;
	}

	public static Node construct3(ArrayList<Integer> data, ArrayList<Integer> parent) {
		Node root = null;
		Node[] narr = new Node[101];
		for (int i = 0; i < data.size(); i++) {
			narr[data.get(i)] = new Node(parent.get(i));
		}

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) == -1) {
				root = narr[data.get(i)];
			} else {
				Node node = narr[data.get(i)];
				Node par = narr[parent.get(i)];
				if (par.left == null) {
					par.left = node;
				} else {
					par.right = node;
				}
			}
		}
		return root;
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {
		LinkedList<Node> list = new LinkedList<>();
		list.add(root);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> base = new ArrayList<>();
		base.add(root.data);
		ans.add(base);
		int idx = 0;
		while (list.size() > 0) {
			Node front = list.removeFirst();
			if (idx % 2 == 0) {
				if (front.right != null) {
					list.add(front.right);
					base.add(front.right.data);
				} else if (front.left != null) {
					list.add(front.left);
					base.add(front.left.data);
				}
				idx++;

				ans.add(base);
			} else {

				if (front.left != null) {
					list.add(front.left);
					base.add(front.left.data);
				} else if (front.right != null) {
					list.add(front.right);
					base.add(front.right.data);
				}
				idx++;
			}
			ans.add(base);
		}
		return ans;
	}

	public static void main(String args[]) {

		int pre[] = { 50, 25, 12, 37, 30, 40, 75, 62, 60, 70, 87, 90 };
		int in[] = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87, 90 };
		int post[] = { 12, 30, 40, 37, 25, 60, 70, 62, 90, 87, 75, 50 };
//		int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
//		int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
		ArrayList<Integer> preorder = new ArrayList<>();
		ArrayList<Integer> inorder = new ArrayList<>();
		ArrayList<Integer> postorder = new ArrayList<>();
		for (int i = 0; i < pre.length; i++) {
			preorder.add(pre[i]);
		}
		for (int i = 0; i < in.length; i++) {
			inorder.add(in[i]);
		}
		for (int i = 0; i < post.length; i++) {
			postorder.add(post[i]);
		}
		Node root = construct2(preorder, postorder, 0, preorder.size() - 1, 0, postorder.size() - 1);

		int data[] = { 30, 40, 37, 12, 25, 75, 62, 87, 50 };
		int parent[] = { 37, 37, 25, 25, 50, 50, 75, 75, -1 };

		ArrayList<Integer> data1 = new ArrayList<>();
		ArrayList<Integer> parent1 = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			data1.add(data[i]);
		}
		for (int i = 0; i < parent.length; i++) {
			parent1.add(parent[i]);
		}
		Node root1 = construct3(data1, parent1);
		display(root1); 
		
		
		
	}

}
