package chapter_8_arrayandmatrix;

public class Problem_04_FindMinKNums {
	
	// O(N*logK)
	public static int[] getMinKNumsByHeap(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int[] kHeap = new int[k + 1];
		for (int i = 1; i < k + 1; i++) {
			heapInsert(kHeap, arr[i - 1], i);
		}
		for (int i = k + 1; i < arr.length + 1; i++) {
			if (arr[i - 1] < kHeap[1]) {
				kHeap[1] = arr[i - 1];
				heapify(kHeap, 1, k);
			}
		}
		return kHeap;
	}
	
	public static void heapInsert(int[] arr, int value, int index) {
		arr[index] = value;
		while (index > 1) {
			int parent = index / 2;
			if (arr[parent] < arr[index]) {
				swap(arr, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}
	
	public static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2;
		int right = index * 2 + 1;
		int largest = index;
		while (left < heapSize && right < heapSize) {
			if (arr[left] > arr[index]) {
				largest = left;
			}
			if (arr[right] > arr[index]) {
				largest = right;
			}
			if (largest != index) {
				swap(arr, largest, index);
			} else {
				break;
			}
			index = largest;
			left = index * 2;
			right = index * 2 + 1;
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
		// sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
		printArray(getMinKNumsByHeap(arr, 10));
	}

}
