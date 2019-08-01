class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mainq = []
        self.dupeq = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        while self.mainq:
            self.dupeq.append(self.mainq.pop())
        self.mainq.append(x)
        while self.dupeq:
            self.mainq.append(self.dupeq.pop())

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        return self.mainq.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        return self.mainq[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.mainq

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