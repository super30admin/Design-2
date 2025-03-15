# Time Complexity : O(1) for push, pop, peek and empty
# Space Complexity : O(n) where n is the number of elements in the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:
    # Initialize two stacks, using one stack for push operation and another stack for pop and peek operations
    def __init__(self):
        self.stOne = []
        self.stTwo = []

    # Push the element into the first stack
    def push(self, x: int) -> None:
        self.stOne.append(x)

    # Pop the element from the second stack
    def pop(self) -> int:
        # If the second stack is empty, move all the elements from the first stack to the second stack
        # and pop the element from the second stack
        if len(self.stTwo) == 0:
            while self.stOne:
                ele = self.stOne.pop()
                self.stTwo.append(ele)
        # Pop the element from the second stack
        return self.stTwo.pop()

    # Peek the element from the second stack
    def peek(self) -> int:
        # If the second stack is empty, move all the elements from the first stack to the second stack
        # and peek the element from the second stack
        if len(self.stTwo) == 0:
            while self.stOne:
                ele = self.stOne.pop()
                self.stTwo.append(ele)
        # Peek the element from the second stack
        return self.stTwo[-1]

    # Check if both the stacks are empty
    def empty(self) -> bool:
        # Return True if both the stacks are empty
        return len(self.stOne) == 0 and len(self.stTwo) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()