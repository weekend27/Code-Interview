package chapter_7_bitoperation;

public class Problem_06_KTimesOneTime {
	
	public static int onceNum(int[] arr, int k) {
		int[] e0 = new int[32];
		for (int i = 0; i < arr.length; i++) {
			setExclusiveOr(e0, arr[i], k);
		}
		int res = getNumFromKSysNum(e0, k);
		return res;
	}
	
	public static void setExclusiveOr(int[] e0, int value, int k) {
		int[] curKSysNum = getKSysNumFromNum(value, k);
		for (int i = 0; i < e0.length; i++) {
			// add without carry
			e0[i] = (e0[i] + curKSysNum[i]) % k;
		}
	}
	
	// change value from decimal to k-ary
	public static int[] getKSysNumFromNum(int value, int k) {
		int[] res = new int[32];
		int index = 0;
		while (value != 0) {
			res[index++] = value % k;
			value = value / k;
		}
		return res;
	}
	
	// change value-array from k-ary to a decimal
	public static int getNumFromKSysNum(int[] e0, int k) {
		int res = 0;
		for (int i = e0.length - 1; i >= 0; i--) {
			res = res * k + e0[i];
		}
		return res;
	}
	

	public static void main(String[] args) {
		int[] test1 = { 1, 1, 1, 2, 6, 6, 2, 2, 10, 10, 10, 12, 12, 12, 6, 9 };
		System.out.println(onceNum(test1, 3));

		int[] test2 = { -1, -1, -1, -1, -1, 2, 2, 2, 4, 2, 2 };
		System.out.println(onceNum(test2, 5));
	}

}
