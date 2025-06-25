'''
232. Implement Queue using Stacks
'''

# Time Complexity : O(1) for push, O(n) for pop and peek in the worst case when we need to transfer elements from stack1 to stack2
# Space Complexity : O(n) for the two stacks used to implement the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Python program to implement a queue using two stacks

class MyQueue: # humne ek class MyQueue banayi hai jo queue data structure ko implement karegi using two stacks (We create a class MyQueue that implements a queue data structure using two stacks)

    def __init__(self): # humne MyQueue class ka constructor banaya hai jo do stacks ko initialize karega (We create the constructor of MyQueue class that initializes two stacks)
        # Initialize two stacks
        self.stack1 = [] # pehla stack jo elements ko store karega (first stack that will store the elements)
        self.stack2 = [] # doosra stack jo elements ko pop karne ke liye use hoga (second stack that will be used to pop elements)
        # No need to initialize size as we can use len() on the stacks
        

    def push(self, x: int) -> None: # humne push method banaya hai jo ek element x ko queue mein daalega (We create a push method that will add an element x to the queue)
        # Push element to the first stack
        self.stack1.append(x) # yahaan hum element x ko stack1 mein append kar rahe hain (Here we append the element x to stack1)
        # No need to return anything as per problem statement
        return None # yahaan hum kuch return nahi kar rahe hain kyunki problem statement mein kuch return karne ki zarurat nahi hai (Here we are not returning anything as per the problem statement)
        

    def pop(self) -> int: # humne pop method banaya hai jo queue se ek element ko pop karega (We create a pop method that will pop an element from the queue)
        # If stack2 is empty, move elements from stack1 to stack2
        if self.stack2 == []: # agar stack2 khali hai toh stack1 ke elements ko stack2 mein transfer karte hain (if stack2 is empty, we transfer elements from stack1 to stack2)
            while self.stack1 != []: # jab tak stack1 khali nahi hai, tab tak elements ko stack2 mein daalte hain (while stack1 is not empty, we keep moving elements to stack2)
                self.stack2.append(self.stack1.pop()) # yahaan hum stack1 se elements ko pop karte hain aur stack2 mein append karte hain (Here we pop elements from stack1 and append them to stack2)
        # Pop the top element from stack2 and return it
        if self.stack2 == []: # agar stack2 ab bhi khali hai toh hum kuch nahi karte (if stack2 is still empty, we do nothing)
            return None # yahaan hum kuch return nahi kar rahe hain kyunki stack2 khali hai (Here we are not returning anything as stack2 is empty)
        return self.stack2.pop() # yahaan hum stack2 se top element ko pop karte hain aur return karte hain (Here we pop the top element from stack2 and return it) 

    def peek(self) -> int: # humne peek method banaya hai jo queue ke front element ko return karega bina usse pop kiye (We create a peek method that will return the front element of the queue without popping it)
        # If stack2 is empty, move elements from stack1 to stack2
        if self.stack2 == []: # agar stack2 khali hai toh stack1 ke elements ko stack2 mein transfer karte hain (if stack2 is empty, we transfer elements from stack1 to stack2)
            while self.stack1 != []: # jab tak stack1 khali nahi hai, tab tak elements ko stack2 mein daalte hain (while stack1 is not empty, we keep moving elements to stack2)
                self.stack2.append(self.stack1.pop()) # yahaan hum stack1 se elements ko pop karte hain aur stack2 mein append karte hain (Here we pop elements from stack1 and append them to stack2)
        # Return the top element from stack2 without removing it
        if self.stack2 == []: # agar stack2 ab bhi khali hai toh hum kuch nahi karte (if stack2 is still empty, we do nothing)
            return None # yahaan hum kuch return nahi kar rahe hain kyunki stack2 khali hai (Here we are not returning anything as stack2 is empty)
        return self.stack2[-1]  # yahaan hum stack2 ke top element ko return karte hain bina usse pop kiye (Here we return the top element of stack2 without popping it)

    def empty(self) -> bool: # humne empty method banaya hai jo check karega ki queue khali hai ya nahi (We create an empty method that will check if the queue is empty or not)
        # Return True if both stacks are empty, False otherwise
        return self.stack1 == [] and self.stack2 == [] # yahaan hum check karte hain ki dono stacks khali hain ya nahi (Here we check if both stacks are empty or not)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()