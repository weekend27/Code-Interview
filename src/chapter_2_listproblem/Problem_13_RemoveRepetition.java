package chapter_2_listproblem;

import java.util.HashSet;

public class Problem_13_RemoveRepetition {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void removeRep1(Node head) {
		if (head == null) {
			return ;
		}
		HashSet<Integer> set = new HashSet<>();
		set.add(head.value);
		Node prev = head;
		Node curr = head.next;		// curr should not be head
		while (curr != null) {
			if (set.contains(curr.value)) {
				prev.next = curr.next;
			} else {
				set.add(curr.value);
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	public static void removeRep2(Node head) {
		if (head == null) {
			return ;
		}
		Node curr = head;
		Node prev = null;
		Node next = null;
		while (curr != null) {
			prev = curr;
			next = curr.next;
			while (next != null) {
				if (curr.value == next.value) {
					prev.next = next.next;
				} else {
					prev = next;
				}
				next = next.next;
			}
			curr = curr.next;
		}
		
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
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next = new Node(1);
		removeRep1(head);
		printLinkedList(head);
		
		head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next = new Node(1);
		removeRep2(head);
		printLinkedList(head);
	}

}
