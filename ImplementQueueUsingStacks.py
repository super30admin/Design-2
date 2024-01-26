'''
TC: push: O(1), pop: O(1), peek: O(1), empty: O(1)
'''

class MyQueue:
    def __init__(self):
        self.instack = []
        self.outstack = []        

    def push(self, x: int) -> None:
        self.instack.append(x)        

    def pop(self) -> int:
        self.peek() 
        return self.outstack.pop()   

    def peek(self) -> int:
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]
            
    def empty(self) -> bool:
        return True if not self.instack and not self.outstack else False
        
# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
obj.push(4)
param_2 = obj.pop()
print(f"Popped element is: {param_2}")
obj.push(5)
obj.push(6)
param_3 = obj.peek()
print(f"Peeked element is: {param_3}")
obj.push(7)
param_4 = obj.empty()
print(f"Is the stack empty: {param_4}")
obj.pop()
obj.pop()
obj.pop()
obj.pop()
obj.pop()
obj.pop()
param_4 = obj.empty()
print(f"Is the stack empty: {param_4}")