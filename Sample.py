// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


// We maintain 2 stacks, when pushing the element, we push in the instack and while popping the element because we need to use FIFO, we will copy all the elements to 
// the out stack from in stack (only if the outstack is empty), then pop always from outstack.
// For peek, same thing, we copy all the elements to outstack by popping from instack, and then view the top element in outstack.outstack
// For empty, we simply check if either of 2 stacks have any elements in them.outstack

class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []
        
    def push(self, x: int) -> None:
        self.instack.append(x)    

    def pop(self) -> int:
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack.pop()

    def peek(self) -> int:
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self) -> bool:
        return not self.instack and not self.outstack




// Hashmap implementation without built in dict. We use linear chaining to handle collisions, add a dummy node of -1 at the start of the chain. 
// For put, we get the hash function to get base index, if empty slot insert key,value pair, if not then iterate over the chain to find if key exist or create new
// Similar for remove and get, find baseidx, iterate over bucketitems, get/remove key
class MyHashMap:

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = [None] * self.buckets
    
    def _hash(self, key):
        return key % self.buckets

    def put(self, key: int, value: int) -> None:
        baseidx = self._hash(key)
        if self.bucketItems[baseidx] is None:
            self.bucketItems[baseidx] = self.Node(-1, -1)
            self.bucketItems[baseidx].next = self.Node(key, value)
            return

        prev = None
        curr = self.bucketItems[baseidx]
        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        baseidx = self._hash(key)
        if not self.bucketItems[baseidx]:
            return -1
        
        prev = None
        curr = self.bucketItems[baseidx]
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        
        if prev.next is None:
            return -1
        return prev.next.value
        
    def remove(self, key: int) -> None:
        baseidx = self._hash(key)
        if not self.bucketItems[baseidx]:
            return -1
        
        prev = None
        curr = self.bucketItems[baseidx]
        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        if prev.next is None:
            return
        prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)