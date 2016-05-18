package chapter_2_listproblem;


public class Problem_02_RemoveLastKthNode {
	
	// Single Linked List
	public static class Node {
		public int value;
		public Node next;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node removeLastKthNode(Node head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}
		Node curr = head;
		// decrease lastKth
		while (curr != null) {
			lastKth--;
			curr = curr.next;
		}
		if (lastKth == 0) {
			head = head.next;
		} else if (lastKth < 0) {
			curr = head;
			// increase lastKth
			while (++lastKth != 0) {
				curr = curr.next;
			}
			curr.next = curr.next.next;
		}
		return head;
	}
	
	// Double Linked List
	public static class DoubleNode {
		public int value;
		public DoubleNode prev;
		public DoubleNode next;
		
		public DoubleNode(int data) {
			this.value = data;
		}
	}
	
	
	public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}
		DoubleNode curr = head;
		// decrease lastKth
		while (curr != null) {
			lastKth--;
			curr = curr.next;
		}
		if (lastKth == 0) {
			head = head.next;
			head.prev = null;
		} else if (lastKth < 0) {
			curr = head;
			// increase lastKth
			while (++lastKth != 0) {
				curr = curr.next;
			}
			DoubleNode tempNode = curr.next.next;
			curr.next = tempNode;
			if (tempNode != null) {
				tempNode.prev = curr;
			}
		}
		return head;
	}
	
	// test
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.prev;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		printLinkedList(head1);
		// head1 = removeLastKthNode(head1, 3);
		head1 = removeLastKthNode(head1, 6);
		// head1 = removeLastKthNode(head1, 7);
		printLinkedList(head1);
		
		DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.prev = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.prev = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.prev = head2.next.next;
		head2.next.next.next.next = new DoubleNode(5);
		head2.next.next.next.next.prev = head2.next.next.next;
		head2.next.next.next.next.next = new DoubleNode(6);
		head2.next.next.next.next.next.prev = head2.next.next.next.next;
		printDoubleLinkedList(head2);
		// head2 = removeLastKthNode(head2, 3);
		head2 = removeLastKthNode(head2, 6);
		// head2 = removeLastKthNode(head2, 7);
		printDoubleLinkedList(head2);
	}

}
