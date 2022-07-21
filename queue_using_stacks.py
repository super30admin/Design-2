
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyQueue:
    """
    - **Approach** : I took two stacks (`in` and `out`), I pushed anything that came inside into `in` Stack
                     When ever there is a pop operation, I checked whether the Queue is empty else if
                     `Out` stack is empty and if it is empty  I popped everything from `in` and place everything
                     in `Out`. and everything else is self explainable from the code
    """
    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        """
        Push an element to the tail of the queue
        :param x:
        :return:
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        self.in_stack.append(x)
        return

    def pop(self) -> int:
        """
        Pop an element from head
        :return: the element popped out element from head
        """
        # Time Complexity : Normally O(1) Occasionally O(n)
        # Space Complexity : O(1)
        if self.empty():
            return -1
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self) -> int:
        """
        Gives the element at the head of the queue
        :return: the head
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        if self.empty():
            return -1
        if self.out_stack:
            return self.out_stack[-1]
        if self.in_stack:
            return self.in_stack[0]

    def empty(self) -> bool:
        """
        Check if Queue is empty
        :return: Boolean
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        if not self.in_stack and not self.out_stack:
            return True
        return False
