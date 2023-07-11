//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : O(n) for every operation
// Space Complexity : O(n)  where n is the number of elements
// Did this code successfully run on Leetcode :
//Ans - Yes
// Any problem you faced while coding this :
//Ans - No

// Your code here along with comments explaining your approach

/*
Approach: We will have two stacks of front_stack which will keep a track of elements front of the queue and the back_stack one will
keep a track of the back of the queue. On push we will push all elememts from front_stack to back_stack while on peek and pop we will 
we will push all elememts from back_stack to front_stack 
*/
/*
class MyQueue {
public:
stack<int> front_stack;
stack<int> back_stack;
    MyQueue() {
        
    }
    
    void push(int x) {
        while(!front_stack.empty()){
back_stack.push(front_stack.top());
front_stack.pop();
        }
       back_stack.push(x); 
    }
    
    int pop() {
           while(!back_stack.empty()){
front_stack.push(back_stack.top());
back_stack.pop();
        }
        int top = front_stack.top();
        front_stack.pop();
        return top;
    }
    
    int peek() {
        while(!back_stack.empty()){
front_stack.push(back_stack.top());
back_stack.pop();
        }
        return front_stack.top();
    }
    
    bool empty() {
        if(front_stack.empty() && back_stack.empty()){
            return true;
        }
        return false;
    }
};
*/

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */

 // Time Complexity :  O(N) where n is the number of entries in bool array
// Space Complexity : O(N) where n is the number of entries in bool array
// Here number of entries = 1001000
// Did this code successfully run on Leetcode :
//Answer - Yes
// Any problem you faced while coding this :
//Answer - No

// Your code here along with comments explaining your approach


/*
class MyHashMap {
public:
int arr[1000][1001]; //first take a 2d boolean array to track the elements present in the boolean array
    MyHashMap() {
        
        for(int i=0;i<1000;i++){
                    for(int j=0;j<1001;j++){
arr[i][j]=-1;   //setting false for every entry since no key is present in hashmap
                    }
        }
    }
    
    void put(int key, int value) {
        arr[key%1000][key/1000] = value; //setting value for the key added in the hashmap
    }
    
    int get(int key) {
        return arr[key%1000][key/1000]; //setting value for the key present in the hashmap
    }
    
    void remove(int key) {
          arr[key%1000][key/1000] = -1; //setting value  to -1 which means we are removing the corresponding key present in the hashmap
    }
};
*/
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
