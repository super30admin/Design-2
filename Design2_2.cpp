class Queue {           //Class Queue created with push,pop,peek and empty functions.
public:
    stack<int> s1, s2;     // 2 Stacks created to implement queue using STL Functions.


    void push(int x) {          //Push the element to the back of one queue.
       cout<<" Element pushed "<<x;
        s1.push(x);
    }

    // Removes the element from in front of queue.
    void pop() {

        while (!s1.empty()) {       // To pop the element from queue, the top elements must be popped to another stack
            int temp = s1.top();
            s2.push(temp);
            s1.pop();
        }
        cout<<" Element Popped out is " <<s2.top();        //The top element now represents the front of the queue or the element inserted first into the queue
        s2.pop();               // The element is then popped out.
    }

    // Get the front element.
    int peek() {

        while (!s1.empty()) {
            int temp = s1.top();
            s2.push(temp);
            s1.pop();
        }
        cout<< s2.top();            //The elements in stack1 are pushed to stack2. The top of stack2 is now front of the queue.
                                    // Top element of stack2 is now the first element inserted in queue.
    }


    bool empty() {                  // a bool function to return if stacks are empty or not.
        return s2.empty() && s1.empty();
    }


};
/*Driver program to test the functions*/
int main()
{
    Queue MyQueue;      //Object of Queue class created.
    MyQueue.push(12320);//Elements pushed.
    MyQueue.push(4242);
    MyQueue.push(30);
    MyQueue.push(40);

    MyQueue.pop();//Element popped.


    return 0;
}