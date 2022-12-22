# Time Complexity :
# Push - O(1)
# Pop and peek - O(N) worst case, O(1) amortized

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
# No

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        #Push in stack 1 - always
        self.stack1.append(x)

    def pop(self) -> int:
        if len(self.stack2 ) == 0:
            if len(self.stack1) == 0 :
                #If both stacks are empty - nothing to pop
                return -1
            # if only second stack is empty - then move elements from stack 1 to stack 2 
            # and return top element of stack 2
            for i in range(1,len(self.stack1)+1):
                self.stack2.append(self.stack1[-i])
            self.stack1 = []
            value = self.stack2[-1]
            self.stack2 = self.stack2[:-1]
            return value

        else :
            #If elements exist in stack 2, then just return top element of stack2
            value = self.stack2[-1]
            self.stack2 = self.stack2[:-1]
            return value

    def peek(self) -> int:
        
        # if only second stack is empty - then move elements from stack 1 to stack 2 
        # and return top element of stack 2
        if len(self.stack2) ==  0 :
            if len(self.stack1) == 0 :
                return -1
            for i in range(1,len(self.stack1)+1):
                self.stack2.append(self.stack1[-i])
            self.stack1 = []
        #If elements exist in stack 2, then just return top element of stack2
        return self.stack2[-1]

    def empty(self) -> bool:
        #If an element exists in either stack, then the queue is not empty
        if len(self.stack1) != 0 or len(self.stack2) != 0 :
            return False
        else :
            return True

