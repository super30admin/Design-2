class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack=[]
        self.outStack=[]

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.outStack)==0:
            #push items from instack to outstack
            while len(self.inStack)>0:
                self.outStack.append(self.inStack.pop())
            return self.outStack.pop()
        else:
            return self.outStack.pop()


    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.outStack)==0:
            while len(self.inStack)>0:
                self.outStack.append(self.inStack.pop())
            return self.outStack[-1]
        else:
            return self.outStack[-1]


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.inStack) ==0 and len(self.outStack)==0



obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(5)
param_2 = obj.pop()
print(param_2)
param_3 = obj.peek()
print(param_3)
param_4 = obj.empty()
print(param_4)
