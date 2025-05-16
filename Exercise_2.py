# Time Complexity : O(1) on average for put, get, remove (O(n/k) worst-case per bucket)
# Space Complexity : O(n + k) where n = number of entries, k = number of buckets
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

class Node:
    def __init__(self, key: int, value: int, nxt=None):
        # store key, value, and pointer to next node
        self.key = key
        self.value = value
        self.next = nxt

class MyHashMap:
    def __init__(self):
        # pick a bucket count and make an array of empty heads
        self._bucket_count = 1000
        self._buckets = [None] * self._bucket_count

    def _hash(self, key: int) -> int:
        # simple modulo to pick bucket index
        return key % self._bucket_count

    def put(self, key: int, value: int) -> None:
        idx = self._hash(key)
        head = self._buckets[idx]
        curr = head
        # look for existing key
        while curr:
            if curr.key == key:
                curr.value = value
                return
            curr = curr.next
        # if not found, insert new node at head
        new_node = Node(key, value, head)
        self._buckets[idx] = new_node

    def get(self, key: int) -> int:
        idx = self._hash(key)
        curr = self._buckets[idx]
        # scan the chain
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        idx = self._hash(key)
        curr = self._buckets[idx]
        prev = None
        # walk the chain looking for key
        while curr:
            if curr.key == key:
                # unlink this node
                if prev:
                    prev.next = curr.next
                else:
                    # removing head
                    self._buckets[idx] = curr.next
                return
            prev = curr
            curr = curr.next


if __name__ == "__main__":
    myMap = MyHashMap()
    myMap.put(1, 1)
    myMap.put(2, 2)
    print(myMap.get(1))    
    print(myMap.get(3))    
    myMap.put(2, 1)
    print(myMap.get(2))    
    myMap.remove(2)
    print(myMap.get(2))    
