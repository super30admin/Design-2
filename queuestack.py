#Implement queue using stacks
#Executed on leet code
#Time complexity - push-O(1), Pop - O(1), Peek- O(n)
#space complexity - O(n)
# using 2 stacks -stpush,stpop 
class MyQueue:

    def __init__(self):
        self.stPush = []
        self.stPop = []
        

    def push(self, x: int) -> None:
         self.stPush.append(x)
        
        

    def pop(self) -> int:
        self.peek()
        return self.stPop.pop()
        

    def peek(self) -> int:
        if len(self.stPop) == 0:
            while self.stPush:
                self.stPop.append(self.stPush.pop())
        return self.stPop[-1]

        

    def empty(self) -> bool:
        return len(self.stPop) + len(self.stPush) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

