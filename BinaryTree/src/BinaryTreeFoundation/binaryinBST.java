package BinaryTreeFoundation;

import java.util.ArrayList;

public class binaryinBST {

	// isBST using o(n) approach

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

	public static class Heapmover {
		boolean isbal;
		int max;
		int min;
		int bstroot = -1;
		int size = 0;
	}

	public static Heapmover isBST(Node root) {
		if (root == null) {
			Heapmover bp = new Heapmover();
			bp.isbal = true;
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;
			bp.bstroot = -1;
			bp.size = 0;
			return bp;
		}
		Heapmover ls = isBST(root.left);
		Heapmover rs = isBST(root.right);
		Heapmover hp = new Heapmover();

		hp.max = Math.max(root.data, Math.max(ls.max, rs.max));
		hp.min = Math.min(root.data, Math.min(ls.min, rs.min));
		hp.isbal = ls.isbal && rs.isbal && ls.max < root.data && rs.min > root.data;

		if (hp.isbal == true) {
			hp.bstroot = root.data;
			hp.size = ls.size + rs.size + 1;
		} else {
			if (ls.size > rs.size) {
				hp.bstroot = ls.bstroot;
				hp.size = ls.size;
			} else {
				hp.bstroot = rs.bstroot;
				hp.size = rs.size;
			}
		}
		return hp;
	}

	// on

	public static class Balpair {
		int ht = 0;
		boolean bal;
	}
	
	public static Balpair isbalanced(Node root)
	{
		if (root == null) {
			Balpair bp = new Balpair();
			bp.bal = true;
			return bp;

		}
		Balpair lp = isbalanced(root.left);
		Balpair rp = isbalanced(root.right);
		int gap = lp.ht - rp.ht;
		Balpair mp = new Balpair();
		mp.ht = Math.max(lp.ht, rp.ht) + 1;
		mp.bal = lp.bal && rp.bal && gap >= -1 && gap <= 1;
		return mp;
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

	public static void main(String[] args) {
		int arr[] = { 50, 25, 12, 13, -1, -1, 37, 30, 12, -1, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1,
				-1, -1 };
		Node root = construct(arr);
		display(root);
		Heapmover ans = isBST(root);
		System.out.println(ans.isbal);
		System.out.println(ans.max);
		System.out.println(ans.min);
	}
}
