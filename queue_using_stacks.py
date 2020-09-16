class Stack():
    def __init__(self):
        self.stack = []
        self.size = 0
    def push(self, item):
        self.stack.append(item)  
        self.size += 1
    def pop(self):
        if(self.size>0):
            self.size -= 1
            return self.stack.pop()  
        return None
    def peek(self):
        if(self.size):
            return self.stack[self.size-1]
        return None
    def get_size(self):  
        return self.size
    def isEmpty(self):
        return self.size==0

class MyQueue:
    #my approach was to keep push() simple push to in_stack. On call of pop(), unload onto out_stack and pop()
    #inorder to handle peek, I maintain a variable first_element, to keep track of item in queue front
    #Did this successfully run on leetcode - yes
    #Time Complexity O(1) for push(), peek() and empty(), O(n) for pop()
    #Space Complexity O(n) for the 2 stacks
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.in_stack = Stack()
        self.out_stack = Stack()
        self.first_element = None

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if(self.empty()):
            self.first_element = x
            
        self.in_stack.push(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if(self.out_stack.isEmpty()):
            while(self.in_stack.isEmpty()!=True):
                self.out_stack.push(self.in_stack.pop())
        
        popped_item = self.out_stack.pop()
        
        if(self.out_stack.isEmpty()):
            while(self.in_stack.isEmpty()!=True):
                self.out_stack.push(self.in_stack.pop())
        
        self.first_element = self.out_stack.peek() 
        return popped_item
        
    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.first_element
        
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (self.in_stack.isEmpty() and self.out_stack.isEmpty())


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()