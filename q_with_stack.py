## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
# // Time Complexity : push : O(1) | pop : O(n) | peek : O(n) | empty : O(1)
# // Space Complexity : all : O(n+n) = O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : this is my first time using deque, little difficult when started
from collections import deque 
class MyQueue:
    def __init__(self):
        self.in_q = deque()
        self.out_q = deque()
        # print(self.in_q)
    def push(self, x: int) -> None:
        self.in_q.append(x)  # pushing into in stack
        # print(self.in_q)

    def pop(self) -> int:
        try:
            return self.out_q.pop()
        except:
            while self.in_q:  #untill the input stack gets empty
                self.out_q.append(self.in_q.pop())
        return self.out_q.pop()

    def peek(self) -> int:
        if self.out_q:
            k = self.out_q.pop()
            self.out_q.append(k)
            return k
        else:
            while self.in_q:
                self.out_q.append(self.in_q.pop())
        k = self.out_q.pop()
        self.out_q.append(k)
        return k
        

    def empty(self) -> bool:
        if self.in_q or self.out_q:
            return False
        else:
            return True

# this is my old code
# #     def __init__(self):
# #         self.k = []
        

# #     def push(self, x: int) -> None:
# #         self.k.append(x)

# #     def pop(self) -> int:
# #         return self.k.pop(0)

# #     def peek(self) -> int:
# #         return self.k[0]
        

# #     def empty(self) -> bool:
# #         return len(self.k)==0


# # Your MyQueue object will be instantiated and called as such:
# # obj = MyQueue()
# # obj.push(x)
# # param_2 = obj.pop()
# # param_3 = obj.peek()
# # param_4 = obj.empty()