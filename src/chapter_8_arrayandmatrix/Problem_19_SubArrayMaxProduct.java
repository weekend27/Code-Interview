package chapter_8_arrayandmatrix;

public class Problem_19_SubArrayMaxProduct {
	
	public static double maxProduct(double[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		double max = arr[0];
		double min = arr[0];
		double res = arr[0];
		double maxEnd = 0;
		double minEnd = 0;
		for (int i = 1; i < arr.length; i++) {
			maxEnd = max * arr[i];
			minEnd = min * arr[i];
			max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
			min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {
		double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
		System.out.println(maxProduct(arr));
	}

}
