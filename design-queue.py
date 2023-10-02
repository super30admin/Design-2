# Q. Design queue using stacks
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue(object):
    def __init__(self):
        self.in_arr = []
        self.out_arr = []

    # TC: O(1), SC: O(1)
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.in_arr.append(x)
        return

    # TC: O(1) when out array is empty, else O(n) where n of elements
    # SC: Scales with input
    def pop(self):
        """
        :rtype: int
        """
        if (len(self.out_arr) == 0):
            while (len(self.in_arr) != 0):
                self.out_arr.append(self.in_arr.pop())
        return self.out_arr.pop()

    # TC: O(1) when out array is empty, else O(n) where n of elements
    # SC: Scales with input
    def peek(self):
        """
        :rtype: int
        """
        if len(self.out_arr) != 0:
            return self.out_arr[-1]
        while (len(self.in_arr) != 0):
            self.out_arr.append(self.in_arr.pop())
        return self.out_arr[-1]

    # TC: O(1)
    # SC: O(1)
    def empty(self):
        """
        :rtype: bool
        """
        if (len(self.in_arr) == 0 and len(self.out_arr) == 0):
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

# obj = MyQueue()
# obj.push(3)
# obj.push(5)
# obj.push(2)
# print(obj.pop())

# obj.push(1)
# obj.push(7)
# print(obj.pop())
# param_3 = obj.peek()
# param_4 = obj.empty()
