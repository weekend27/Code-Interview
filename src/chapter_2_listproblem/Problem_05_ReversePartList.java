package chapter_2_listproblem;

public class Problem_05_ReversePartList {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node reversePart(Node head, int from, int to) {
		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while (node1 != null) {
			len++;
			fPre = (len == from - 1) ? node1 : fPre;
			tPos = (len == to + 1) ? node1 : tPos;
			node1 = node1.next;
		}
		if (from > to || from < 1 || to > len) {
			return head;
		}
		Node prevNode = (fPre == null) ? head : fPre.next;
		Node node2 = prevNode.next;
		prevNode.next = tPos;
		Node nextNode = null;
		while (node2 != tPos) {
			nextNode = node2.next;
			node2.next = prevNode;
			prevNode = node2;
			node2 = nextNode;
		}
		if (fPre != null) {
			fPre.next = prevNode;
			return head;
		}
		return prevNode;
	}

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
		printLinkedList(head);
		head = reversePart(head, 1, 1);
		printLinkedList(head);
		System.out.println("===========");

		head = new Node(1);
		printLinkedList(head);
		head = reversePart(head, 1, 1);
		printLinkedList(head);
		System.out.println("===========");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		head = reversePart(head, 1, 2);
		printLinkedList(head);
		System.out.println("===========");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		head = reversePart(head, 2, 3);
		printLinkedList(head);
		System.out.println("===========");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		head = reversePart(head, 1, 3);
		printLinkedList(head);
		System.out.println("===========");
	}

}
