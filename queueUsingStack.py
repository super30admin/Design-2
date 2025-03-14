# Implementing a Queue using two stacks (_inStack and _outStack).
# TC: O(1) for push operation, O(n) for pop and peek operations when elements need to be transferred between stacks.
# SC: O(n) for the space used by the stacks, where n is the number of elements in the queue.


class MyQueue:

    def __init__(self):
        self._inStack = []  # to handle push operations
        self._outStack = []  # to handle peek and pop operations

    # push element in the _inStack
    def push(self, x: int) -> None:
        self._inStack.append(x)

    def pop(self) -> int:
        if self.empty():  # If the queue is empty
            return None
        if (
            not self._outStack
        ):  # transfer elements from inStack to outStack if outStack is empty
            while self._inStack:
                self._outStack.append(self._inStack.pop())
        return self._outStack.pop()  # Pop the front of the queue from outStack

    def peek(self) -> int:
        if self.empty():
            return None
        if (
            not self._outStack
        ):  # transfer elements from inStack to outStack if outStack is empty
            while self._inStack:
                self._outStack.append(self._inStack.pop())
        return self._outStack[-1]  # Peek the front element from outStack

    def empty(self) -> bool:
        return not (
            self._outStack or self._inStack
        )  # Queue is empty if both stacks are empty


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(10)
obj.push(20)
obj.push(30)
param_2 = obj.pop()
print(param_2)
param_3 = obj.peek()
print(param_3)
param_4 = obj.empty()
print(param_4)
