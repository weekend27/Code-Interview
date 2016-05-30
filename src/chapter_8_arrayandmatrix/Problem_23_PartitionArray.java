package chapter_8_arrayandmatrix;

public class Problem_23_PartitionArray {
	
	public static void leftUnique(int[] arr) {
		if (arr == null || arr.length < 2) {
			return ;
		}
		int u = 0;
		int i = 1;
		while (i < arr.length) {
			if (arr[i] != arr[u]) {
				swap(arr, ++u, i);
			}
			i++;
		}
	}
	
	public static void sort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return ;
		}
		int left = -1;
		int index = 0;
		int right = arr.length;
		while (index < right) {
			if (arr[index] == 0) {
				swap(arr, ++left, index++);
			} else if (arr[index] == 2) {
				swap(arr, index, --right);
			} else {
				index++;
			}
		}
	}
	
	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	// test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9 };
		printArray(arr1);
		leftUnique(arr1);
		printArray(arr1);
		
		System.out.println();
		
		int[] arr2 = { 2, 1, 2, 0, 1, 1, 2, 2, 0 };
		printArray(arr2);
		sort(arr2);
		printArray(arr2);
	}

}
