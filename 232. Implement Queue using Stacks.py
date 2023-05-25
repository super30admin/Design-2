# // Time Complexity : O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        self.stack = [] #Intiating an empty array

    def push(self, x: int) -> None:
        self.stack.append(x)    #Appending element at the last

    def pop(self) -> int:
        p = self.stack[0]   #Removing elements from the first
        del self.stack[0]
        return p

    def peek(self) -> int:
        return self.stack[0]

    def empty(self) -> bool:
        if len(self.stack) == 0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(12)
obj.push(14)
obj.push(45)
obj.push(67)
print(obj.pop())
print(obj.peek()) 
print(obj.empty())