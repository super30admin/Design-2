/*

// Time Complexity :
O(1) enqueue
Average O(1) for dequeue and peek
worst O(n) for dequeue and peek

// Space Complexity :
The space complexity is O(1) as no other memeory is used for computation apart from one that's metioned.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

Explanation:
Used stack 1 for enqueue 
For dequeue pushed elements form stack 1 to stack 2 if stack 2 is empty and then kept the elements for the qeueue functionality.

// Your code here along with comments explaining your approach
*/




#include<iostream>
#include<stack>
using namespace std;

class MyQueue {
public:
    stack<int>s1;
    stack<int>s2;
    
    MyQueue() {
        
    }
    
    void push(int x) {
        s1.push(x);
    }
    
    int pop() {
        if(s1.empty() && s2.empty()){
            return -1;
        }
        else
        {
            if(s2.empty())
            {
                while(!s1.empty())
                {
                    s2.push(s1.top());
                    s1.pop();
                }
            }
            int val{s2.top()};
            s2.pop();
            return val;
        }
    }
    
    int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.top());
                s1.pop();
            }  
        }
        return s2.top();
    }
    
    bool empty() {
        return (s1.empty() && s2.empty()?true:false);    
    }
};

int main(int argc, char const *argv[])
{
    MyQueue queue;
    queue.push(1);
    queue.push(2);  
    cout<<boolalpha<<endl;
    cout<<queue.peek()<<endl;  // returns 1
    cout<<queue.pop()<<endl;   // returns 1
    cout<<queue.empty(); // returns false

    return 0;
}
