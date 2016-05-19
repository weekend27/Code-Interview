package chapter_2_listproblem;

public class Problem_20_RelocateLinkedList {
	
	public static class Node {
		public int value;
		public Node next;
		
		public Node (int data) {
			this.value = data;
		}
	}
	
	public static void relocate(Node head) {
		if (head == null || head.next == null) {
			return ;
		}
		// slow and fast pointer to find the mid node
		Node slow = head;
		Node fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// put the fast pointer to the head of the right part, and cut two parts off
		fast = slow.next;
		slow.next = null;
		mergeLR(head, fast);
	}
	
	public static void mergeLR(Node left, Node right) {
		Node rnext = null;
		while (left.next != null) {
			rnext = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = rnext;
		}
		left.next = right;
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
		relocate(head);
		printLinkedList(head);
		
		head = new Node(1);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		relocate(head);
		printLinkedList(head);
	}

}
