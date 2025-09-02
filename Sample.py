#Time Complexity : Amortized O(1) per operation (push, pop, peek, empty).
#					Worst case for pop/peek: O(n) when elements are transferred from inst → outst.
# Space Complexity : O(n), where n is the number of elements in the queue.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        self.inst = []
        self.outst = []

    def push(self, x: int) -> None: #O(1)
        self.inst.append(x)

    def pop(self) -> int: #O(1)
        if self.empty():
        	return -1
        self.peek() # ensure outst has the front element
        return self.outst.pop()


    def peek(self) -> int: #O(1)
        if not self.outst:  # if outst is empty, transfer from inst
        	while self.inst:
        		self.outst.append(self.inst.pop())
        return self.outst[-1]

    def empty(self) -> bool: #O(1)
    	return not self.inst and not self.outst



        