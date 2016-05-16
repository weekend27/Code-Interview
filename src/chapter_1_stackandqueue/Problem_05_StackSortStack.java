package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_05_StackSortStack {
	
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<>();
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			while (!help.isEmpty() && help.peek() < curr) {
				stack.push(help.pop());
			}
			help.push(curr);
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(6);
		stack.push(1);
		stack.push(4);
		
		sortStackByStack(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
