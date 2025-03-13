# Approach: We use an array of size `bucket_size` with separate chaining (linked list) to handle collisions.
# Time Complexity: put(), get(), and remove() have O(1) average time, but worst case O(n/bucket_size) due to collisions.
# Space Complexity: O(n) for storing key-value pairs in linked lists.

class ListNode:
    def __init__(self, key, value, next_node = None):
        self.key = key
        self.value = value
        self.next = next_node
        
class MyHashMap:

    def __init__(self):
        self.bucket_size = 999
        self.bucket = [None] * self.bucket_size

    def _hash(self, key):
        return key % self.bucket_size

    def put(self, key: int, value: int) -> None:
        index = self._hash(key)

        if not self.bucket[index]:
            new_node = ListNode(key, value)
            self.bucket[index] = new_node
        else:
            curr = self.bucket[index]

            while curr:
                if curr.key == key:
                    curr.value = value
                    return
                if not curr.next:
                    curr.next = ListNode(key, value)
                    return
                curr = curr.next

    def get(self, key: int) -> int:
        index = self._hash(key)
        curr = self.bucket[index]
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next

        return -1

    def remove(self, key: int) -> None:
        index = self._hash(key)
        curr = self.bucket[index]
        prev = None

        while curr:
            if curr.key == key:
                if prev:
                    prev.next = curr.next
                else:
                    self.bucket[index] = curr.next  # Remove head node
                return

            prev, curr = curr, curr.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)