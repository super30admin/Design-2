#Time Complexity :O(1) for all the given operations
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Passed all the test cases and submitted successfully
#Any problem you faced while coding this :I just had problem with correcting correct way to find size of the array

class MyQueue:
    def __init__(self):
        #Creates a array and a length variable to keep track of the length of the array
        self.array = []
        self.length = 0

    def push(self, x: int) -> None:
        #Append() is used to push the element to the last of the array and the counter size is incremented when element is added
        self.array.append(x)
        self.length += 1
        print(self.array)

    def pop(self) -> int:
        #Array slicing is used to delete the first element and the element deleted is stored in a variable and then retured 
        element_deleted = self.array[0]
        self.array = self.array[1:len(self.array)]
        self.length -= 1
        return element_deleted

    def peek(self) -> int:
        #this function just returns the first value of the queue
        return self.array[0]

    def empty(self) -> bool:
        #Length of the array is used to keep track of this and then used to find if its empty
        if self.length == 0:
            return True
        else:
            return False


