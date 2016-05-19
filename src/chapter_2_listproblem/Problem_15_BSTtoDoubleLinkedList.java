package chapter_2_listproblem;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_15_BSTtoDoubleLinkedList {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node convert1(Node head) {
		Queue<Node> queue = new LinkedList<>();
		inOrder2Queue(head, queue);
		if (queue.isEmpty()) {
			return null;
		}
		// create a double linked list
		head = queue.poll();
		Node prev = head;
		prev.left = null;
		Node curr = null;
		while (!queue.isEmpty()) {
			curr = queue.poll();
			prev.right = curr;
			curr.left = prev;
			prev = curr;
		}
		curr.right = null;
		return head;
	}
	
	public static void inOrder2Queue(Node head, Queue<Node> queue) {
		if (head == null) {
			return ;
		}
		inOrder2Queue(head.left, queue);
		queue.offer(head);
		inOrder2Queue(head.right, queue);
	}
	
	public static Node convert2(Node head) {
		if (head == null) {
			return null;
		}
		Node tail = process(head);
		head = tail.right;
		tail.right = null;
		return head;
	}
	
	public static Node process(Node head) {
		if (head == null) {
			return null;
		}
		Node leftE = process(head.left);	// left end
		Node rightE = process(head.right);	// right end
		Node leftS = leftE != null ? leftE.right : null;	// left start
		Node rightS = rightE != null ? rightE.right : null;	// right start
		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = rightS;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		} else if (leftE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		} else if (rightE != null) {
			head.right = rightS;
			rightS.left = head;
			rightE.right = head;
			return rightE;
		} else {
			head.right = head;
			return head;
		}
	}
	
	// test
	public static void printBSTInOrder(Node head) {
		System.out.print("BST in-order: ");
		if (head != null) {
			inOrderPrint(head);
		}
		System.out.println();
	}

	public static void inOrderPrint(Node head) {
		if (head == null) {
			return;
		}
		inOrderPrint(head.left);
		System.out.print(head.value + " ");
		inOrderPrint(head.right);
	}

	public static void printDoubleLinkedList(Node head) {
		System.out.print("Double Linked List: ");
		Node end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.right;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.left;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(2);
		head.right = new Node(9);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.left.right.right = new Node(4);
		head.right.left = new Node(7);
		head.right.right = new Node(10);
		head.left.left = new Node(1);
		head.right.left.left = new Node(6);
		head.right.left.right = new Node(8);

		printBSTInOrder(head);
		head = convert1(head);
		printDoubleLinkedList(head);
		
		head = new Node(5);
		head.left = new Node(2);
		head.right = new Node(9);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.left.right.right = new Node(4);
		head.right.left = new Node(7);
		head.right.right = new Node(10);
		head.left.left = new Node(1);
		head.right.left.left = new Node(6);
		head.right.left.right = new Node(8);

		printBSTInOrder(head);
		head = convert2(head);
		printDoubleLinkedList(head);
	}

}
