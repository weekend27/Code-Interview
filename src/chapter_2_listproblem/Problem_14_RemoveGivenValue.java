package chapter_2_listproblem;

import java.util.Stack;

public class Problem_14_RemoveGivenValue {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node removeValue1(Node head, int num) {
		Stack<Node> stack = new Stack<>();
		while (head != null) {
			if (head.value != num) {
				stack.push(head);
			}
			head = head.next;
		}
		while (!stack.isEmpty()) {
			stack.peek().next = head;
			head = stack.pop();
		}
		return head;
	}
	
	public static Node removeValue2(Node head, int num) {
		// find the new head
		while (head != null) {
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		Node prev = head;
		Node curr = head;
		while (curr != null) {
			if (curr.value == num) {
				prev.next = curr.next;
			} else {
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
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
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next = new Node(1);
		head = removeValue1(head, 1);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next = new Node(1);
		head = removeValue2(head, 1);
		printLinkedList(head);
	}

}
