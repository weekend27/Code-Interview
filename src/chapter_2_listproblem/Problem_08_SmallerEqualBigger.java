package chapter_2_listproblem;

public class Problem_08_SmallerEqualBigger {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node listPartition1(Node head, int pivot) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		int i = 0;
		while (curr != null) {
			i++;
			curr = curr.next;
		}
		Node[] nodeArr = new Node[i];
		i = 0;
		curr = head;
		while (curr != null) {
			nodeArr[i++] = curr;
			curr = curr.next;
		}
		arrPartition(nodeArr, pivot);
		for (i = 0; i < nodeArr.length - 1; i++) {
			nodeArr[i].next = nodeArr[i + 1];
		}
		nodeArr[i].next = null;
		return nodeArr[0];
	}
	
	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		if (nodeArr != null) {
			while (index != big) {
				if (nodeArr[index].value < pivot) {
					swap(nodeArr, ++small, index++);
				} else if (nodeArr[index].value == pivot) {
					index++;
				} else {
					swap(nodeArr, --big, index);
				}
			}
		}
	}
	
	public static void swap(Node[] nodeArr, int index1, int index2) {
		Node tmp = nodeArr[index1];
		nodeArr[index1] = nodeArr[index2];
		nodeArr[index2] = tmp;
	}
	
	public static Node listPartition2(Node head, int pivot) {
		Node sH = null;		// small head
		Node sT = null;		// small tail
		Node eH = null;		// equal head
		Node eT = null;		// equal tail
		Node bH = null;		// big head
		Node bT = null;		// big tail
		Node next = null;	// save next node
		// every node distributed to three lists
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eH.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		// reconnect small and equal lists
		if (sT != null) {
			sT.next = eH;
			eT = (eT == null) ? sT : eT;
		}
		// reconnect all
		if (eT != null) {
			eT.next = bH;
		}
		return (sH != null) ? sH : ((eH != null) ? eH : bH);
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
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
//		head1 = listPartition1(head1, 5);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);
	}

}
