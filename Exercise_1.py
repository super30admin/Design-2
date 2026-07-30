# Implement Queue using Stacks
# https://leetcode.com/problems/implement-queue-using-stacks/

# Time complexity: O(1)
# Space complexity: O(n)

# uses an in stack for all incoming elements; when either peek or pop operation is called, then all elements from in stack is moved to out stack;
# this way out stack will have the first element added

class MyQueue:

    def __init__(self):
        self.in_st = []
        self.out_st = []

    def push(self, x: int) -> None:
        self.in_st.append(x)

    def pop(self) -> int:
        if self.empty():
            return -1

        self.peek()
        return self.out_st.pop()

    def peek(self) -> int:
        if self.empty():
            return -1

        if not self.out_st:
            while self.in_st:
                self.out_st.append(self.in_st.pop())

        return self.out_st[-1]

    def empty(self) -> bool:
        return not self.in_st and not self.out_st


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
