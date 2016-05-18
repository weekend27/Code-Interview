package chapter_1_stackandqueue;

import java.util.HashMap;
import java.util.Stack;

public class Problem_08_MaxTree {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getMaxTree(int[] arr) {
		Node[] nArr = new Node[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nArr[i] = new Node(arr[i]);
		}
		
		Stack<Node> stack = new Stack<>();
		HashMap<Node, Node> lBigMap = new HashMap<>();
		HashMap<Node, Node> rBigMap = new HashMap<>();
		// set left big map (the first node bigger than the current node in the left part)
		for (int i = 0; i < nArr.length; i++) {
			Node currNode = nArr[i];
			while ((!stack.isEmpty()) && stack.peek().value < currNode.value) {
				popStackSetMap(stack, lBigMap);
			}
			stack.push(currNode);
		}
		while (!stack.isEmpty()) {
			popStackSetMap(stack, lBigMap);
		}
		// set right big map (the first node bigger than the current node in the right part)
		for (int i = nArr.length - 1; i >= 0; i--) {
			Node currNode = nArr[i];
			while ((!stack.isEmpty()) && stack.peek().value < currNode.value) {
				popStackSetMap(stack, rBigMap);
			}
			stack.push(currNode);
		}
		while (!stack.isEmpty()) {
			popStackSetMap(stack, rBigMap);
		}
		
		Node head = null;
		for (int i = 0; i < nArr.length; i++) {
			Node currNode = nArr[i];
			Node left = lBigMap.get(currNode);
			Node right = rBigMap.get(currNode);
			
			if (left == null && right == null) { // the max node is the root node
				head = currNode;
			} else if (left == null) {
				if (right.left == null) {
					right.left = currNode;
				} else {
					right.right = currNode;
				}
			} else if (right == null) {
				if (left.left == null) {
					left.left = currNode;
				} else {
					left.right = currNode;
				}
			} else {
				Node parent = left.value < right.value ? left : right;
				if (parent.left == null) {
					parent.left = currNode;
				} else {
					parent.right = currNode;
				}
			}
		}
		return head;
	}
	
	
	public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
		Node popNode = stack.pop();
		if (stack.isEmpty()) {
			map.put(popNode, null);
		} else {
			map.put(popNode, stack.peek());
		}
	}
	
	// test
	public static void printPreOrder(Node head) {
		if (head == null) {
			return ;
		}
		System.out.print(head.value + " ");
		printPreOrder(head.left);
		printPreOrder(head.right);
	}
	
	public static void printInOrder(Node head) {
		if (head == null) {
			return ;
		}
		printInOrder(head.left);
		System.out.print(head.value + " ");
		printInOrder(head.right);
	}
	
	public static void printPosOrder(Node head) {
		if (head == null) {
			return ;
		}
		printPosOrder(head.left);
		printPosOrder(head.right);
		System.out.print(head.value + " ");
	}
	
	
	public static void main(String[] args) {
		int[] uniqueArr = {3, 4, 5, 1, 2};
		Node head = getMaxTree(uniqueArr);
		printPreOrder(head);
		System.out.println();
		printInOrder(head);
		System.out.println();
		printPosOrder(head);
	}

}
