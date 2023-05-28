# Time Complexity : ammortized pop - O(1), push O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes

class MyQueue:

    def __init__(self):
        self.add = []
        self.exit = []
        

    def push(self, x: int) -> None:
        self.add.append(x)
        

    def pop(self) -> int:
        if len(self.exit) == 0:
            while len(self.add) != 0:
                self.exit.append(self.add.pop())
        return self.exit.pop()
        

    def peek(self) -> int:
        if len(self.exit) == 0:
            while len(self.add) != 0:
                self.exit.append(self.add.pop())
        return self.exit[-1]

    def empty(self) -> bool:
        if len(self.add) == 0 and len(self.exit) == 0:
            return True
        return False