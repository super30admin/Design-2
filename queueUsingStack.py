# Work in Progress
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queue = list()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.queue.append(x)
        print("Inserting into the list")

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        elem = self.queue[-1]
        del self.queue[-1]
        return elem

    def peek(self) -> int:
        """
        Get the front element.
        """
        que = list()
        if (len(self.queue)!=0):
            for i in range(len(self.queue)):
                que.append(self.queue[i])
        que[::-1]
        return que[-1]


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if (len(self.queue)==0):
            return True
        else:
            return False
        
# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(2)
obj.push(3)
obj.push(1)
obj.push(4)
param_2 = obj.pop()
print("Element popped: ",param_2)
param_3 = obj.peek()
print("Peeking: ",param_3)
param_4 = obj.empty()
print("Is stack eempty: ",param_4)
