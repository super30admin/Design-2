#Time Complexity - 
#push - O(1)
#pop - O(n)
#peek - O(1)
#empty - O(1)

#Space Complexity - O(n)

#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.queue=[]

    def push(self, x: int) -> None:
        self.queue.append(x)

    def pop(self) -> int:
        if len(self.queue)>0:
            return self.queue.pop(0)

    def peek(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        if self.queue==[]:
            return True
        return False


        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)