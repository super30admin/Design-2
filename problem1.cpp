/*  Reference: Leetcode solution */

#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;
class myQueue{

stack<int> inputStack, outputStack;
 
public:
    myQueue(){

    }

    void push(int x){
        inputStack.push(x);
    } 

    bool empty(){
        return inputStack.empty() && outputStack.empty();
    }

    int pop(){
        int top = peek();
        outputStack.pop();
        return top;
    }

    int peek(){
        if (outputStack.empty())
            while (inputStack.size())
                outputStack.push(inputStack.top()), inputStack.pop();
        return outputStack.top();
    }
        
};
