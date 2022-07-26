# Time Complexity : empty() - O(1), push() - O(1), pop()- worst-O(n), avg O(1), peek - worst -O(n), avg - O(1)
# Space Complexity : o(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No problem


# Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        """
        Initialize two stacks, one for adding and another for pop and peek.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        we will push the element into the stack 1 - takes O(1)
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        if stack2 is not empty we will pop from stack 2 else we will push all the elements in stack1 to stack2 by stack1.pop and return pop of the stack2
        """
        if self.stack2:
            return self.stack2.pop()

        else:
            while self.stack1:
                print("this")
                self.stack2.append(self.stack1.pop())

            return self.stack2.pop()

    def peek(self) -> int:
        """
        if stack2 is not empty we will return last element from stack 2 else we will push all the elements in stack1 to stack2 by stack1.pop and return last element of the stack2
        """
        if self.stack2:
            return self.stack2[-1]

        else:
            while self.stack1:
                self.stack2.append(self.stack1.pop())

            return self.stack2[-1]

    def empty(self) -> bool:
        """
        we will just check if both the stack lengths are 0, if it is then return true, else false.
        """
        if len(self.stack1) == 0 and len(self.stack2) == 0:
            return True

        else:
            return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()