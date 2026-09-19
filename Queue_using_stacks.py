// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
#I have used two stacks to push all the elements to stack2 when peek method is called and return the top element. 
#Pop() calls peek() first and then returns top element from stack2.


class MyQueue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x:int) -> None:
        self.stack1.append(x)

    def peek(self) -> int:
        if self.stack2 == []:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
            

    def pop(self) -> int:
        self.peek()
        return self.stack2.pop()

    def empty(self) -> bool:
        if not self.stack1 and not self.stack2:
            return True
        return False