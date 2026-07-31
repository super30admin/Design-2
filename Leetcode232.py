# Time Complexity:
# push: O(1)
# pop: Amortized O(1), worst case O(n)
# peek: Amortized O(1), worst case O(n)
# empty: O(1)

# Space Complexity: O(n), because all elements are stored across the two stacks.

# Did this code successfully run on LeetCode: Yes

class MyQueue(object):

    def __init__(self):
        self.inSt = []
        self.outSt = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.inSt.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if not self.outSt:
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        return self.outSt.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if not self.outSt:
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        return self.outSt[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.inSt and not self.outSt
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()