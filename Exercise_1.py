#Explain your approach in **three sentences only** at top of your code
''' Keeps a main stack for pushed values. Also keeps a pop stack that 
is transfered from the main stack when pop stack is empty.
'''
# Time Complexity : O(1), because transfer of main stack happens once in a while.
# Space Complexity : O(N), N being the length of the stack. 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took me a bit to figure out
# and implement the strategy. The transfer from part tripped me in the beginning. 


# Your code here along with comments explaining your approach

class MyQueue:
    def __init__(self):
        self.stack_q_main = []
        self.stack_q_pop = []
        self.queue_length = 0
        self.stack_transfer_pop = 0

    def push(self, x: int) -> None:
        self.stack_q_main.append(x)
        self.queue_length = self.queue_length + 1

    # Used if stack designated for pop values is empty
    def transfer_to_pop(self)->None:
        # if length of queue is not equal to stack pop, then trim the 
        # the main stack of old transferred pop values. 
        if self.queue_length!=len(self.stack_q_pop):
            trim = self.stack_transfer_pop
            temp = self.stack_q_main[trim:]
            self.stack_q_main = temp
            self.stack_q_pop = []
            self.queue_length = len(self.stack_q_main)
        # transfer from stack main to stack pop. 
        for i in range(len(self.stack_q_main)):
            value = self.stack_q_main[len(self.stack_q_main)-1-i]
            self.stack_q_pop.append(value)
        # new saved stack pop length
        self.stack_transfer_pop=len(self.stack_q_pop)

    def pop(self) -> int:
        if len(self.stack_q_pop)==0:
            self.transfer_to_pop()
        # if stack pop isn't empty, just pop from stack pop. 
        if not self.empty():
            length = len(self.stack_q_pop)
            self.queue_length = self.queue_length - 1
            return self.stack_q_pop.pop(length-1)

    # similar to pop. 
    def peek(self) -> int:
        if len(self.stack_q_pop)==0:
            self.transfer_to_pop()
        if not self.empty():
            length = len(self.stack_q_pop)
            return self.stack_q_pop[length-1]            

    def empty(self) -> bool:
        if self.queue_length==0:
            return True
        else:
            return False