package chapter_2_listproblem;

public class Problem_16_ListSelectionSort {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node selectionSort(Node head) {
		Node tail = null;	// sorted part tail
		Node curr = head;	// unsorted part head
		Node smallPrev = null;	// previous node of the smallest node
		Node small = null;	// smallest node
		while (curr != null) {
			small = curr;
			smallPrev = getSmallestPrevNode(curr);
			if (smallPrev != null) {
				small = smallPrev.next;
				smallPrev.next = small.next;
			}
			curr = (curr == small) ? small.next : curr;
			if (tail == null) {
				head = small;
			} else {
				tail.next = small;
			}
			tail = small;
		}
		return head;
	}
	
	public static Node getSmallestPrevNode(Node head) {
		Node smallPrev = null;
		Node small = head;
		Node prev = head;
		Node curr = head.next;
		while (curr != null) {
			if (curr.value < small.value) {
				small = curr;
				smallPrev = prev;
			}
			prev = curr;
			curr = curr.next;
		}
		return smallPrev;
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
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(4);
		head.next.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);
	}

}
