#Time Complexity : Ammortized O(1) 
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class MyQueue(object):

    def __init__(self):
        self.in_st = []
        self.out_st = []

    def push(self, x):
        self.in_st.append(x)
        
    def pop(self):
        if not self.out_st:
            while self.in_st:
                self.out_st.append(self.in_st.pop())
        return self.out_st.pop()
            
    def peek(self):
        if not self.out_st:
            while self.in_st:
                self.out_st.append(self.in_st.pop())
        return self.out_st[-1]
        

    def empty(self):
        if not self.in_st:
            if not self.out_st:
                return True
        return False
        

