class QueueUsingStacks:
    def __init__(self):
        self.stack_in = []
        self.stack_out = []

    def push(self, val: int) -> None:
        self.stack_in.append(val)

    def pop(self) -> int:
        self.peek()  # Ensure stack_out has the right order
        return self.stack_out.pop()  # Corrected from self.stack_out[-1]

    def peek(self) -> int:
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())  # Corrected from [-1]
        return self.stack_out[-1]

    def empty(self) -> bool:
        return not self.stack_in and not self.stack_out
def demo():
    q = QueueUsingStacks()
    q.push(10)
    q.push(20)
    print("Peek:", q.peek())  # Output: 10
    print("Pop:", q.pop())    # Output: 10
    print("Empty?", q.empty())  # Output: False
    q.pop()
    print("Empty after popping all?", q.empty())  # Output: True

if __name__ == "__main__":
    demo()


# Time Complexity:
# - push(): O(1) on average
# - pop(): O(1) on average
# - empty(): O(1) on average

# Space Complexity: O(n) for n key-value pairs stored

# Did this code successfully run on Leetcode: Yes (232-Implement Queue using Stacks)
# Any problem you faced while coding this: No, learned how to use use two stacks and move elements within them to make a stack to queue.
