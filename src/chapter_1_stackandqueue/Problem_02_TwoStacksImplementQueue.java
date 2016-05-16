package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_02_TwoStacksImplementQueue {
	
	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;
		
		public TwoStacksQueue() {
			this.stackPush = new Stack<>();
			this.stackPop = new Stack<>();
		}
		
		public void add(int newNum) {
			stackPush.push(newNum);
		}
		
		public int poll() {
			if (stackPop.isEmpty() && stackPush.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}
		
		public int peek() {
			if (stackPop.isEmpty() && stackPush.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}
	
	
	public static void main(String[] args) {
		TwoStacksQueue tsQueue = new TwoStacksQueue();
		tsQueue.add(1);
		tsQueue.add(3);
		tsQueue.add(5);
		System.out.println(tsQueue.peek());
		System.out.println(tsQueue.poll());
		System.out.println(tsQueue.peek());
		System.out.println(tsQueue.poll());
		System.out.println(tsQueue.peek());
		System.out.println(tsQueue.poll());
	}

}
