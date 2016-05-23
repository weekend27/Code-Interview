package chapter_7_bitoperation;

public class Problem_01_SwapWithoutTmp {

	public static void main(String[] args) {
		int a = 12312;
		int b = 83893;
		System.out.println(a);
		System.out.println(b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
	}

}
