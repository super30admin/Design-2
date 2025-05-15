"""
For push, move every element to stack1 as they enter.
For popping or peeking, move all items from stack1 to stack2 only if stack2 is empty.
By doing so, the oldest element is always on top of stack2 and return.

"""
"""
Time Complexity:
push(): O(1)
pop(), peek(): O(1) amortized
empty(): O(1)

Space Complexity:
O(n) —  n is the number of elements for both stacks
"""

class MyQueue:

    def __init__(self):

        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        self.stack1.append(x)
        
    def pop(self) -> int:
        self.peek()
        return self.stack2.pop()

    def peek(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        
        return self.stack2[-1]
  

    def empty(self) -> bool:

        return not self.stack1 and not self.stack2
        


# Your MyQueue object will be instantiated and called as such:

if __name__=="__main__":

    obj = MyQueue()
    print(obj.empty())
    obj.push(1)
    obj.push(2)
    obj.push(3)
    print(obj.pop())
    print(obj.peek())
    print(obj.empty())