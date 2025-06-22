"""
Queue is FIFO.
Maintain 2 stacks-in and out. 

Solution 1:  
Push elements to in-stack. 
When you get a pop, move all elements from in-stack to out-stack, so that the first element in in-stack becomes the last element in out-stack. Do a pop operation from the out stack. Then move back the elements from out-stack to in-stack.  Then pop from out-stack till the out-stack is empty. Once the out-stack is empty, push elements from the in-stack to the out-stack if present and repeat the pop operation if needed.
Time Complexity:
push: O(1)
pop: O(n)
top: O(n) --> transfer elements to out-stack and peek()
Solution 2: 
Transfer all elements in in-stack to out-stack. Push in in-stack. Transfer elements back from out-stack to in-stack.
When you get a pop, pop from in-stack. 
Top is peek() from in-stack.
Time Complexity:
push: O(n)
pop: O(1)
top: O(1)
Solution 3 (Optimal):
Push elements to in-stack.
When you get a pop, move all elements from in-stack to out-stack, so that the first element in in-stack becomes the last element in out-stack stack. Then pop from out-stack till the out-stack is empty. Once the out-stack is empty and there are elements in the in-stack, push elements from the in-stack to the out-stack and repeat the pop operation. 
Top is peek() on out-stack. Similar to pop operation.
Time Complexity:
push: O(1)
pop: Ammortized O(1)
top: Ammortized O(1)
empty: O(1)

Edge cases:
1. in and out stack are empty.
"""

class Queue:
  def __init__(self):
    self.inStack = []
    self.outStack = []
    
    
  def push(self, val):
    self.inStack.append(val)
    
    
  def pop(self):
    if len(self.outStack) == 0:
      if len(self.inStack) == 0:
        raise Exception("Queue is empty")
      while self.inStack:
        self.outStack.append(self.inStack.pop())        
    return self.outStack.pop()
      
    
  def top(self):
    if len(self.outStack) == 0:
      if len(self.inStack) == 0:
        raise Exception("Queue is empty")
      while self.inStack:
        self.outStack.append(self.inStack.pop())  
    return self.outStack[-1]
    
    
  def empty(self):
    return len(self.inStack) == 0 and len(self.outStack) == 0
  
  
myQueue = Queue()
myQueue.push(1)
myQueue.push(2)
myQueue.push(3)
myQueue.push(4)
print(myQueue.top())
print(myQueue.pop())
print(myQueue.pop())
print(myQueue.pop())
myQueue.push(5)
print(myQueue.pop())
myQueue.push(6)
print(myQueue.pop())
myQueue.push(7)