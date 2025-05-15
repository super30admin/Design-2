"""
Time Complexity:
- push: O(1)
- pop: Amortized O(1), due to transferring elements from in_stack to out_stack only when out_stack is empty
- peek: Amortized O(1), due to transferring elements from in_stack to out_stack only when out_stack is empty
- empty: O(1)

Space Complexity: O(n), where n is the number of elements in the queue (e.g., 100 in this case)

Successfully ran on Leetcode: Yes

Notes:
- Initially attempted to implement the queue using a simple array, but realized it doesn’t maintain FIFO order correctly.
- Then switched to the two-stack approach, which properly simulates queue behavior.
- Once the concept was clear, the implementation was straightforward.
"""



class MyQueue(object):

    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.in_stack.append(x)


        

    def pop(self):
        """
        :rtype: int
        """

        if self.out_stack:
            return self.out_stack.pop()
        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()
        
        

    def peek(self):
        """
        :rtype: int
        """
        if self.out_stack:
            return self.out_stack[-1]
        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]


    def empty(self):
        """
        :rtype: bool
        """
        return not self.in_stack and not self.out_stack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()