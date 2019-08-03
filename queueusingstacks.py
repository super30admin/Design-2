class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        #intialising two datastructures here
        #instack - push all the elements until u get into pop() function
        #once u get pop(), pop all elements from instack, and push it in outstack
        #pop the top element (FIFO - Queue)
        
        self.instack=[]
        self.outstack=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        
        #just pushing the element
        self.instack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        #if there are items in outstack, we just pop the element from outstack
        if len(self.outstack)!=0:
            item=self.outstack.pop()
            return item
        else:
        #elements are shifted from instck to outstack, and then popped because, 
        #in a stack, the first element will be at the bottom of the stop. 
        #to bring it on the top, you have to move all the elements to a  new stack
        #FIFO - QUEUE
            while len(self.instack)!=0:
                self.outstack.append(self.instack.pop())
            item=self.outstack.pop()
            return item
         

    def peek(self) -> int:
        """
        Get the front element.
        """
        # doing the same as top, but you are just returning the item
        if len(self.outstack)!=0:
            return self.outstack[-1]
        else:
            while len(self.instack)!=0:
                self.outstack.append(self.instack.pop())
            return self.outstack[-1]
            
            
            
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.instack)==0 and len(self.outstack)==0:
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()t