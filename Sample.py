// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach

# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
# My approach
Initialize two stacks 
Keep on push the element to the push_stack 
When pop comes push all the items to pop stack  from push_stack and pop out the Last element.
If its empty return False
class MyQueue:

    def __init__(self):
        self.push_stack = []
        self.pop_stack =[]

    def push(self, x: int) -> None:
        self.push_stack.append(x)

    def pop(self) -> int:
        if self.empty(): return
        if len(self.pop_stack):
            return self.pop_stack.pop()
        else:
            while len(self.push_stack):
                self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack.pop()

    def peek(self) -> int:
        if self.empty(): return
        if len(self.pop_stack):
            return self.pop_stack[-1]
        else:
            while len(self.push_stack):
                self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack[-1]

    def empty(self) -> bool:
        return len(self.push_stack)==False and len(self.pop_stack) == False
        
Time Complexity : 0(1), push: 0(1), Pop - 0(n), peek - 0(n), empty - 0(1), Space Complexity: 0(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : nope

## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
# My approach
Intialize the data
put updates the value associated with that key.
get key returns the value to which the specified key is mapped
removes the mapping of the specified value key if this map contains a mapping for the key
if no mapping for the key is -1.

class MyHashMap:
    
    def __init__(self):
        self.my_array = [-1 for i in range(1000001)]
        
    def put(self, key: int, value: int) -> None:
        self.my_array[key] = value
        
    def get(self, key: int) -> int:
        return self.my_array[key]
        
    def remove(self, key: int) -> None:
        self.my_array[key] = -1

Time Complexity : 0(1), Space Complexity: 0(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : nope



