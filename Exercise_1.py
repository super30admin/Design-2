"""
Problem - 4

Time Complexity - 
push - O(1)
pop - O(n)
peek - O(1)
empty - O(1)

Space Complexity - O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating one array to store all the upcoming elements
then popping each of them to form a queue like stack
and performing all the queue operation on that queue

"""


class MyQueue(object):

    def __init__(self):
        self.stack=[]
        self.queue=[]
        

    def push(self, x):
        while self.queue:
            self.stack.append(self.queue.pop())
        self.stack.append(x)


    def pop(self):
        while self.stack:
            self.queue.append(self.stack.pop())
        return self.queue.pop()
        

    def peek(self):
        while self.stack:
            self.queue.append(self.stack.pop())
        return self.queue[-1]
        

    def empty(self):
        if len(self.stack)>0 or len(self.queue)>0:
            return False
        return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()