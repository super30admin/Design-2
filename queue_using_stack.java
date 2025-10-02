// Time Complexity : push - O(1), pop - O(1), peek - O(1), empty - O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :NO

/*
 * Approach
 * use 2 stacks, one main one where elements are pushed and other secondary stack where peek and top happens, 
 * when ever a peek or a pop operation come, check if the the secondary is empty, if secondary is empty pop everything from main and bring it to secondary
 * then pop or peek secondary
 * 
 */

class MyQueue {
    Stack<Integer> main;
    Stack<Integer> secondary;

    public MyQueue() {
        this.main = new Stack<>();
        this.secondary = new Stack<>();
    }

    public void push(int x) {
        main.push(x);

    }

    public int pop() {
        if (!secondary.isEmpty()) {
            return secondary.pop();
        } else {
            while (!main.isEmpty()) {
                int temp = main.pop();
                secondary.push(temp);
            }
            return secondary.pop();
        }

    }

    public int peek() {
        if (secondary.isEmpty()) {
            while (!main.isEmpty()) {
                int temp = main.pop();
                secondary.push(temp);
            }
        }
        return secondary.peek();
    }

    public boolean empty() {
        return secondary.isEmpty() && main.isEmpty();

    }
}