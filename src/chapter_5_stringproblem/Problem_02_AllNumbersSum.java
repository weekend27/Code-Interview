package chapter_5_stringproblem;

public class Problem_02_AllNumbersSum {
	
	public static int numSum(String str) {
		if (str == null) {
			return 0;
		}
		char[] charArr = str.toCharArray();
		int res = 0;
		int num = 0;
		boolean posi = true;
		int curr = 0;
		for (int i = 0; i < charArr.length; i++) {
			curr = charArr[i] - '0';
			if (curr < 0 || curr > 9) {
				res += num;
				num = 0;
				if (charArr[i] == '-') {
					if (i - 1 >= 0 && charArr[i - 1] == '-') {
						posi = !posi;
					} else {
						posi = false;
					}
				} else {
					posi = true;
				}
			} else {
				num = num * 10 + (posi ? curr : -curr);
			}
		}
		res += num;
		return res;
	}

	public static void main(String[] args) {
		String test = "1K-100ABC500D-T--100F200G!!100H---300";
		System.out.println(numSum(test));
	}

}
