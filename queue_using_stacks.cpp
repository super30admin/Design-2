// Time Complexity :push, isempty - O(1)
//pop, top - O(n) - worst case where n is the elements present in the stack at that time 
//or it will be O(1) - because we don't always transfer the elements of first stack to second.

// Space Complexity :O(n) - no of elements which will be pushed as one elements is occuping only one place

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :
//kept constructor private


// Your code here along with comments explaining your approach

//first approach : maintain two stacks in push operation normally push to one stack
//and in pop operation transfer all elements to another stack and pop the element and 
//again transfer all the elements back to first stack to maintain correct push() operation

//second approach: push elements to a stack
//pop(): check whether the second stack is empty if it is empty 
//then transfer all elements of first stack to second stack
// and pop and keep elements there only without bringing back
//as push operation will work without obstruction
//so for pop is second is empty transfer and pop else directly pop from second
//for peek also same as pop just retun top element rathan than popping
//for push just push to first stack 

#include <iostream>
#include <stack>
using namespace std;

class MyQueue {
    private:
        stack<int> first_stack;
        stack<int> second_stack;
        
        void transfer_whenSecondStackisEmpty(){
            if(second_stack.empty()){ //checking is second_stack is empty
                while(!first_stack.empty()){ //while first_stack is not empty perform actions
                    second_stack.push(first_stack.top()); //push top value of first stack into second stack
                    first_stack.pop();// and then pop the top value of first stack 
                    //continue till first stack is empty
                }
            }
        }
    public:    
        MyQueue() {     

        }    
        void push(int x) {
            first_stack.push(x);//push to first stack
        }
        
        int pop() {
            transfer_whenSecondStackisEmpty(); //checking second stack empty and transfereing elements from first to second
            int popped_element = second_stack.top(); // noting pop to be element
            second_stack.pop(); // popoing the element from second stack 
            return popped_element; //returning popped element
            
        }
        
        int peek() {
            transfer_whenSecondStackisEmpty();//checking second stack empty and transfereing elements from first to second
            return second_stack.top();            
        }
        
        bool empty() {
            if(first_stack.empty() && second_stack.empty()){ // when both stacks are empty
                return true;
            }
            else {
                return false;
            }
            
        }
    };
    
    int main(){
        MyQueue* obj = new MyQueue();
     obj->push(10);
     obj->push(20);
     obj->push(30);
     obj->push(40);
     int param_2 = obj->pop();
     int param_3 = obj->peek();
     bool param_4 = obj->empty();
     cout << param_2<<" "<<param_3<<" " <<param_4<< endl ;
    

    }
     