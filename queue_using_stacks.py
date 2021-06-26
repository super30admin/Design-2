
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : No



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

        #Time complexity : O(1)
        #Space complexity : O(n)
        self.stack1.append(x)
        

    def pop(self) -> int:
        #Time complexity : O(n)
        #Space complexity : O(n)
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.stack1)==0 and len(self.stack2)==0:
            print("Queue is Empty")
            return
        else:
            if len(self.stack2)==0 and len(self.stack1)>0:
                while(self.stack1):
                    self.stack2.append(self.stack1.pop())
                return self.stack2.pop()
            
            else:
                return self.stack2.pop()
        

    def peek(self) -> int:

        #Time complexity : O(n)
        #Space complexity : O(n)
        """
        Get the front element.
        """
        if len(self.stack2)!=0:
            return self.stack2[-1]
        elif len(self.stack2)==0:
            while(self.stack1):
                self.stack2.append(self.stack1.pop())
            if len(self.stack2)>0:
                return self.stack2[-1]
            else:
                print("Queue is empty")
                return
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stack2)==0 and len(self.stack1)==0:
            print("Queue is empty")
            return True
        else:
            return False
            
        


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(5)
obj.push(6)
obj.push(7)
obj.push(8)

param_2 = obj.pop()
print(param_2)
param_3 = obj.pop()
print(param_3)
param_4 = obj.peek()
print("peek element is {}".format(param_4))
param_45= obj.empty()
print(param_45)
param_33 = obj.pop()
print(param_33)

param_31 = obj.peek()
print("peek element is {}".format(param_31))

