package chapter_2_listproblem;

public class Problem_01_PrintCommonPart {
	
	public static class Node {
		public int value;
		public Node next;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void printCommonPart(Node head1, Node head2) {
		System.out.print("Common Part: ");
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
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

	public static void main(String[] args) {
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(6);
		node1.next.next.next = new Node(7);
		node1.next.next.next.next = new Node(9);
		
		Node node2 = new Node(1);
		node2.next = new Node(3);
		node2.next.next = new Node(6);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(8);
		
		printLinkedList(node1);
		printLinkedList(node2);
		printCommonPart(node1, node2);
	}

}
