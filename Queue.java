// Time Complexity : O(1) Amortized
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// I initialized two arrays.
// input array to push the elements.
// output array to pop and peek.
// if pop or peek is called and output array is empty. then -
// transfer all elements to output array from input array to resemble queue and perform pop or peek
// if output array is not empty, then simply peek or pop from the output array.
class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    //o(1)
    public void push(int x) {
        input.push(x);
    }
    //o(n) if output stack empty
    //o(1) if output stack not empty
    public int pop() {
        if(output.isEmpty()){
            if(!input.isEmpty()){
                while(!input.isEmpty()){
                    int temp = input.pop();
                    output.push(temp);
                }
            }
            else{
                return -1;
            }


        }
        return output.pop();

    }
    //o(n) if output stack empty
    //o(1) if output stack not empty
    public int peek() {
        if(output.isEmpty()){
            if(!input.isEmpty()){
                while(!input.isEmpty()){
                    int temp = input.pop();
                    output.push(temp);
                }
            }
            else{
                return -1;
            }


        }
        return output.peek();
    }
    //o(1)
    public boolean empty() {
        if(input.isEmpty() && output.isEmpty()){
            return true;
        }
        return false;
    }
}

