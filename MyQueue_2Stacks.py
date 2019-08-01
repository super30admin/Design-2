class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inqueue = []
        self.outqueue = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.inqueue.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if len(self.outqueue) == 0:
            while len(self.inqueue) != 0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if len(self.outqueue) == 0:
            while len(self.inqueue) != 0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue[-1]        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.inqueue and not self.outqueue

# Your MyQueue object will be instantiated and called as such:
if __name__ == "__main__":
    obj = MyQueue()
    obj.push(4)
    print(obj.pop())
    obj.push(9)
    obj.push(7)
    obj.push(99)
    print(obj.peek())
    print(obj.empty())