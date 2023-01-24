// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
// Time Complexity : pop: O(n), all other O(1)
// Space Complexity : O(1)
Queues using 2 stacks

thought process:
as it is given, we have to use only 2 stacks.
1. for queue push, we can make use of single stack
2. for pop operation, we have to make use of other stack(copy elements from stack 1 into 2 by using LIFO until
we reach element to be popped)
3. once we reach that element, remove that, decrement top and push back the elements from stack 2 to 1


class MyQueue {

    int []a;
    int []b;
    int top;
    public MyQueue() {
        a = new int[100];
        b = new int[100];
        top=-1;
    }

    public void push(int x) {
        if (top!=99) {
            a[++top] = x;
        }
    }

    public int pop() {
        int j=0;
        int i;
        for(i=top;i>0;i--){
            b[j] = a[i];
            j++;
        }
        j-=1;
        int element = a[0];
        while(j>=0) {
            a[i] = b[j];
            i++;
            j--;
        }
        top--;
        return element;
    }

    public int peek() {
        return a[0];
    }

    public boolean empty() {
        return top==-1?true:false;
    }
}

public class Sample {
    public static void main(String args[]) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println("pop " + obj.pop());
        obj.push(5);
        System.out.println("pop " + obj.pop());
        System.out.println("pop " + obj.pop());
        System.out.println("pop " + obj.pop());
        System.out.println("pop " + obj.pop());
    }
}


HashMap Impl
//time complexity: O(1)
//space: O(1)
approach
we have to keep track of keys that are being inserted, to do that we can use boolean array
and to track values of respective keys, we use another array.
1. for put operation, we check if key is present in first array, if so, update value in first array. update second array in either case
2. for remove, check if present in first array, if yes, make that value to false

class MyHashMap {

    final int MAX = 1000000+1;
    boolean[] a;
    int[] b;
    public MyHashMap() {
        a = new boolean[MAX];
        b = new int[MAX];
    }

    public void put(int key, int value) {
        if(!a[key]){
            a[key] = true;
        }
        b[key] = value;
    }

    public int get(int key) {
        return a[key]?b[key]:-1;
    }

    public void remove(int key) {
        if(a[key]){
            a[key]= false;
        }
    }
}


 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

