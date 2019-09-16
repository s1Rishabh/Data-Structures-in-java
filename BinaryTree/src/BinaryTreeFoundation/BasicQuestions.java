package BinaryTreeFoundation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BasicQuestions {

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node constructBtree(ArrayList<Integer> dlist) {
		Node root = null;
		ArrayList<Node> nlist = new ArrayList<Node>();

		for (int i = 0; i < dlist.size(); i++) {
			if (dlist.get(i) == -1) {
				nlist.remove(nlist.size() - 1);
			} else {
				Node res = new Node(dlist.get(i));

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

	public static void display(Node node) {
		if (node == null) {
			return;

		}

		String str = "";

		str += node.left != null ? node.left.data : ".";
		str += " => " + node.data + " <= ";
		str += node.right != null ? node.right.data : ".";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static int sz = 0;

	public static int size(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.left != null) {
			sz++;
			size(root.left);
		}

		if (root.right != null) {
			sz++;
			size(root.right);
		}
		return sz + 1;
	}

	public static boolean isempty(Node root) {
		if (root == null) {
			return true;
		}
		return false;
	}

	public static int mx = Integer.MIN_VALUE;

	public static int max(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.data > mx) {
			mx = root.data;
		}

		if (root.left != null) {
			max(root.left);
		}
		if (root.right != null) {
			max(root.right);
		}
		return mx;
	}

	public static int ls = 0, rs = 0, height = 0;

	public static int height(Node root) {
		if (root == null) {
			return 0;

		}
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Math.max(lh, rh);
	}

	public static Node removeleaves(Node root) {

		if (root == null) {

			return null;
		}
		if (root.left == null && root.right == null) {

			root = null;
			return null;
		}
		if (root.left != null) {

			root.left = removeleaves(root.left);
		}
		if (root.right != null) {
			root.right = removeleaves(root.right);
		}
		return root;
	}

	public static void printonlychild(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right != null) {
			System.out.print(root.data + " ");
		}
		if (root.left != null && root.right == null) {
			System.out.println(root.data + " ");
		}
		if (root.left != null) {
			printonlychild(root.left);
		}
		if (root.right != null) {
			printonlychild(root.right);
		}
	}

	public static boolean find(Node root, int val) {
		if (root.left == null) {
			return false;
		}
		if (root.right == null) {
			return false;
		}
		if (root.data == val) {
			return true;
		}
		if (root.left != null) {
			boolean ls = find(root.left, val);
			if (ls) {
				return true;
			}
		}
		if (root.right != null) {
			boolean rs = find(root.right, val);
			if (rs) {
				return true;
			}
		}

		return false;
	}

	public static ArrayList<Integer> n2rpath(Node root, int val) {
		if (root == null) {
			return null;
		}
		if (root.data == val) {
			ArrayList<Integer> myans = new ArrayList<Integer>();
			myans.add(root.data);
			return myans;
		}
		if (root.left != null) {
			ArrayList<Integer> lf = n2rpath(root.left, val);
			if (lf != null) {
				lf.add(root.data);
				return lf;
			}
		}
		if (root.right != null) {
			ArrayList<Integer> rf = n2rpath(root.right, val);
			if (rf != null) {
				rf.add(root.data);
				return rf;
			}
		}
		return null;
	}

	public static ArrayList<Node> n2rpathnode(Node root, int val) {
		if (root == null) {
			return null;
		}
		if (root.data == val) {
			ArrayList<Node> myans = new ArrayList<Node>();
			myans.add(root);
			return myans;
		}
		ArrayList<Node> lf = n2rpathnode(root.left, val);
		if (lf != null) {
			lf.add(root);
			return lf;
		}
		ArrayList<Node> rf = n2rpathnode(root.right, val);
		if (rf != null) {
			rf.add(root);
			return rf;
		}
		return null;
	}

	public static void kthdown(Node root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		kthdown(root.left, k - 1);
		kthdown(root.right, k - 1);
	}

	public static void kthdown1(Node root, Node pred, int k) {
		if (root == null || root == pred) {
			return;
		}
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		kthdown1(root.left, pred, k - 1);
		kthdown1(root.right, pred, k - 1);
	}

	public static void kthfar(Node root, int d, int k) {
		ArrayList<Node> path = n2rpathnode(root, d);

		for (int i = 0; i <= k && i < path.size(); i++) {
			if (i == 0) {
				kthdown1(path.get(i), null, k - i);
			} else {
				kthdown1(path.get(i), path.get(i - 1), k - i);
			}
		}
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

	public static void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void post(Node root) {
		if (root == null) {
			return;
		}
		post(root.left);
		post(root.right);
		System.out.print(root.data + " ");
	}

	public static void Inorder(Node root) {
		if (root == null) {
			return;
		}

		Inorder(root.left);
		System.out.print(root.data + " ");
		Inorder(root.right);
	}
	// we will get pre and in order:
	// 50 25 12 10 37 30 75 62 87 90
	// 10 12 25 30 37 50 62 75 87 90

//	public static Node constructBtree(ArrayList<Integer> dlist) {
//		Node root = null;
//		ArrayList<Node> nlist = new ArrayList<Node>();
//
//		for (int i = 0; i < dlist.size(); i++) {
//			if (dlist.get(i) == -1) {
//				nlist.remove(nlist.size() - 1);
//			} else {
//				Node res = new Node(dlist.get(i));
//
//				if (nlist.size() == 0) {
//					root = res;
//				} else {
//					Node prev = nlist.get(nlist.size() - 1);
//
//					if (prev.left == null) {
//						prev.left = res;
//
//					} else if (prev.right == null) {
//						prev.right = res;
//					}
//
//				}
//				nlist.add(res);
//			}
//
//		}
//		return root;
//	}

	public static Node construct1(ArrayList<Integer> pre, ArrayList<Integer> in, int prelow, int prehigh, int inlow,
			int end) {
		if (prelow > prehigh || inlow > end) {
			return null;
		}

		Node root = new Node(pre.get(prelow));

		int lhs = 0;
		for (int i = inlow; i < end; i++) {
			if (in.get(i) == pre.get(prelow)) {
				break;
			} else {
				lhs++;
			}
		}
//		while (in.get(inlow + lhs) != pre.get(prelow)) {
//			lhs++;
//		}
		root.left = construct1(pre, in, prelow + 1, prelow + lhs, inlow, inlow + lhs - 1);
		root.right = construct1(pre, in, prelow + lhs + 1, prehigh, inlow + lhs + 1, end);

		return root;
	}

	public static Node construct2(ArrayList<Integer> post, ArrayList<Integer> in, int postt, int poend, int inst,
			int end) {

		if (postt > poend || inst > end) {
			return null;
		}
		Node root = new Node(post.get(poend));
		int lhs = 0;
		for (int i = inst; i <= end; i++) {
			if (in.get(i) == post.get(i)) {
				break;
			} else {
				lhs++;
			}
		}
		root.left = construct2(post, in, postt, postt + lhs - 1, inst, inst + lhs - 1);
		root.right = construct2(post, in, postt + lhs, poend - 1, inst + lhs + 1, end);
		return root;
	}

	public static Node construct3(ArrayList<Integer> pre, ArrayList<Integer> post, int prest, int preend, int st,
			int end) {

		if (prest > preend) {
			return null;
		}

		if (prest == preend) {
			Node root = new Node(pre.get(prest));
			root.left = null;
			root.right = null;
			return root;
		}
		Node root = new Node(pre.get(prest));
		int lhs = 0;
		for (int i = st; i <= end - 1; i++) {
			if (pre.get(prest + 1) == post.get(i)) {
				break;
			} else {
				lhs++;
			}
		}
		root.left = construct3(pre, post, prest + 1, prest + lhs, st, st + lhs - 1);
		root.right = construct3(pre, post, prest + lhs + 1, preend, st + lhs, end - 1);
		return root;
	}

	public static Node construct4(ArrayList<Integer> data, ArrayList<Integer> parent) {
		Node root = null;
		Node[] narr = new Node[101];
		narr = null;

		for (int i = 0; i < data.size(); i++) {
			narr[data.get(i)] = new Node(data.get(i));
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

	// on2 diameter

	public static int diameter(Node root) {
		if (root == null) {
			return 0;
		}

		int lh = height(root.left);

		int rh = height(root.right);

		int ld = diameter(root.left);

		int rd = diameter(root.right);
		int mydia = lh + rh + 1;
		return Math.max(mydia, Math.max(ld, rd));
	}

	// on wali style
	public static class Heapmover {
		int ht = 0;
		int dia = 0;
	}

	public static Heapmover diameter1(Node root) {
		if (root == null) {
			Heapmover bp = new Heapmover();
			bp.dia = 0;
			bp.ht = 0;
			return bp;
		}
		Heapmover lp = diameter1(root.left);
		Heapmover rp = diameter1(root.left);
		Heapmover mp = new Heapmover();
		mp.dia = Math.max(lp.ht + rp.ht + 1, Math.max(lp.dia, rp.dia));
		mp.ht = Math.max(lp.ht, rp.ht) + 1;
		return mp;

	}

	// isbalanced Bst using (on) approach
	public static class Balpair {
		int ht = 0;
		boolean bal;
	}

	public static Balpair isbalanced(Node root) {
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

	// isBST using o(n) approach

	public static class BSTpair {
		boolean bal;
		int min, max;
		int bstroot = -1;
		int bstsize = 0;
	}

	public static BSTpair isBST(Node root) {
		if (root == null) {
			BSTpair bp = new BSTpair();
			bp.bal = true;
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;
			bp.bstroot = -1;
			bp.bstsize = 0;
			return bp;
		}

		BSTpair lp = isBST(root.left);
		BSTpair rp = isBST(root.right);
		BSTpair bp = new BSTpair();
		bp.min = Math.min(root.data, Math.min(lp.min, rp.min));
		bp.max = Math.max(root.data, Math.max(lp.max, rp.max));
		bp.bal = lp.bal && rp.bal && lp.max < root.data && rp.min > root.data;

		if (bp.bal == true) {
			bp.bstroot = root.data;
			bp.bstsize = lp.bstsize + rp.bstsize + 1;
		} else {
			if (lp.bstsize > rp.bstsize) {
				bp.bstroot = lp.bstroot;
				bp.bstsize = lp.bstsize;
			} else {
				bp.bstroot = rp.bstroot;
				bp.bstsize = rp.bstsize;
			}
		}
		return bp;
	}

	public static void main(String[] args) {
		int arr[] = { 50, 25, 12, 13, -1, -1, 37, 30, 12, -1, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1,
				-1, -1 };
		ArrayList<Integer> dlist = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			dlist.add(arr[i]);
		}
//		Node root = constructBtree(dlist);
//		display(root); 

//		int arr1[] = { 50, 25, 12, 10, 15, 15, 16, 37, 24, 40, 75, 62, 60, 70, 87, 90 };
//		int arr2[] = { 10, 12, 14, 15, 16, 25, 24, 37, 40, 50, 75, 60, 62, 70, 87, 90 }; 

		int arr1[] = { 50, 25, 12, 37, 30, 40, 75, 62, 60, 70, 87, 90 };
		int arr2[] = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87, 90 };
		// int arr3[] = { 10, 12, 30, 37, 25, 62, 10, 87, 75, 50 };
		int arr3[] = { 12, 37, 25, 62, 87, 75, 50 };
		ArrayList<Integer> preorder = new ArrayList<Integer>();
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		ArrayList<Integer> postorder = new ArrayList<Integer>();

		for (int i = 0; i < arr1.length; i++) {
			preorder.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			inorder.add(arr2[i]);
		}

//		
//		for (int i = 0; i < arr3.length; i++) {
//			postorder.add(arr3[i]);
//		}

//		System.out.println(size(root));
//		System.out.println(isempty(root));
//		System.out.println(max(root));
//		System.out.println(height(root));
//		removeleaves(root);
//		display(root); 
//		printonlychild(root);
//		System.out.println(find(root, 37));
//
//		ArrayList<Integer> myans = n2rpath(root, 60);
//
//		for (int i = 0; i < myans.size(); i++) {
//			System.out.print(myans.get(i) + " ");
//		}
//		kthdown(root, 2);
//		kthfar(root, 9, 3) ; 
//		preorder(root);
//		post(root);
//		Inorder(root); 
		Node root1 = construct1(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
		display(root1);

//		Node root2 = construct2(postorder, inorder, 0, postorder.size() - 1, 1, inorder.size() - 1);
//		display(root2);
//		Node root3 = construct3(preorder, postorder, 0, preorder.size() - 1, 0, postorder.size() - 1);
//		display(root3); 

		BSTpair bp = isBST(root1);
		System.out.println(bp.bal + " ");
		System.out.println(bp.bstroot + " ");
		System.out.println(bp.bstsize + " ");

	}
}