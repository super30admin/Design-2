'''
The two stacks are initialized empty. s1 acts as the stack to push new items.
s2 acts as the stack to pop and peek the items.

Once the items are pushed in the stack s1, and a pop function is called
we start popping the items from s1 and push them into s2.

This helps in reversing the order of items to make sure the FIFO order is 
applied when popping.

This transfer of items from s1 to s2 only happens once for every n items.
The transfer takes O(n) and the pop takes O(1)

Time complexity for
n-pops = O(n) + n times O(1)
n-pops = O(n) + O(n)
n-pops = O(n)

1-pop = O(1)

Hence amortized time complexity will be O(1) for pop and peek as well.
'''
class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        if len(self.s2) == 0:
            for _ in range(len(self.s1)):
                self.s2.append(self.s1.pop())

        return self.s2.pop()

    def peek(self) -> int:
        if len(self.s2) == 0:
            for _ in range(len(self.s1)):
                self.s2.append(self.s1.pop())

        return self.s2[-1]

    def empty(self) -> bool:
        return len(self.s1) == 0 and len(self.s2) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
