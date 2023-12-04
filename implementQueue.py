# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class MyQueue:

    def __init__(self) -> None:
        self.s1=[]
        self.s2=[]

    def push(self,key):
        self.s1.append(key)

    def pop(self):
        #push elements from s1 to s2
        while(len(self.s1)):
            self.s2.append(self.s1.pop())  
        #pop the top element from s2    
        a=self.s2.pop()
        #again put back the elements to s1 to maintain te order
        while(len(self.s2)!=0):
            self.s1.append(self.s2.pop())
        return a
            
    def peek(self):
               #push elements from s1 to s2
        while(len(self.s1)!=0):
            self.s2.append(self.s1.pop())  
        # top element from s2    
        res=self.s2[-1]
        #again put back the elements to s1 to maintain te order
        while(len(self.s2)):
            self.s1.append(self.s2.pop())
        return res

    def empty(self):
        return len(self.s1)==0 and len(self.s2)==0


obj=MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
obj.peek()
obj.pop()

