#implement Queue Using stacks
# I am going to implement a solution using two stacks the one we had discuseed in class
#TimeComplexity: amortized O(1),worst case O(n)
#space complexity: O(n) 
#Python solution was accepted by leetcode after 3 tries, it was getting timed out on the while loop
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = [] #initalize stack1 
        self.stack2= []   #initialize stack2

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)  #only appeneding value to stack 1

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()  #calling peek function from below
        return self.stack2.pop()            #using python built in function
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        #since we are mainting two stack ,check if out stack is empty if it is transfer stack 1 to stack 2
        if (len(self.stack2))==0:
            while len(self.stack1)!=0:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
                
            
            

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        #if bot stacks are empty return True
        return (not self.stack1) and (not self.stack2) 


    

