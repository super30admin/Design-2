#define instack and outstack as a list to push just append the value to instack
#pop and peek has same first operation of taking value from outstack if its empty pop value from instack and return top value
#to pop use top value from outstack and pop that value
#check empty by checking if both instack and outstack are empty or not
class MyQueue(object):

    def __init__(self):
        self.instack=[]
        self.outstack=[]

    def push(self, x):
        self.instack.append(x)
        
    def pop(self):
        self.peek()
        return self.outstack.pop()
        

    def peek(self):
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]
        

    def empty(self):
        return not self.instack and not self.outstack
        