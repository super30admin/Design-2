# Time Complexity: O(1)
# Space Complexity: O(n)
class MyQueue:

    def __init__(self):
        self.queue1 = []
        self.queue2 = []

    def push(self, x: int) -> None:
        self.queue1.append(x)

    def pop(self) -> int:
        self.peek()  # To transfer elements from one stack to another
        if self.queue2:
            return self.queue2.pop()

    def peek(self) -> int:
        if not self.queue2:  # if stack2 is empty and if peek or pop operation is required then transfer elements from stack1 to stack2
            while self.queue1:
                self.queue2.append(self.queue1.pop())
        if self.queue2:
            return self.queue2[-1]

    def empty(self) -> bool:
        return len(self.queue1) == 0 and len(self.queue2) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()