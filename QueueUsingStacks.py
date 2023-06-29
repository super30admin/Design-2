# Time Complexity :O(1) - amortized
# Space Complexity : O(n)
# Procedure/Logic: we have declared 2 lists - 
# list1(stack_in) we will be using for pushing the elements
# list2(stack_out) - for poping the elements
# Push function: Here, we just add elements to the list1
# pop function: if the list2 is empty , we push the elements of list1(in reverse order) into list2
#               so that we can access the first element which is pushed into list1 at index[-1] in list2
# peek function: We will return the index[-1] of list2 - this gives the first element 
# empty function: check if both the lists are empty if empty returns True

class MyQueue:

    def __init__(self):
        self.stack_in = []
        self.stack_out = []

    def push(self, x: int) -> None:  # O(1)
        self.stack_in.append(x)

    def pop(self) -> int:   #O(1) - amortized 
        self.peek()
        return self.stack_out.pop()

    def peek(self) -> int:  #O(1) -amortized
        if self.stack_out == []:
            self.stack_out.extend(reversed(self.stack_in))
            self.stack_in.clear()

        return self.stack_out[-1]

    def empty(self) -> bool:    #O(1)
        return not self.stack_in and  not self.stack_out 
    
    
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
param_1 = obj.peek()
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.pop()
param_5 = obj.peek()
param_6 = obj.empty()
param_7 = obj.pop()
param_8 = obj.empty()
