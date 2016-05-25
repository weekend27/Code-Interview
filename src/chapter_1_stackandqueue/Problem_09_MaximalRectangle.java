package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_09_MaximalRectangle {

	public static int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}

		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = (map[i][j] == 0) ? 0 : (height[j] + 1);
			}
			maxArea = Math.max(maxArea, maxRecFromBottom(height));
		}
		return maxArea;
	}

	public static int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int currArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, currArea);
			}
			stack.push(i);
		}
		// handle the elements left in the stack, make a fake element close to 0 in order to pop them out
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int currArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, };
		System.out.println(maxRecSize(map));
	}

}
