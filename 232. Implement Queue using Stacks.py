# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : To validate if a list is empty or not

# stack1 is considered as push stack, while stack2 is considered as pop stack. 
# Numbers are moved to corresponding stacks as per the operation.

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        if self.empty() or not self.stack2:
            self.stack1.append(x)
        else:
            while self.stack2:
                val = self.stack2.pop()
                self.stack1.append(val)
            self.stack1.append(x)

        
    def pop(self) -> int:
        if not self.stack1:
            return self.stack2.pop()
        else:
            while self.stack1:
                val = self.stack1.pop()
                self.stack2.append(val)
            return self.stack2.pop()
        

    def peek(self) -> int:
        if not self.stack1:
            return self.stack2[-1]
        else:
            while self.stack1:
                val = self.stack1.pop()
                self.stack2.append(val)
            return self.stack2[-1]
        

    def empty(self) -> bool:
        if not self.stack1 and not self.stack2:
            return True
        else:
            return False


def test_my_queue():
    # Create a new queue
    queue = MyQueue()

    # Test the push method
    queue.push(1)
    queue.push(2)
    assert queue.peek() == 1

    # Test the pop method
    assert queue.pop() == 1
    assert queue.peek() == 2

    # Test the empty method
    assert not queue.empty()
    queue.pop()
    assert queue.empty()

    # Test edge cases
    queue.push(3)
    assert queue.peek() == 3
    queue.push(4)
    queue.push(5)
    assert queue.pop() == 3
    assert queue.pop() == 4
    assert queue.pop() == 5
    assert queue.empty()

test_my_queue()

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()