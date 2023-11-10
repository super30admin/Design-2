class MyQueue {
public:
   stack<int> input, output;

    void push(int x) {
        input.push(x);
    }

    int pop(void) {
        int result = peek();
        if(result != 0)
        {
        output.pop();
        return result;
        }
        else 
        return 0;
    }

    int peek(void) {
        if (input.empty() && output.empty())
        {
            return 0;
        }
        else
        if(output.empty())
        {
            while (input.size())
                output.push(input.top()); 
                input.pop();
                return output.top();
        } 
        return 0;       
    }

bool empty()
{
    return (input.empty() && output.empty());
}
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */