# // Time Complexity :  PUSH O(1), POP O(1) depending on input size though and intervals of pop, PEEK O(1), EMPTY O(1)
# // Space Complexity : for input of size n, O(N) but no extra memory used in functions
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : 
# // Your code here along with comments explaining your approach: initiated two stacks(lists), once pop aarives
# transfer for one time from s1 to s2, and keep popping from s2 and keep appending to s1.

class MyQueue:

    def __init__(self):
        self.s1=[]
        self.s2=[]

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        if(len(self.s2)==0):
            i=len(self.s1)
            while(i!=0):
                self.s2.append(self.s1.pop())
                i-=1
        return self.s2.pop()

    def peek(self) -> int:
        if(len(self.s2)!=0):
            return self.s2[-1]
        return self.s1[0]

    def empty(self) -> bool:
        if(len(self.s1)==0 and len(self.s2)==0):
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()