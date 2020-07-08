class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack= []
        self.outStack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # if not self.outStack:
        #     while self.inStack:
        #         self.outStack.append(self.inStack.pop())
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.inStack and not self.outStack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
if __name__ == "__main__":
    mq = MyQueue()
    mq.push(1)
    mq.push(2)
    mq.push(3)
    mq.push(4)
    res = mq.pop()
    print(res)
    peek = mq.peek()
    print(peek)
    empty = mq.empty()
    print("Empty = ",empty)
    mq.pop()
    mq.pop()
    mq.pop()
    print("Empty",mq.empty())
    
