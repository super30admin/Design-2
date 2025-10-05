public class MinStackUsing2stacks {
   Stack<Integer> stack;
   Stack<Integer> minStack;
   int min;

   public MinStackUsing2stacks() {
       this.stack = new Stack<>();
       this.minStack = new Stack<>();
       this.min = Integer.MAX_VALUE;
   }

   public void push(int val) {
      min = Math.min(val, min);
      stack.push(val);
      minStack.push(min);
   }

   public void pop() {
      stack.pop();
      minStack.pop();
      min = minStack.peek()
   }

   public int top() {
     return stack.peek();
   }

   public int getMin() {
     return min;
   }
}
