# // Time Complexity : push, empty fucntions have O(1) while pop and peek are O(1) amortized cause of moving elements from s1 to s2.
# // Space Complexity : O(n), where n are the number of elements on the stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Implemented the queue using 2 stacks, s1 and s2.
# In push fucntion, you blindly push all elements to s1.
# In pop fucntion, you move all elements in LIFO manner onto s2. and pop top of s2 to attain FIFO of queues.
# In peek fucntion, same as pop but instead of poping out the top elemens of s2 you just return the top.
# In empty fucntion, you just return True if both the stacks are empty, else return False.

class MyQueue:

    def __init__(self):
        self.s1=[]
        self.s2=[]

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        if not self.s2:
            while self.s1:
                ele=self.s1.pop()
                self.s2.append(ele)
        return self.s2.pop()
    

    def peek(self) -> int:
        if not self.s2:
            while self.s1:
                ele=self.s1.pop()
                self.s2.append(ele)
        return self.s2[-1]

    def empty(self) -> bool:
        return not self.s1 and not self.s2


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()