package BinarySearchTreesFoundation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Construction {

	public static class Node {

		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	public static Node construct(int arr[], int i, int j) {
		if (i > j) {
			return null;
		}
		int mid = (i + j) / 2;
		Node root = new Node(arr[mid]);
		root.left = construct(arr, i, mid - 1);
		root.right = construct(arr, mid + 1, j);
		return root;
	}

	public static boolean find(Node root, int val) {

		if (root == null) {
			return false;
		}
		if (val == root.val) {
			return true;
		}
		if (val < root.val) {
			boolean ls = find(root.left, val);
			if (ls) {
				return true;
			}
		} else {
			boolean rs = find(root.right, val);
			if (rs) {
				return true;
			}
		}

		return false;
	}

	public static int max(Node root) {

		if (root.right != null) {
			return max(root.right);
		} else {
			return root.val;
		}
	}

	public static int min(Node root) {

		if (root.left != null) {
			return min(root.left);
		} else {
			return root.val;
		}
	}

	public static void display(Node root) {

		if (root == null) {
			return;
		}
		String s = "";
		s += root.left != null ? root.left.val : " . ";
		s += " => " + root.val + " <= ";
		s += root.right != null ? root.right.val : " . ";
		System.out.println(s);

		display(root.left);
		display(root.right);
	}

	public static void printinrange(Node root, int low, int high) {
		if (root == null) {
			return;
		}

		if (root.val < low) {
			printinrange(root.right, low, high);
		} else if (root.val > high) {
			printinrange(root.left, low, high);
		} else {
			System.out.print(root.val + "@");
			printinrange(root.left, low, high);
			printinrange(root.right, low, high);
		}
	}

	static int sum = 0;

	public static void reverseordersum(Node root) {
		if (root == null) {
			return;
		}

		reverseordersum(root.right);
		Node temp = new Node(sum);
		sum += root.val;
		root.val = temp.val;
		reverseordersum(root.left);
	}

	public static void targetsum(Node oNode, Node root, int target) {
		if (root == null) {
			return;
		}
		int com = target - root.val;

		if (root.val <= com) {
			if (find(oNode, com)) {
				System.out.println(root.val + " " + com);
			}
		}

		targetsum(oNode, root.left, target);
		targetsum(oNode, root.right, target);
	}

	public static void filler(Node root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		filler(root.left, list);
		list.add(root.val);
		filler(root.right, list);
	}

	public static void Targetsum2(Node root, int target) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		filler(root, list);

		int l = 0;
		int r = list.size() - 1;

		while (l <= r) {

			if (list.get(l) + list.get(r) < target) {
				l++;
			} else if (list.get(l) + list.get(r) > target) {
				r--;
			} else {
				System.out.println(list.get(l) + " " + list.get(r));
				l++;
				r--;
			}

		}

	}

	public static class Inorderstack {
		Node root;
		int state = 0;

		public Inorderstack(Node root) {
			this.root = root;
		}
	}

	public static void IterativeStack(LinkedList<Inorderstack> stack) {
		Inorderstack front = stack.remove();

		while (stack.size() > 0) {
			if (front.state == 0) {
				Node r = front.root.left;
				Inorderstack leftchild = new Inorderstack(r);
				stack.add(leftchild);
				front.state++;
			} else if (front.state == 1) {
				front.state++;
				return;
			} else if (front.state == 2) {
				Node r = front.root.right;
				Inorderstack rightchild = new Inorderstack(r);
				stack.add(rightchild);
				front.state++;
			} else {
				stack.removeLast();
			}
		}
	}

	public static void IterativereverseStack(LinkedList<Inorderstack> stack) {
		Inorderstack front = stack.remove();

		while (stack.size() > 0) {
			if (front.state == 0) {
				Node r = front.root.right;
				Inorderstack rightchild = new Inorderstack(r);
				stack.add(rightchild);
				front.state++;

			} else if (front.state == 1) {
				front.state++;
				return;
			} else if (front.state == 2) {
				Node r = front.root.left;
				Inorderstack leftchild = new Inorderstack(r);
				stack.add(leftchild);
				front.state++;
			} else {
				stack.removeLast();
			}
		}
	}

	public static Node addnode(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (root.val < data) {
			root.right = addnode(root.right, data);
		} else {
			root.left = addnode(root.left, data);
		}
		return root;
	}

	public static Node remove(Node root, int data) {
		if (root == null) {
			return null;
		}

		if (root.val == data) {
			if (root.left == null && root.right == null) {
				root = null;
				return root;
			} else if (root.left != null && root.right == null) {
				Node mnxt = root.left;
				root = mnxt;
				mnxt = null;
				return mnxt;
			} else if (root.left != null && root.right == null) {
				Node mnxt = root.right;
				root = mnxt;
				mnxt = null;
				return mnxt;

			} else {
				int lmax = max(root);
				root.left.val = lmax;
				root.left = remove(root.left, lmax);

			}

			// else {
			// Node temp=root;
			// root=root.left!=null?root.left:root.right;
			//
			// }
		}

		if (root.val < data) {
			root.right = remove(root.right, data);
		} else {
			root.left = remove(root.left, data);
		}
		return root;

	}

//	public static int c=0;
	public static int countBST(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int c = 0;
		for (int i = 0; i < n; i++) {
			c += countBST(i) * countBST(n - i - 1);

		} 
		return c;
	}

	public static void main(String args[]) {
		int arr[] = { 12, 25, 37, 50, 62, 75, 87 };

		Node root = construct(arr, 0, arr.length - 1);
		display(root);
		System.out.println(find(root, 12));
		System.out.println(max(root));
		System.out.println(min(root));
//		printinrange(root, 12, 37);
//		reverseordersum(root);
//		System.out.println();
//		display(root);
		targetsum(root, root, 100);

		LinkedList<Inorderstack> stack = new LinkedList<>();
		Inorderstack st = new Inorderstack(root);
		stack.add(st);
		IterativeStack(stack);

	}
}
