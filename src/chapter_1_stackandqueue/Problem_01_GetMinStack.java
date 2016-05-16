package chapter_1_stackandqueue;

import java.util.Stack;


public class Problem_01_GetMinStack {

	// first implementation method
	public static class MyStack1 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		public MyStack1() {
			this.stackData = new Stack<>();
			this.stackMin = new Stack<>();
		}
		
		public void push(int newNum) {
			// every time push newNum into stackData
			stackData.push(newNum);
			// choose to push newNum into stackMin
			if (stackMin.isEmpty()) {
				stackMin.push(newNum);
			} else if (newNum <= getMin()) {
				stackMin.push(newNum);
			}
		}
		
		public int pop() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("Your stackData is empty!");
			}
			int value = stackData.pop();
			if (value == getMin()) {
				stackMin.pop();
			}
			return value;
		}
		
		public int getMin() {
			if (stackMin.isEmpty()) {
				throw new RuntimeException("Your stackMin is empty!");
			}
			return stackMin.peek();
		}
		
	}
	
	// second implementation method
	public static class MyStack2 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		public MyStack2() {
			this.stackData = new Stack<>();
			this.stackMin = new Stack<>();
		}
		
		public void push(int newNum) {
			// every time push newNum into stackData
			stackData.push(newNum);
			// choose to push newNum into stackMin
			if (stackMin.isEmpty()) {
				stackMin.push(newNum);
			} else if (newNum <= getMin()) {
				stackMin.push(newNum);
			} else {
				stackMin.push(stackMin.peek());
			}
		}
		
		public int pop() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("Your stackData is empty!");
			}
			stackMin.pop();
			return stackData.pop();
		}
		
		public int getMin() {
			if (stackMin.isEmpty()) {
				throw new RuntimeException("Your stackMin is empty!");
			}
			return stackMin.peek();
		}
		
	}
	
	
	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(4);
		System.out.println(stack1.getMin());
		stack1.push(3);
		System.out.println(stack1.getMin());
		stack1.push(5);
		System.out.println(stack1.getMin());
		stack1.push(3);
		System.out.println(stack1.getMin());
		stack1.push(1);
		System.out.println(stack1.getMin());
		stack1.push(1);
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());
		
		System.out.println("==========");
		
		MyStack1 stack2 = new MyStack1();
		stack2.push(4);
		System.out.println(stack2.getMin());
		stack2.push(3);
		System.out.println(stack2.getMin());
		stack2.push(5);
		System.out.println(stack2.getMin());
		stack2.push(3);
		System.out.println(stack2.getMin());
		stack2.push(1);
		System.out.println(stack2.getMin());
		stack2.push(1);
		System.out.println(stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getMin());
	}

}
