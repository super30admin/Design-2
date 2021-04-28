"""
Space Complexity: O(n)
Runtime Complexity: (Always mention individual operation run time complexity)
push --> O(1)
pop --> O(1) ammortized, O(n) worst case
peek --> O(1) ammortized, O(n) worst case
empty --> O(1)

Yes it ran successfully run on LeetCode
No problems faced other than the ones already discussed in class.
"""

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = list()
        self.outStack = list()


    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)


    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # remove is O(n)
        # the algortihm of pushing all the elements into one in_stack and then shifitng them into out_stack if out_stack
        # is empty gives O(n) but ammortized or average tiem complexity is O(1) as this loop operation will happen only
        # if out_stack is empty
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()



    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.inStack) == 0 and len(self.outStack) == 0:
            return True
        else:
            return False



# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
print(obj.peek())
print(obj.pop())
print(obj.empty)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
