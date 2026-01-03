class MyQueue:

    def __init__(self):
        self.in_stack =[]
        self.out_stack = []


    def push(self, key)->None:
        self.in_stack.append(key)


    def pop(self)->None:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())

        return self.out_stack.pop()


    def peek(self)->int:
        if not(self.out_stack):
            while(self.in_stack):
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self)->bool:
        if self.in_stack ==[] and self.out_stack==[]:
            return True
        return False



