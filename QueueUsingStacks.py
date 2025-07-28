class MyQueue(object):

    def __init__(self):
        # stack_in is used to handle incoming elements (for push)
        # stack_out is used to reverse the order for FIFO behavior (for pop/peek)
        self.stack_in = []
        self.stack_out = []
        print("Initialized MyQueue")

    def push(self, x):
        # Push new elements to stack_in
        self.stack_in.append(x)
        print(f"Pushed {x} -> stack_in: {self.stack_in}")


    def pop(self):
        # Check stack_out has the current queue order
        self._transfer()
        # Pop from stack_out which represents the front of the queue
        val= self.stack_out.pop()
        print(f"Popped {val} -> stack_out: {self.stack_out}")
        return val

    def peek(self):
        # Check stack_out has the current queue order
        self._transfer()
        # Peek at the top of stack_out which is the front of the queue
        val=  self.stack_out[-1]
        print(f"Peeked {val} -> stack_out: {self.stack_out}")
        return val

    def empty(self):
        # Queue is empty only if both stacks are empty
        is_empty= not self.stack_in and not self.stack_out
        print(f"Empty check -> {is_empty}")
        return is_empty

    def _transfer(self):
        if not self.stack_out:
            print("Transferring from stack_in to stack_out...")
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
            print(f"After transfer -> stack_in: {self.stack_in}, stack_out: {self.stack_out}")

if __name__ == "__main__":
    obj = MyQueue()
    obj.push(1)
    obj.push(2)
    print(obj.peek())   # Should print 1
    print(obj.pop())    # Should print 1
    print(obj.empty())  # Should print False
