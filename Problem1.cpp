//
// Created by shazmaan on 7/2/2019.
//

#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

class MyQueue{
public:
    stack<int> Stack;
    stack<int> Queue;
    int size = 0;
    MyQueue(){

    }
    void push(int value);
    int pop();
    int peek();
    bool empty();
};

void MyQueue::push(int value) {
    Stack.push(value); size++;
    if(Queue.empty()){
        Queue.push(value);
    }else{
        Queue = stack<int>();
        stack<int> temp = Stack;
        for(int x=0;x<size;x++){
//            cout<<Stack.top()<<" Stack top\n";
            Queue.push(Stack.top());
            Stack.pop();
        }
        Stack=temp;
    }
}

int MyQueue::pop() {
    if(Queue.empty()){
        return -1;
    }
    int top = Queue.top();
    Queue.pop(); size--;
    return top;
}

int MyQueue::peek() {
    if(Queue.empty()){
        return -1;
    }
    return Queue.top();
}

bool MyQueue::empty() {
    if(Queue.empty()){
        return true;
    }
    return false;
}

int main(){
    MyQueue queue;

    queue.push(1);

//    cout<<queue.peek()<<endl;


    queue.push(2);

//    cout<<"--------------\n";

    queue.push(3);

    cout<<queue.peek()<<endl;  // returns 1

    cout<<queue.pop()<<endl;   // returns 1

    queue.push(5);

    cout<<queue.peek()<<endl;  // returns 1


    cout<<queue.empty(); // returns false
}