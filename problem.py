# Time Complexity :
# push() -> O(1)
# pop() -> O(1)
# peek() -> O(1)
# empty() -> O(1)

# Space Complexity :
# O(n) where n is the number of elements in the queue

# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach

# Core part of the problem is the helper method move() transfers all the elements from queue_in to queue_out only when queue_out is emepty
# queue_in store incoming elements via push()
# queue_out to store the FIFO during pop() and peek() to return front element of the queue

class MyQueue:

    def __init__(self):
        self.queue_in = []
        self.queue_out = []
        

    def push(self, x: int):
        self.queue_in.append(x)
        

    def pop(self):
        self.move()
        return self.queue_out.pop()

    def peek(self):
        self.move()
        return self.queue_out[-1]
        

    def empty(self):
        return not self.queue_in and not self.queue_out

    def move(self):
        if len(self.queue_out) == 0:
            while self.queue_in:
                self.queue_out.append(self.queue_in.pop())



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
