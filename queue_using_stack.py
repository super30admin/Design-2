'''
InStack and OutStack. When a new element comes in, it goes to inStack. 
When valid pop() operation happens first time, we reverse the order of elements
by emptying inStack and filling in OutStack. Then pop the top element from OutStack.
When later pop() operation gets called, we first check if outStack is empty. If not, 
we just pop the top element of outSt as the order was reversed in this stack. If not,
treat it as first time pop() operation 

# Time Complexity : 
    O(1) for push, empty
    Amortized O(1) for peek, pop. Worst O(N)  
# Space Complexity :
    O(N) 
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - No
'''


class MyQueue:

    def __init__(self):
        self.inSt = []
        self.outSt = []
        self.size = 0
        
    def push(self, x: int) -> None:
        self.inSt.append(x)
        self.size+=1

    def pop(self) -> int:
        # if self.empty():
        #     # Sanity check. 
        #     return -1
        # if len(self.outSt)==0:
        #     while self.inSt:
        #         self.outSt.append(self.inSt.pop())
        # last = self.outSt[-1]
        last = self.peek() # Leverage the peek function. 
        self.outSt.pop()
        self.size-=1 # reduce the size of queue by 1
        return last

    def peek(self) -> int:
        if self.empty():
            # Sanity check. 
            return -1
        if len(self.outSt)==0:
            # reverse the order 
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        last = self.outSt[-1]
        return last

    def empty(self) -> bool:
        if self.size==0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()