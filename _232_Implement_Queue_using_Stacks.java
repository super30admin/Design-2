/**** Method 1 ****/
//Time Complexity: O(n) for pushing and O(1) for popping
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Take two stacks inStack and outStack, while pushing a element transfer all the element to outStack and then add to outStack, later transfer all of them back to inStack, to achieve first in first out order. For pop and peek just call them from inStack. Check isEmpty() for inStack to find empty or not.

/**** Method 2 ****/
//Time Complexity: O(1) for pushing and O(n) for popping
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Take two stacks inStack and outStack, while popping a element transfer all the element to outStack and then pop from to outStack, later transfer all of them back to inStack, to achieve first in first out order. Do the same for peek , but for pushing just push them to inStack. Check isEmpty() for inStack to find empty or not

/**** Method 3 ****/
//Time Complexity: O(1) for pushing and O(n) for popping in worst case but O(1) for max time
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Take two stacks inStack and outStack, push the value into inStack, while popping the check if outStack contains any values, if yes pop from it. Else add everything from inStack to outStack and pop. Peek do the same as pop but only peek() at the end. Check isEmpty() for inStack and outStack to find empty or not.

import java.util.Stack;

/**** Method 1 ****/

// public class _232_Implement_Queue_using_Stacks {

//   Stack<Integer> inStack;
//   Stack<Integer> outStack;

//   public _232_Implement_Queue_using_Stacks() {
//     inStack = new Stack<>();
//     outStack = new Stack<>();
//   }

//   public void transfer(Stack<Integer> i, Stack<Integer> t) {
//     while (i.isEmpty()) {
//       t.push(i.peek());
//       i.pop();
//     }
//   }

//   public void push(int x) {
//     if (!inStack.isEmpty()) {
//       transfer(inStack, outStack);
//       inStack.push(x);
//       transfer(outStack, inStack);
//     } else {
//       inStack.push(x);
//     }
//   }

//   public int pop() {
//     if (!empty()) {
//       return inStack.pop();
//     }

//     return -1;
//   }

//   public int peek() {
//     return inStack.peek();
//   }

//   public boolean empty() {
//     return inStack.isEmpty();
//   }
// }

/**** Method 2 ****/
// public class _232_Implement_Queue_using_Stacks {

//   Stack<Integer> inStack;
//   Stack<Integer> outStack;

//   public _232_Implement_Queue_using_Stacks() {
//     inStack = new Stack<>();
//     outStack = new Stack<>();
//   }

//   public void transfer(Stack<Integer> i, Stack<Integer> t) {
//     while (!i.isEmpty()) {
//       t.push(i.pop());
//     }
//   }

//   public void push(int x) {
//     inStack.push(x);
//   }

//   public int pop() {
//     int val;
//     if (!empty()) {
//       transfer(inStack, outStack);
//       val = outStack.pop();
//       transfer(outStack, inStack);
//     } else {
//       val = -1;
//     }

//     return val;
//   }

//   public int peek() {
//     int val;
//     if (!empty()) {
//       transfer(inStack, outStack);
//       val = outStack.peek();
//       transfer(outStack, inStack);
//     } else {
//       val = -1;
//     }

//     return val;
//   }

//   public boolean empty() {
//     return inStack.isEmpty();
//   }
// }

/**** Method 2 ****/
public class _232_Implement_Queue_using_Stacks {

  Stack<Integer> inStack;
  Stack<Integer> outStack;

  public _232_Implement_Queue_using_Stacks() {
    inStack = new Stack<>();
    outStack = new Stack<>();
  }

  public void transfer(Stack<Integer> i, Stack<Integer> t) {
    while (!i.isEmpty()) {
      t.push(i.pop());
    }
  }

  public void push(int x) {
    inStack.push(x);
  }

  public int pop() {
    if (outStack.isEmpty()) {
      transfer(inStack, outStack);
    }

    return outStack.pop();
  }

  public int peek() {
    if (outStack.isEmpty()) {
      transfer(inStack, outStack);
    }

    return outStack.peek();
  }

  public boolean empty() {
    return inStack.isEmpty() && outStack.isEmpty();
  }
}
