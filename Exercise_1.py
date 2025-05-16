# Time Complexity:
#   push = O(1) amortized
#   pop  = O(1) amortized
#   peek = O(1) amortized
#   empty = O(1)
# Space Complexity : O(n) where n = number of elements in the queue
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.input = []
        self.output = []

    def push(self, x: int) -> None:
        self.input.append(x)
    
    def move_if_needed(self):
        if not self.output:
            while self.input:
                self.output.append(self.input.pop())
        
    def pop(self) -> int:
        self.move_if_needed() 
        return self.output.pop()

    def peek(self) -> int:
        self.move_if_needed()
        return self.output[-1]
        

    def empty(self) -> bool:
        return len(self.input) == 0 and len(self.output) == 0
        

if __name__ == "__main__":
    q = MyQueue()
    q.push(4)
    q.push(3)
    q.push(5)

    print(q.peek()) 
    print(q.pop())         
    print(q.empty())  