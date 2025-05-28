class MyQueue:

    def __init__(self):
        self.input_stack=[]
        self.output_stack=[]

    def push(self,x):
        self.input_stack.append(x)

    def pop(self):
        self._move_input_to_output()
        return self.output_stack.pop()
    
    def peek(self):
        self._move_input_to_output()
        return self.output_stack[-1]
    
    def empty(self):
        return not self.input_stack and not self.output_stack
    
    def _move_input_to_output(self):
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())

output=[]

myQueue =MyQueue()
output.append(None)

myQueue.push(1)
output.append(None)

myQueue.push(2)
output.append(None)

output.append(myQueue.peek())
output.append(myQueue.pop())
output.append(myQueue.empty())

print(output)