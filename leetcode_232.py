'''

# https://leetcode.com/problems/implement-queue-using-stacks/
# Time Complexity :
    push  : O(1)
    pop   : O(1) amortized
    peek  : O(1) amortized
    empty : O(1)
    
# Space Complexity : O(n), where n is the number of elements.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NO
# Tip: tricky part to transfer all the elements to outstack while peek and pop. Always push into instack
'''

class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []
        

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        if not self.outstack:
            #transfer all to outstack
            while self.instack:
                self.outstack.append(self.instack.pop())
            
        return self.outstack.pop()
        

    def peek(self) -> int:
        if len(self.outstack) == 0:
            #transfer all to outstack
            while self.instack:
                self.outstack.append(self.instack.pop())

        return self.outstack[-1]

    def empty(self) -> bool:
        return not self.instack and not self.outstack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()