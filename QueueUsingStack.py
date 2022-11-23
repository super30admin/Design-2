"""
    Problem Statement: Design a Queue using 2 stacks.

    Approach: We have no restrictions on using in-built stack functions, however, in python, lists are similar to stacks.
              We have 2 stacks, in_stack and out_stack. During push operation we push the elements in the in_stack. 
              During pop operation we check whether out_stack is empty. It is then we transfer values from in_stack to out_stack and
              perform pop operation. If both stacks are empty pop operation would be invalid since the queue is empty.
              During peek operation check whether out_stack is empty, if it is then pop all values from in_stack and push 
              it to out_stack.

    Time complexity:
    push(): O(1)
    pop(): avg O(1)
    peek(): avg O(1)
    empty(): O(1)
    
    Space complexity: O(n), where n is the length of the stack.

    Working on LeetCode? Yes!
    LeetCode Link: https://leetcode.com/problems/implement-queue-using-stacks/ 
"""
from typing import List

class QueueUsingStack:
    def __init__(self):
        self.in_stack: List[int] = []
        self.out_stack: List[int] = []
    
    def push(self, value: int) -> None:
        self.in_stack.append(value)

    def pop(self) -> int:
        print(f'in pop empty check {self.empty()}')
        if self.empty(): return
        self.peek()
        print('inpop')
        return self.out_stack.pop()

    def peek(self) -> int:
        if self.empty(): return
        if len(self.out_stack) == 0:
            while len(self.in_stack):
                self.out_stack.append(self.in_stack.pop())

        return self.out_stack[-1]

    def empty(self) -> bool:
        return not (len(self.in_stack) or len(self.out_stack))

if __name__ == "__main__":
    q = QueueUsingStack()
    q.push(1)
    q.push(1)
    print(f"Is queue empty? {q.empty()}.")
    q.push(2)
    print(q.peek())
    print(q.pop())