class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queue = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.queue.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        val = self.queue[0]
        del self.queue[0]
        return val

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        return self.queue[0]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self.queue) == 0


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