package chapter_2_listproblem;

import java.util.Stack;

public class Problem_12_ConvertEveryKNodesInList {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node reverseKNodes1(Node head, int K) {
		if (K < 2) {
			return head;
		}
		Stack<Node> stack = new Stack<>();
		Node newHead = head;
		Node curr = head;
		Node prev = null;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			stack.push(curr);
			if (stack.size() == K) {
				prev = resign1(stack, prev, next);
				newHead = (newHead == head) ? curr : newHead;
			}
			curr = next;
		}
		return newHead;
	}
	
	public static Node resign1(Stack<Node> stack, Node left, Node right) {
		Node curr = stack.pop();
		if (left != null) {
			left.next = curr;
		}
		Node next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			curr.next = next;
			curr = next;
		}
		curr.next = right;
		return curr;
	}

	public static Node reverseKNodes2(Node head, int K) {
		if (K < 2) {
			return head;
		}
		Node curr = head;
		Node start = null;
		Node prev = null;
		Node next =  null;
		int count = 1;
		while (curr != null) {
			next = curr.next;
			if (count == K) {
				start = (prev == null) ? head : prev.next;
				head = (prev == null) ? curr : head;
				resign2(prev, start, curr, next);
				prev = start;
				count = 0;
			}
			count++;
			curr = next;
		}
		return head;
	}
	
	public static void resign2(Node left, Node start, Node end, Node right) {
		Node prev = start;
		Node curr = start.next;
		Node next = null;
		while (curr != right) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		if (left != null) {
			left.next = end;
		}
		start.next = right;
	}
	
	// test
	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = null;
		int K = 3;
		printLinkedList(head);
		head = reverseKNodes1(head, K);
		printLinkedList(head);
		head = reverseKNodes2(head, K);
		printLinkedList(head);
		System.out.println("=======================");

		head = new Node(1);
		K = 3;
		printLinkedList(head);
		head = reverseKNodes1(head, K);
		printLinkedList(head);
		head = reverseKNodes2(head, K);
		printLinkedList(head);
		System.out.println("=======================");

		head = new Node(1);
		head.next = new Node(2);
		K = 2;
		printLinkedList(head);
		head = reverseKNodes1(head, K);
		printLinkedList(head);
		head = reverseKNodes2(head, K);
		printLinkedList(head);
		System.out.println("=======================");

		head = new Node(1);
		head.next = new Node(2);
		K = 3;
		printLinkedList(head);
		head = reverseKNodes1(head, K);
		printLinkedList(head);
		head = reverseKNodes2(head, K);
		printLinkedList(head);
		System.out.println("=======================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		K = 2;
		printLinkedList(head);
		head = reverseKNodes1(head, K);
		printLinkedList(head);
		head = reverseKNodes2(head, K);
		printLinkedList(head);
		System.out.println("=======================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		K = 3;
		printLinkedList(head);
		head = reverseKNodes1(head, K);
		printLinkedList(head);
		head = reverseKNodes2(head, K);
		printLinkedList(head);
		System.out.println("=======================");
	}

}
