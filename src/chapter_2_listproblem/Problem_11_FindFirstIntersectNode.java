package chapter_2_listproblem;

public class Problem_11_FindFirstIntersectNode {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		// if both of two lists have no loops
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		// if both of two lists have loops
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}
	
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node slow = head.next;
		Node fast = head.next.next;
		while (slow != fast) {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node curr1 = head1;
		Node curr2 = head2;
		int n = 0;
		while (curr1.next != null) {
			n++;
			curr1 = curr1.next;
		}
		while (curr2.next != null) {
			n--;
			curr2 = curr2.next;
		}
		if (curr1 != curr2) {
			return null;
		}
		curr1 = (n > 0) ? head1 : head2;	// the longer linked list
		curr2 = (curr1 == head1) ? head2 : head1;	// the shorter linked list
		n = Math.abs(n);
		while (n != 0) {
			n--;
			curr1 = curr1.next;
		}
		while (curr1 != curr2) {
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return curr1;
	}
	
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node curr1 = null;
		Node curr2 = null;
		if (loop1 == loop2) {
			curr1 = head1;
			curr2 = head2;
			int n = 0;
			while (curr1 != loop1) {
				n++;
				curr1 = curr1.next;
			}
			while (curr2 != loop2) {
				n--;
				curr2 = curr2.next;
			}
			curr1 = (n > 0) ? head1 : head2;
			curr2 = (curr1 == head1) ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				curr1 = curr1.next;
			}
			while (curr1 != curr2) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			return curr1;
		} else {
			curr1 = loop1.next;
			while (curr1 != loop1) {
				if (curr1 == loop2) {
					return loop1;
				}
				curr1 = curr1.next;
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);
	}

}
