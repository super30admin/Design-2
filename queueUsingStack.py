# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
class queueUsingStack:
    # we use 2 stacks to create our queue --> inStack and outStack
    # we keep pushing the element in inStack regardless of whatever happens
    ## the moment a pop operation comes, we check if outstack is empty. if it is then we pop all elements from in to out.
    ## we do this in peek operation, we can have a separate function outisde and use it in peek and pop for code modularity.
    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, val):
        self.inStack.append(val)

    
    def pop(self):
        self.peek()
        return self.out.pop()
    
    def peek(self):
        if not self.outStack:
            while(self.inStack):
                self.out.append(self.inStack.pop())
        
        return self.outStack[-1]
    
    def empty(self):

        return not self.inStack and not self.outStack
            

queueUsingStackInstance = queueUsingStack()
print(queueUsingStackInstance.push(7))
print(queueUsingStackInstance.push(7))
print(queueUsingStackInstance.push(7))
print(queueUsingStackInstance.push(7))