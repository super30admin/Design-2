# Time — push and empty are always O(1). peek and pop are O(1) amortized because each item moves at most once!
# Space — O(n) because both stacks together store n items and grow with input!
# I created two stacks(lists) instack and outstack, where all new items are pushed into instack
# When peek or pop is called, if outstack is empty we transfer all items from instack to outstack one by one which reverses the order giving us FIFO behaviour
# pop removes and returns the front element from outstack, peek just returns it without removing, and empty checks if both stacks have no items


class MyQueue:

    def __init__(self):               #creating 2 stacks since it will work as FIFO which is basically a queue
      self.instack = []               #creating 2 emplty lists which will work as stack since py doesnt directly allow stacks    
      self.outstack = []

    def push(self, x: int) -> None:   #simply appending all the numbers to the 1st stack using append() method
      self.instack.append(x)
        

    def pop(self) -> int:             #I did this part after push since i wanted to use peek()funtion
        if self.empty():              #basically checks if botht the stacks are empty or not
            return -1
        self.peek()                   #all peek() to tranfser from instack to outstack if outstack is empty
        return self.outstack.pop()    #popping out the element
        

    def peek(self) -> int:                        #doing this part after push since we need to use it in pop
        if len(self.outstack)==0:                 #checking if the outstack is empty
            while self.instack:                   #if outstack is empty then push the elements from instack to outstack
              self.outstack.append(self.instack.pop())
        return self.outstack[-1]                  #returning top element of outstack which is the front of queue
        

    def empty(self) -> bool:
        return len(self.instack)==0 and len(self.outstack)==0       #just checking if both the stacks are empty 
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()