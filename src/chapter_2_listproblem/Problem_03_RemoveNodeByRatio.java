package chapter_2_listproblem;


public class Problem_03_RemoveNodeByRatio {
	
	public static class Node {
		public int value;
		public Node next;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node removeMidNode(Node head) {
		// list length <= 1
		if (head == null || head.next == null) {
			return head;
		}
		// list length == 2
		if (head.next.next == null) {
			return head.next;
		}
		// slow and fast pointers, in order to get the prev node for the deleted-node
		Node slow = head;
		Node fast = head.next.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	
	public static Node removeByRatio(Node head, int a, int b) {
		if (a < 1 || a > b) {
			return head;
		}
		// compute the length of the linked list
		int n = 0;
		Node curr = head;
		while (curr != null) {
			curr = curr.next;
			n++;
		}
		// compute the deleted-node index (index begins from 1)
		int k = (int) Math.ceil(n * ((double)a / (double)b));
		if (k == 1) {
			head = head.next;
		} else if (k > 1){
			// get the prev node for the deleted-node
			curr = head;
			while (--k != 1) {
				curr = curr.next;
			}
			// delete node
			curr.next = curr.next.next;
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
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		printLinkedList(head);
		head = removeMidNode(head);
		printLinkedList(head);
		head = removeByRatio(head, 2, 5);
		printLinkedList(head);
		head = removeByRatio(head, 1, 3);
		printLinkedList(head);
	}

}
