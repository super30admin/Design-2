// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : i did had some problem while i was doing it in python as by mistake i returned two times in peek and pop which gave me two different outputs.


// Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        self.In = []
        self.Out = []

    def push(self, x: int) -> None:
        self.In.append(x)
        



    def pop(self) -> int:
        if not self.Out :
            self.Out.append(self.In.pop())
        return self.Out[-1]


        

    def peek(self) -> int:
        if not self.Out:
               while self.In:
                 self.Out.append(self.In.pop())
        return self.Out[-1]
        

    def empty(self) -> bool:
        return not self.Out and not self.In
