# Problem 1 : Implement Queue using Stacks
# Time Complexity : 
'''
push - O(1)
pop - ammortized O(1)
peek - ammortized O(1)
empty - O(1)
'''
# Space Complexity :
'''
O(N) where N is the number of elements for the queue
push - O(1)
pop - O(1)
peek - O(1)
empty - O(1)
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        # define the two queues for input and output
        self.inqueue = []
        self.outqueue = []
        

    def push(self, x: int) -> None:
        # append the x to the input queue
        self.inqueue.append(x)
        

    def pop(self) -> int:
        # call peek which will trasfer the values from input to output queue to get the first value
        self.peek()
        # pop and return the first value of the output queue
        return self.outqueue.pop()
        

    def peek(self) -> int:
        # check if the out queue is empty
        if len(self.outqueue) == 0:
            # if it is then till the inqueue is empty transfer the value to outqueue
            while len(self.inqueue) != 0:
                self.outqueue.append(self.inqueue.pop())
        # finally return the value of the first value of the out queue
        return self.outqueue[-1]   

    def empty(self) -> bool:
        # check if the length of both the queue are empty and then return the result
        return len(self.outqueue) == 0 and len(self.inqueue) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
