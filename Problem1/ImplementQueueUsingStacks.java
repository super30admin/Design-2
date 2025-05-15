package Problem1;
// Time Complexity: push-O(1), pop-(n){worst}, peek- O(n){worst}, empty- O(1)
// Space Complexity: O(n), where n is the size of the stack
//  Idea-> used two stacks to satisfy the condition of first in first out {FIFO},
//  using one stack to move  the elements to another stack to maintain the condition.

import java.util.*;
public class ImplementQueueUsingStacks {
    static class MyQueue {
        Stack<Integer> enque;
        Stack<Integer> deque;

        public MyQueue() {
            enque = new Stack<>();
            deque = new Stack<>();

        }

        public void push(int x) {
            enque.push(x);
        }

        public int pop() {
            if(deque.isEmpty()) {
                while(!enque.isEmpty()) {
                    deque.push(enque.pop());
                }
            }
            return deque.pop();
        }

        public int peek() {
            if(deque.isEmpty()) {
                while(!enque.isEmpty()) {
                    deque.push(enque.pop());
                }
            }
            return deque.peek();
        }

        public boolean empty() {
            return (enque.isEmpty() && deque.isEmpty());
        }
    }

    public static void main(String[] args) {
        MyQueue que = new MyQueue();
        que.push(1);
        que.push(2);
        que.push(3);
        que.push(4);
        que.push(5);

        System.out.println("Top Element->" + que.peek());
        System.out.println("Is que empty? " + que.empty());
        System.out.println("Popped element->" + que.pop());
        System.out.println("Top Element->" + que.peek());

    }
}
