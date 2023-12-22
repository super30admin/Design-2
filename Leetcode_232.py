#moving elements between the main stack and a temporary stack for each pop or peek operation to reverse the order of the elements.
#Time complexity: O(1) for push, O(n) for pop and peek(worst case)
#space complexity: O(n)
class MyQueue:
    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self) -> bool:
        return not self.in_stack and not self.out_stack


# Create a MyQueue object
my_queue = MyQueue()

# Push elements into the queue
my_queue.push(10)
my_queue.push(20)
my_queue.push(30)

# Check if the queue is empty
print(my_queue.empty())  

# Peek at the front of the queue
print(my_queue.peek())  

# Pop an element from the front of the queue
print(my_queue.pop())   
