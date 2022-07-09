"""
https://leetcode.com/problems/implement-queue-using-stacks/

Using two stacks

Space Complexity: O(n)
Runtime Complexity: (Always mention individual operation run time complexity)
push --> O(1)
pop --> O(1) amortized, O(n) worst case
peek --> O(1) amortized, O(n) worst case
empty --> O(1)

Yes it ran successfully on LeetCode
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
        #  Pushes all elements into one stack --> inStack
        self.inStack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # remove is O(n). If outStack is empty, pop all elements from inStack into outStack. And then pop from
        # outStack. If outStack is not empty, no shifting required and pop from outStack. O(n) if outStack is empty
        # and 'n' shifting operations have to take place. But, ammortized or average time complexity is O(1) as this
        # loop operation will happen only if out_stack is empty, so infrequently.
        self.peek()
        return self.outStack.pop()  # remove the element

    def peek(self) -> int:
        """
        Get the front element.
        """
        # remove is O(n) If outStack is empty, pop all elements from inStack into outStack. And then pop from
        # outStack. If outStack is not empty, no shifting required and pop from outStack. O(n) if outStack is empty
        # and 'n' shifting operations have to take place. But, amortized or average time complexity is O(1) as this
        # loop operation will happen only if out_stack is empty, so infrequently.
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]  # only return the value

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        # Both the stacks must be empty
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
