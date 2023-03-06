class MyQueue:

    def __init__(self):
        self.input = []
        self.out = []

    def push(self, x: int) -> None:
        self.input.append(x)

    def pop(self) -> int:
        if(len(self.out)==0):
            while(len(self.input) !=0):
                self.out.append(self.input.pop())
                print(self.out)
        return self.out.pop()
        

    def peek(self) -> int:
        if(len(self.out)==0):
            while(len(self.input) !=0):
                self.out.append(self.input.pop())
        return self.out[-1]
        

    def empty(self) -> bool:
         if(len(self.input) == 0 and len(self.out) == 0):
             return True
         else:
             return False

        

myQueue = MyQueue()
myQueue.push(1); # queue is: [1]
myQueue.push(2); # queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); # return 1
myQueue.pop(); # return 1, queue is [2]
myQueue.empty(); # return false