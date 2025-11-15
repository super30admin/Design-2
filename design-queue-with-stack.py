# Take two stacks - instack and outstack. For push, push it in instack. 
# For pop, check if there are elements in outstack. If present, pop it 
# else pop all the elements from instack to outstack and then pop the last 
# elememt from outstack. Same logic for peek.
# Time complexity: 
# O(1) for push
# O(1) for pop when the elememt is present in the outstack, O(n) when the element is not present
# O(1) for peek when the elememt is present in the outstack, O(n) when the element is not present
# O(1) for is empty
# Space complexiy:
# O(n)


class MyQueue(object):

    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.instack.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if self.peek():
            return self.outstack.pop()
        else:
            return None

    def peek(self):
        """
        :rtype: int
        """
        if not self.outstack:
            while self.instack:
                p = self.instack.pop()
                self.outstack.append(p)
        if self.outstack:
            return self.outstack[-1]
        else:
            return None
               

    def empty(self):
        """
        :rtype: bool
        """
        if len(self.instack)==0 and len(self.outstack)==0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()