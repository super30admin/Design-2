# Time Complexity : push -> O(1), pop and peek -> O(n) as iterating thru the list, O(1) as python stores the length of list internally
# Space Complexity : O(n) for push, pop and peek as it uses both the list. However, for empty it is O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.queue = []
        self.stack = []

    def push(self, x: int) -> None:
        self.queue.append(x)

    def pop(self) -> int:
        while self.queue:
            self.stack.append(self.queue.pop())
        popped_value = self.stack.pop()
        while self.stack:
            self.queue.append(self.stack.pop())

        return popped_value

    def peek(self) -> int:
        while self.queue:
            self.stack.append(self.queue.pop())
        peeked_value = self.stack[-1]
        while self.stack:
            self.queue.append(self.stack.pop())

        return peeked_value

    def empty(self) -> bool:
        if not self.queue:
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.peek()
obj.pop()
obj.empty()