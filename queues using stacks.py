class MyQueue:

    def __init__(self):
        #creating two stacks because we will be using one to store and one to pop for better complexity
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        self.instack.append(x)    #just inserting the data into instack    TC: O(1) SC:O(1)

    def pop(self) -> int:
        self.peek()
        return self.outstack.pop()      #popping the items is 0(1) for time and space compelxity

    def peek(self) -> int:                      #just looking at peek of the outstack
        if not self.outstack:                   #if the outstack is empty. it goes through the next while loop to add items from instack to outstack
            while self.instack:                         #time complexity is O(n) space compexity is o(1)
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self) -> bool:                   # if the both the stacks are empty it returns true else false
        return not self.instack and not self.outstack