# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no, not sure whether the logic is right but working well

# // Your code here along with comments explaining your approach


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        
        """
        self.arr=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.arr.append(x)
        print(self.arr)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        a=self.arr[0]
        self.arr.pop(0)
        return a
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.arr[0]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.arr)!=0:
            return False
        else:
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()