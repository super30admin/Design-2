# Time Complexity : push, pop, peek, empty- O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""Getting time complexity (TC) of push, peek and empty to be O(1) is trivial, 
but getting TC of a queue pop to be O(1) is a bit harder. I've solved this problem
by creating another array s2, that when empty takes in values of s1 in reverse and 
when asked for a pop just pops the last element, which really is the first element 
of s1. s2 is only filled up again when it is empty hence always maintaining the 
order that values would be in s1"""

class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        if self.s2:
            return self.s2.pop()
        
        self.s2 = self.s1[::-1]
        self.s1 = []
        return self.s2.pop()

    def peek(self) -> int:
        if self.s2:
            return self.s2[-1]
        
        return self.s1[0]

    def empty(self) -> bool:
        if self.s1==[] and self.s2 ==[]:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()