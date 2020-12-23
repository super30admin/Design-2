class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)
        
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if(self.empty()):
            return -1
        if(len(self.stack2)==0):
            while(len(self.stack1)>0):
                self.stack2.append(self.stack1.pop())
        element = self.stack2.pop()
        return element

    def peek(self) -> int:
        """
        Get the front element.
        """
        if(not self.empty()):
            if(len(self.stack2)>0):
                return self.stack2[-1]
            else:
                while(len(self.stack1)>0):
                    self.stack2.append(self.stack1.pop())
                return self.stack2[-1]
        else:
            return -1
        
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if(len(self.stack1)==0 and len(self.stack2)==0):
            return True
        else:
            return False
        
