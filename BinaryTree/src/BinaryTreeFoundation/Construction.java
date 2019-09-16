package BinaryTreeFoundation;

import java.util.ArrayList;

public class Construction {

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
	public static void display(Node root)
	{
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
	}

}
