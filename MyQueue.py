# // Time Complexity : push O(1), pop O(1) amortized, empty O(1), peek amortized O(1),  since if we need to shift then O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class MyQueue(object):
    # queue fifo, with one stack we will add elements in the stack and since the pop fuction pops the first element pushed should be poped
    # will have one more stack, and when push comes we push into the first stack and when pop comes, we will check if the second stack is empty
    # if empty we traverse the elements from first stack to second sack in this wasy the first element pushed into the first stack will be the top element in the 
    # secodn stack, and untll the secodn satck si empty keep poping from the second stack, and iterate the approach

    def __init__(self):
        self.pushstack = []
        self.popstack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.pushstack.append(x)

    def pop(self):
        """
        :rtype: int
        """
        self.peek() # arranges the stacks 
        return self.popstack.pop()


    def peek(self):
        """
        :rtype: int
        """
        if not self.popstack:
            while self.pushstack:
                self.popstack.append(self.pushstack.pop())
        return self.popstack[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.pushstack and not self.popstack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()