#Time Complexity: Push Pop Peek Empty Average case O(1) worst case while popstack is empty its O(N)
#Space Complexity: Space of 2 Stack, O(N)
#Yes It runs successfully on Leetcode

class MyQueue:
    
    def __init__(self):
        self.pushstack=[]
        self.popstack=[]

    def push(self, x: int) -> None:
        self.pushstack.append(x)        

    def pop(self) -> int:
        self.peek()
        return self.popstack.pop()
        
    def peek(self) -> int:
        if not self.popstack:
            while self.pushstack:
                self.popstack.append(self.pushstack.pop())
        return self.popstack[-1]
        
    def empty(self) -> bool:
        return len(self.pushstack)+len(self.popstack)==0