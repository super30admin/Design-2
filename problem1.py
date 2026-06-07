# https://leetcode.com/problems/implement-queue-using-stacks/
# Time Complexity amortized O(1)
# Space Complexity O(n)


class MyQueue:

    def __init__(self):
        self.inst = []
        self.outst = []

    # arrays work first in last out
    # x=[1,2,3]
    # x.append(4)
    # x.append(5)
    # x.pop()
    # x=[1,2,3,4]

    def push(self, x: int) -> None:
        self.inst.append(x)

    def pop(self) -> int:
        if self.empty():
            return -1
        # if outst is empty append data from inst to outst
        self.peek()
        return self.outst.pop()

    def peek(self) -> int:
        if not self.outst:
            while self.inst:
                self.outst.append(self.inst.pop())
        return self.outst[-1]

    def empty(self) -> bool:
        return not self.inst and not self.outst


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
