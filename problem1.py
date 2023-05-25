# Time Complexity : For pop it is O(n), for the remaining it is O(1)
# Space Complexity : O(n) where n is the number of elements
# Yes the code did ran successfully on leetcode
# I faced no problems during the development and execution of code

class MyQueue(object):
    #Here I am going to implement queue using two stacks (lists)
    def __init__(self):
        self.stack1=[]
        self.stack2=[]
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        #appending the new values to the stack1
        self.stack1.append(x)

    def pop(self):
        """
        :rtype: int
        """
        #if both the stacks are empty we will be returning nothing
        if(len(self.stack1)==0 and len(self.stack2)==0):
            return
        #if there are values in stack1 and if stack2 is empty, then we will move all the values in 
        #stack1 to stack2 such that first inserted value in stack1 will be at the top of stack2
        elif(len(self.stack2)==0 and len(self.stack1)>0):
            while(len(self.stack1)>0):
                temp=self.stack1.pop()
                self.stack2.append(temp)
            return self.stack2.pop()
        #In the remaining cases we will pop the top element of the stack2
        else:
            return self.stack2.pop()
            
        

    def peek(self):
        """
        :rtype: int
        """
        #if stack2 is empty and if stack1 is not empty, then we will return the first value in stack1 (buttom value)
        if(len(self.stack2)==0):
            if(len(self.stack1)!=0):
                return self.stack1[0]
            else:
                return
        #Else we will return top value in stack2
        else:
            return self.stack2[len(self.stack2)-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        #if both stacks are empty we will return True
        if(len(self.stack1)==0 and len(self.stack2)==0):
            return True
        else:
            return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()