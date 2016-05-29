package chapter_8_arrayandmatrix;

public class Problem_17_SubMatrixMaxSum {

    public static int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int curr = 0;
        int[] s = null;     // accumulation array
        for (int i = 0; i < m.length; i++) {
            s = new int[m[0].length];
            for (int j = i; j < m.length; j++) {
                curr = 0;
                for (int k = 0; k < s.length; k++) {
                    s[k] += m[j][k];
                    curr += s[k];
                    max = Math.max(max, curr);
                    curr = curr < 0 ? 0 : curr;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
		System.out.println(maxSum(matrix));
    }

}
