'''
Here we can either use 2 queues or 1 queue.

If using 2 queues,during pop we transfer all the elements from q1 to q2
except for the last element. The last element in q1 is the item to be poped
as per the stack's design.

Once we pop the final element from q1, we swap q1 and q2 to make sure q2 stays empty
for the pop operation next time we need to do the transfer. 

This makes pop O(n)

If using 1 queue, during the push we first push the incoming element
then rotate all the elements in the queue except for the last element. This makes sure
the last element is always at the top of queue.

This makes pop to be a O(1) as the item to be popped as per stack is already at the top 
of the queue.

On the other hand now push becomes O(n)
'''
class MyStack:

    def __init__(self):
        self.q1 = deque()

    def push(self, x: int) -> None:
        self.q1.append(x)
        for _ in range(len(self.q1) - 1):
            self.q1.append(self.q1.popleft())

    def pop(self) -> int:
        return self.q1.popleft()

    def top(self) -> int:
        return self.q1[0]

    def empty(self) -> bool:
        return len(self.q1) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()