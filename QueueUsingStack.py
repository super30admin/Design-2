# // Time Complexity : push - o(1) pop - o(1) peek - amortized o(1)  
# // Space Complexity : o(n) extra space for stack
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
#   couldnt crack the optimized solution for pop was doing the operation in o(n) i.e for every pop was putting elements to stack2 and pop and again pushing to stack1
#   but after the lecture could implement with o(1)


# // Your code here along with comments explaining your approach
# 1) two stacks during push append to stack1
# 2) during peek to mimic queue decide if we can use stack 2 (if stack2 empty pop everything from stack1 put to stack 2 and then get the top (do this once in a while) otherwise just top)
# 3) use peek function and remove the top

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
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()