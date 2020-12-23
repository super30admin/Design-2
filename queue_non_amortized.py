class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []
        self.front = None
        
    # O(1)
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)
        if(len(self.stack1) == 1):
            self.front = x
        
        
    # O(n)
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if(self.empty()):
            return -1
        while(len(self.stack1)>1):
            self.stack2.append(self.stack1.pop())
        element = self.stack1.pop()
        if(len(self.stack2)>0):
            self.front = self.stack2[-1]
        else:
            self.front = None
        while(len(self.stack2)>0):
            self.stack1.append(self.stack2.pop())
        
        return element

    # O(1)
    def peek(self) -> int:
        """
        Get the front element.
        """
        if(not self.empty()):
            return self.front
        else:
            return -1
    
    # O(1)
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if(len(self.stack1)==0):
            return True
        else:
            return False
        