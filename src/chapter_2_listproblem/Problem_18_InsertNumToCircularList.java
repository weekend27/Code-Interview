package chapter_2_listproblem;

public class Problem_18_InsertNumToCircularList {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node insetNum(Node head, int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		Node prev = head;
		Node curr = head.next;
		while (curr != head) {
			if (prev.value <= num && curr.value >= num) {
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		prev.next = node;
		node.next = curr;
		// head node may be changed
		return (head.value < num) ? head : node;
	}
	
	// test
	public static void printCircularList(Node head) {
		if (head == null) {
			return ;
		}
		System.out.print("Circular List: " + head.value + " ");
		Node curr = head.next;
		while (curr != head) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println("-> " + head.value);
	}

	public static void main(String[] args) {
		Node head = null;
		head = insetNum(head, 2);
		printCircularList(head);
		head = insetNum(head, 1);
		printCircularList(head);
		head = insetNum(head, 4);
		printCircularList(head);
		head = insetNum(head, 3);
		printCircularList(head);
		head = insetNum(head, 5);
		printCircularList(head);
		head = insetNum(head, 0);
		printCircularList(head);
	}

}
