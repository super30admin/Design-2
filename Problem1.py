'''
Time Complexity:-
push -  O(1)
pop - O(1) amortized
peek - O(1) amortized
empty - O(1)


Space Complexity - O(1) for all the operations.

This code is working on leetcode.
'''

from collections import deque
class MyQueue:

    def __init__(self):
        self.instack = deque() #create input stack
        self.outstack = deque() #create output stack

    def push(self, x: int) -> None:
        self.instack.append(x) #push into instack

    def pop(self) -> int:
        if not self.empty(): #check for empty queue(check if both stacks are empty)
            self.peek() #check topmost element(this ensures popping from instack and pushing to outstack)
            return self.outstack.pop() #pop from the outstack
        
    def peek(self) -> int:
        if not self.outstack: #check if the outstack is empty
            while self.instack: #continue till the instack is empty
                self.outstack.append(self.instack.pop()) #push whatever we pop from the instack to outstack
        return self.outstack[-1] #return the top of outstack

    def empty(self) -> bool:
        return not self.instack and not self.outstack #check if both instack and outstack are empty.