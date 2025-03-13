"""
# Time Complexity : 
Push : O(1)
Pop : Worst O(n) anerage: O(1)
peek : Worst O(n) anerage: O(1)
empty : O(1)

# Space Complexity : O(n)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

Approach: We created 2 stacks(Input_stack and output_stack).
for push: we directly push into the input_stack
for pop and peek: Initially we check whether the 2 stacks are empty or not. if not empty, then we need to perform pop/peek from output stack. 
if output stack is not empty, we do a pop operation else we transfer all the elements from input_stack to output_staack
 For empty: we check and both input and output stack are empty or not
"""

class MyQueue:

    def __init__(self):
        self.input_stack = []
        self.output_stack = []
        
    def push(self, x: int) -> None:
        self.input_stack.append(x)
        
    def pop(self) -> int:
        if self.empty():
            print("Queue is empty")
            return None
        self.move_input_to_output()
        return self.output_stack.pop()

    def peek(self) -> int:
        if self.empty():
            print(Queue is empty)
            return None
        self.move_input_to_output()
        return self.output_stack[-1]

    def empty(self) -> bool:
        return not self.input_stack and not self.output_stack

    def move_input_to_output(self) -> None:
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())

        

"""
Example 

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
"""


myQueue = MyQueue()
output = [None]
output.append(myQueue.push(1))  #queue is: [1]
output.append(myQueue.push(2)) #queue is: [1, 2] (leftmost is front of the queue)
output.append(myQueue.peek()) #return 1
output.append(myQueue.pop()) #return 1, queue is [2]
output.append(myQueue.empty()) #return false

print(output)