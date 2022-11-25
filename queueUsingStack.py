#Time Complexity :  push O(1), pop and peek O(1) average case, empty O(1)
#Space Complexity : O(n) since we are using stack data structure
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No issues faced

#Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        self.inStack = []                           #creating inStack
        self.outStack = []                          #creating outStack

    def push(self, x: int) -> None:
        self.inStack.append(x)                      #appending values onto inStack

    def pop(self) -> int:
        self.peek()                                 #perform peek operation
        return self.outStack.pop()                  #pop top element from outStack

    def peek(self) -> int:
        if not self.outStack:                       #if outStack is empty we transfer
            while self.inStack:                     #all values from inStack to outStack
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]                    #return top of outStack as peek value

    def empty(self) -> bool:
        return not self.inStack and not self.outStack   #returns true if both inStack and outStack are empty 
                                                        #else returns false


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()