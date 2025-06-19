'''
    Implement queue using stacks

    https://leetcode.com/problems/implement-queue-using-stacks/description/

    Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty). First try to implement each operation in at most O(N)
    time complexity. Then try to implement the queue such that each operation is amortized O(1) time complexity. In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

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

    Solution:
        Let the two stacks be S1, S2
        Method: Push O(1), Pop Amortized O(1)
                Push(x)
                    push(x) to S1  O(1)
                Pop()
                    if S2 not empty:
                        pop value = peek S2  O(1)
                    else:
                        S1 -> S2            O(N)
                        pop value = peek S2  O(1)
                    The catch is that S2 being empty
                    doesn't happen too often. Hence,
                    we mostly operate in O(1)
                    and only a few times we operate in O(N)
                Peek()
                    if S2 not empty:
                        peek  = S2[-1]  O(1)
                    else:
                        S1 -> S2      O(N)
                        peek = S2[-1]  O(1)
                    The catch here is the same as in pop()
    Reference:
        https://youtu.be/Sg-alcOkPY4?t=324
'''

class MyQueue:
    def __init__(self):
        self.input = []
        self.output = []

    def push(self, x: int) -> None:
        ''' Time: O(1)
            Space: O(1)
        '''
        self.input.append(x)

    def pop(self) -> int:
        ''' Time: O(1) (amortized), O(N) (worst)
            Space: O(1)
        '''
        if not self.output:
            while self.input:
                self.output.append(self.input.pop())
        return self.output.pop()

    def peek(self) -> int:
        ''' Time: O(1) (amortized), O(N) (worst)
            Space: O(1)
        '''
        if not self.output:
            while self.input:
                self.output.append(self.input.pop())
        return self.output[-1]

    def empty(self) -> bool:
        ''' Time: O(1)
            Space: O(1)
        '''
        return not self.input and not self.output

def run_queue_using_stack():
    q = MyQueue()
    q.push(1)
    q.push(2)
    x = q.peek() # 1
    print(f"peek(): {x}")
    x = q.pop() # 1
    print(f"pop(): {x}")
    x = q.empty() # False
    print(f"empty(): {x}")

run_queue_using_stack()