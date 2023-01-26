"""
Rasika Sasturkar
Time Complexity: O(1) averagely, O(n) sometimes
Space Complexity: O(n), where n is length of stack
"""


class MyQueue:

    def __init__(self):
        """
        Constructor - initialised in_stack used as tail of queue and
        out_stack used as head of queue
        """
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        """
        directly push the element into in_stack
        """
        self.in_stack.append(x)

    def pop(self) -> int:
        """
        out_stack acts as the head of queue, so we pop from out_stack.
        so whenever the out_stack is empty, we empty the in_stack and push them to out_stack
        then pops the element from out_stack
        """
        if len(self.out_stack) == 0:
            while len(self.in_stack) != 0:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self) -> int:
        """
        peek operation is performed by out_stack, and we get the topmost element
        """
        if len(self.out_stack) == 0:
            while len(self.in_stack) != 0:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self) -> bool:
        """
        to check if the queue is empty, we check if our both the stacks are empty
        """
        return len(self.in_stack) == 0 and len(self.out_stack) == 0


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    myQueue = MyQueue()
    myQueue.push(1)  # queue is: [1]
    myQueue.push(2)  # queue is: [1, 2](leftmost is front of the queue)
    print(myQueue.peek())  # return 1
    print(myQueue.pop())  # return 1, queue is [2]
    print(myQueue.empty())  # return false


if __name__ == "__main__":
    main()
