# Time complexity is o(1) and space complexity is O(N)

class MyQueue(object):

    def __init__(self):
        self.s1 = []
        self.s2 = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.s1.append(x)

    def pop(self):
        """
        :rtype: int
        """
        while not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()                

    def peek(self):
        """
        :rtype: int
        """
        while not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return max(len(self.s1), len(self.s2)) == 0 