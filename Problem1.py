# Time Complexity : all O(1) although pop/peek is O(n) worst case average O(1) since only when outstack is completeley empty we need to transfer content
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# we can keep on pushhing to instack and only transfer first time to out/peek i.e when it becomes empty other timer can be poping from out stack dince value there any how means / needs to pop first irrespective of what is being added to in stack  


class MyQueue:

    def __init__(self):
        self.instack =  []
        self.outstack = []
    
    def transferInStackContents(self):
        items = len(self.instack)
        while items > 0:
            self.outstack.append(self.instack.pop())
            items = items - 1
        return

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        if not self.outstack:
            self.transferInStackContents()
        
        if self.outstack:
            return self.outstack.pop()
        
        return 0

    def peek(self) -> int:
        if not self.outstack:
            self.transferInStackContents()
        
        if self.outstack:
            return self.outstack[-1]

        return 0
        

    def empty(self) -> bool:
            return not self.instack and not self.outstack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
