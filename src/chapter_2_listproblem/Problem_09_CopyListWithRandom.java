package chapter_2_listproblem;

import java.util.HashMap;

public class Problem_09_CopyListWithRandom {
	
	public static class Node {
		public int value;
		public Node next;
		public Node rand;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node copyListWithRand1(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		Node curr = head;
		while (curr != null) {
			map.put(curr, new Node(curr.value));
			curr = curr.next;
		}
		curr = head;
		while (curr != null) {
			map.get(curr).next = map.get(curr.next);
			map.get(curr).rand = map.get(curr.rand);
			curr = curr.next;
		}
		return map.get(head);
	}
	
	public static Node copyListWithRand2(Node head) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		Node next = null;
		// copy node and link to every node
		while (curr != null) {
			next = curr.next;
			curr.next = new Node(curr.value);
			curr.next.next = next;
			curr = next;
		}
		curr = head;
		Node currCopy = null;
		// set copy node rand pointer
		while (curr != null) {
			next = curr.next.next;
			currCopy = curr.next;
			currCopy.rand = (curr.rand != null) ? curr.rand.next : null;
			curr = next;
		}
		Node res = head.next;
		curr = head;
		// split
		while (curr != null) {
			next = curr.next.next;
			currCopy = curr.next;
			curr.next = next;
			currCopy.next = (next != null) ? next.next : null;
			curr = next;
		}
		return res;
	}
	
	// test
	public static void printRandLinkedList(Node head) {
		Node curr = head;
		System.out.print("order: ");
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();
		curr = head;
		System.out.print("rand: ");
		while (curr != null) {
			System.out.print(curr.rand == null ? "- " : curr.rand.value + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");
	}

}
