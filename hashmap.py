# Time Complexity : O(1) for put/get/remove; Worst-case O(n) if many keys collide in one bucket
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :  Deleting the head of a bucket list and avoiding duplicate keys; solved by using a dummy head per bucket


# Your code here along with comments explaining your approach
# - Use separate chaining: an array of buckets; each bucket holds a singly linked list of (key, value) nodes.
# - Each bucket starts with a dummy (sentinel) node to simplify insert/remove logic at the head.

class ListNode:

    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next


class MyHashMap:

    def __init__(self):
        # Choose a bucket count; 1000
        # Each bucket starts with a dummy/sentinel node so we can always look at .next safely.
        self.map = [ListNode() for i in range(1000)]

    def hash(self, key):
        # Simple modulo hash into [0, bucket_count)
        return key % len(self.map)

    def put(self, key: int, value: int) -> None:
        cur = self.map[self.hash(key)]
        # cur is the dummy head; real nodes start at cur.next
        while cur.next:
            if cur.next.key == key:
                cur.next.val = value # Update existing key
                return
            cur = cur.next
            # Key not found: append new node
        cur.next = ListNode(key, value)

    def get(self, key: int) -> int:
        cur = self.map[self.hash(key)].next
        while cur:
            if cur.key == key:
                return cur.val
            cur = cur.next

        return -1

    def remove(self, key: int) -> None:
        cur = self.map[self.hash(key)] # start at dummy
        while cur and cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next # unlink the node

                return
            cur = cur.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)