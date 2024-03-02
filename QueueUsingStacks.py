# TC - push - O(1), pop- O(n) ,Peek - O(n)

# SC = O(n)


class MyQueue:

    def __init__(self):
        self.stack = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        while self.stack:
            self.stack2.append(self.stack.pop())
        result = self.stack2.pop()
        while self.stack2:
            self.stack.append(self.stack2.pop())

        return result

    def peek(self) -> int:
        while self.stack:
            self.stack2.append(self.stack.pop())
        result = self.stack2[-1]
        while self.stack2:
            self.stack.append(self.stack2.pop())
        return result

    def empty(self) -> bool:
        return len(self.stack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
