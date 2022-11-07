"""
    Problem Statement: Design a HashMap.

    Approach: Designing a HashMap using array and separate chaining technique (using linked-list). Each array item(bucket) is initially stored
              None values. When a key is passed through the hash function, the index generated is within the range 10^4. 
              Making the array size more and the size of linked-list small since we want to minimize the traversal time to minimal.

    Time complexity:
    hash(): O(1)
    find(): O(n)
    put(): O(n)
    get(): O(n)
    remove(): O(n)
    
    Space complexity: O(n), where n is the length of buckets.

    Accepted on LeetCode? Yes!
    LeetCode Link: https://leetcode.com/problems/design-hashmap/ 
"""
from typing import List, Optional

class Node:
    def __init__(self, key: int, value: int) -> None:
        self.key = key
        self.value = value
        self.next = None

class HashMap:
    bucket_size = 10 ** 4

    def __init__(self):
        """Initialize the buckets"""
        self.buckets: List[Optional[Node]] = [None] * HashMap.bucket_size

    def hash(key) -> int:
        """Hash the key within range"""
        return key % HashMap.bucket_size

    def find(self, key, bucket) -> Node:
        """Find the node prev to key"""
        head: Node = self.buckets[bucket]
        prev: Node = None
        curr: Node = None

        if head:
            prev, curr = head, head.next

            while curr != None and curr.key != key:
                prev ,curr = curr, curr.next

        return prev

    def put(self, key: int, value: int) -> None:
        """Add key-value in the hash map"""
        bucket = HashMap.hash(key)
        if self.buckets[bucket] == None:
            self.buckets[bucket] = Node(-1, -1)
        
        prev = self.find(key, bucket)
        
        if prev.next:
            prev.next.value = value
        else:
            prev.next = Node(key, value)

    def get(self, key: int) -> int:
        """Get value for corresponding key else -1"""
        bucket = HashMap.hash(key)
        if self.buckets[bucket] == None: return -1

        prev = self.find(key, bucket)
        return prev.next.value if prev.next else -1
    
    def remove(self, key: int) -> None:
        """Remove key-value pair"""
        bucket = HashMap.hash(key)

        if self.buckets[bucket]:
            prev = self.find(key, bucket)
            if prev.next:
                prev.next = prev.next.next

if __name__ == "__main__":
    h = HashMap()
    for i in range(10):
        h.put(i, i ** 2)
    print(h.get(4))
    h.remove(4)
    print(h.get(4))