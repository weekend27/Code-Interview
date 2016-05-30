package chapter_8_arrayandmatrix;

import java.util.Arrays;

public class Problem_20_PrintMaxTopK {
	
	public static class HeapNode {
		public int value;
		public int arrNum;
		public int index;
		
		public HeapNode(int value, int arrNum, int index) {
			this.value = value;
			this.arrNum = arrNum;
			this.index = index;
		}
	}
	
	public static void printTopK(int[][] matrix, int topK) {
		int heapSize = matrix.length;
		HeapNode[] heap = new HeapNode[heapSize];
		for (int i = 0; i < heapSize; i++) {
			int index = matrix[i].length - 1;
			heap[i] = new HeapNode(matrix[i][index], i, index);
			heapInsert(heap, i);
		}
		System.out.println("TOP " + topK + " : ");
		for (int i = 0; i < topK; i++) {
			if (heapSize == 0) {
				break;
			}
			System.out.print(heap[0].value + " ");
			if (heap[0].index != 0) {
				heap[0].value = matrix[heap[0].arrNum][--heap[0].index];
			} else {
				swap(heap, 0, --heapSize);
			}
			heapify(heap, 0, heapSize);
		}
	}
	
	public static void heapInsert(HeapNode[] heap, int index) {
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (heap[parent].value < heap[index].value) {
				swap(heap, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}
	
	public static void heapify(HeapNode[] heap, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while (left < heapSize) {
			if (heap[left].value > heap[index].value) {
				largest = left;
			}
			if (right < heapSize && heap[right].value > heap[index].value) {
				largest = right;
			}
			if (largest != index) {
				swap(heap, largest, index);
			} else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}
	
	public static void swap(HeapNode[] heap, int index1, int index2) {
		HeapNode tmp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = tmp;
	}
	
	// test
	public static int[][] generateRandomMatrix(int maxRow, int maxCol, int maxValue) {
		if (maxRow < 0 || maxCol < 0) {
			return null;
		}
		int[][] matrix = new int[(int) (Math.random() * maxRow) + 1][];
		for (int i = 0; i != matrix.length; i++) {
			matrix[i] = new int[(int) (Math.random() * maxCol) + 1];
			for (int j = 0; j != matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * maxValue);
			}
			Arrays.sort(matrix[i]);
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = generateRandomMatrix(5, 10, 1000);
		printMatrix(matrix);
		System.out.println("===========================");
		printTopK(matrix, 10);
	}

}
