'''

## Problem 3: Implement Queue using Stacks (https://leetcode.com/problems/implement-queue-using-stacks/)

## Author: Neha Doiphode
## Date  : 06-22-2022

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

    void push(int x) Pushes element x to the back of the queue.
    int pop() Removes the element from the front of the queue and returns it.
    int peek() Returns the element at the front of the queue.
    boolean empty() Returns true if the queue is empty, false otherwise.

Notes:

    You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.



Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

Constraints:

    1 <= x <= 9
    At most 100 calls will be made to push, pop, peek, and empty.
    All the calls to pop and peek are valid.



Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity?
           In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

Time complexity: Please refer to the doc-strings below for each operation.

Space complexity: O(n), as we need auxiliary stack to store elements of the queue.

'''


class MyQueue:

    def __init__(self):
        self._in_stack = []
        self._out_stack = []

    def push(self, x: int) -> None:
        '''
        Time complexity: O(1), appending at the end of the list is constant time.
        '''
        self._in_stack.append(x)

    def _transfer_contents_from_in_to_out(self) -> None:
        if not self._out_stack:
            while self._in_stack:
                self._out_stack.append(self._in_stack.pop())

    def pop(self) -> int:
        '''
        Time complexity: Amortized O(1), Worst case O(n)
                         If out stack is empty,
                            we need to transer n elements from in stack to out stack.
                            Popping out of 1 stack and pushing elements to other stack is O(2n) ~= O(n) worst case.

                         Else if out stack is not empty,
                            we can simply pop element from the out stack.

                        Amortized analysis gives average performance over time of each operation in the worst case.
                        The worst case operation can alter the state in such way that the worst case cannot occur again for a long time.
                        Hence, amortizing its cost.
        '''
        self._transfer_contents_from_in_to_out()
        return self._out_stack.pop()

    def peek(self) -> int:
        '''
        Time complexity: Same as pop operation
        '''
        self._transfer_contents_from_in_to_out()
        return self._out_stack[-1]

    def empty(self) -> bool:
        '''
        Time complexity: O(1)
        '''
        return (not self._in_stack and not self._out_stack)


    def get_queue_contents(self) -> None:
        return self._in_stack

    def get_out_stack(self) -> None:
        return self._out_stack


# Driver code
queue = MyQueue()
queue.push(1)
queue.push(2)
print(f'Current queue contents: {queue.get_queue_contents()}')
print(f'Peek of the queue: {queue.peek()}')
queue.pop()
print(f'Current queue contents after pop operation: {queue.get_out_stack()}')
print(f'Is queue empty? : {queue.empty()}')
