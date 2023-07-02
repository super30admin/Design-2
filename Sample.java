# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#approch:
#To implement Queue = FIFO, I have mantained two stacks, Always push in input list and for poping 
#copy input list's element to output list and return output stack peek. 

class MyQueue:
    def __init__(self):
        self.input = [] 
        self.output = []

    def push(self, x: int) -> None:
        self.input.append(x)

    def pop(self) -> int:
        self.peek()
        return self.output.pop()

    def peek(self) -> int:
        if bool(self.output) == False:
            while(bool(self.input)==True):
                self.output.append(self.input.pop())
            return self.output[-1]
        else:
            return self.output[-1]
      
    def empty(self) -> bool:
        return not bool(self.input) and not bool(self.output)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
