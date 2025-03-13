# Implementation of Queue using Two Stacks.

# Approach:
# - Uses two stacks to simulate queue behavior (FIFO - First In First Out)
# - One stack (push_stack) is used for enqueue operations
# - Second stack (pop_stack) is used for dequeue operations
# - When an element needs to be dequeued, all elements from push_stack are moved to pop_stack, reversing their order
# - This reversal converts the LIFO (Last In First Out) behavior of stacks to FIFO behavior needed for a queue

# Time Complexity:
# - push: O(1) - constant time operation
# - pop/peek: Amortized O(1) - each element is moved from push_stack to pop_stack exactly once
#   * Worst case: O(n) when pop_stack is empty and elements need to be transferred
#   * Best case: O(1) when pop_stack already has elements

# Space Complexity:
# - O(n) where n is the number of elements stored in the queue

# Did this code successfully run on Leetcode : YES

class MyQueue(object):

    def __init__(self):
        self.push_stack = []  # Stack for pushing new elements (enqueue operations)
        self.pop_stack = []  # Stack for poping elements(dequeue operations)

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.push_stack.append(x)  # add new element to push_stack
        
        

    def pop(self):
        """
        :rtype: int
        """
        # If pop_stack is empty, transfer all elements from push_stack
        if not self.pop_stack: 
            while self.push_stack:
                self.pop_stack.append(self.push_stack.pop())
        
        return self.pop_stack.pop()  # return and remove the front element
        

    def peek(self):
        """
        :rtype: int
        """
        # If pop_stack is empty, transfer all elements from push_stac
        if not self.pop_stack: 
            while self.push_stack:
                self.pop_stack.append(self.push_stack.pop())

        # Return the front element without removing it
        # Also handles the case when both stacks are empty
        return self.pop_stack[-1] if self.pop_stack else None

    def empty(self):
        """
        :rtype: bool
        """
        if (len(self.push_stack) == 0) and (len(self.pop_stack)==0):
            return True
        
        return False


obj = MyQueue()
obj.push(2)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()