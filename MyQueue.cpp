//Time Complexity :O(1);
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include <iostream>
#include <stack>

using namespace std;

class MyQueue {
    stack<int> in;
    stack<int> out;
public:
    MyQueue() {


        
    }
    
    void push(int x) {
        in.push(x);
        
    }
    
    int pop() {
        peek();
        int x = out.top();
        out.pop();
        return x;
        
    }
    
    int peek() {
        if(out.empty()){
           while(in.empty()==false){
               int x = in.top();
               in.pop();
               out.push(x);
               
           }
           
        }
        return out.top();

          
    }
    
    bool empty() {
        if(in.empty() && out.empty()){
            return true;
        }
        
        return false;
        
    }
};
