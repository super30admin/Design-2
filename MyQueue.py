# Time Complexity : O(1)
# Space Complexity :
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MyQueue:

    def __init__(self):
        self.arr = []
        

    def push(self, x: int) -> None:
        self.arr.append(x)
        

    def pop(self) -> int:
        if len(self.arr) > 0:
            return self.arr.pop(0)

        

    def peek(self) -> int:
        return self.arr[0]
        

    def empty(self) -> bool:
        if self.arr == []:
            return True
        else:
            return False