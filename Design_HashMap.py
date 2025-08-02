class ListNode:
    def __init__(self, key, value, next=None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self):
        self.size = 769  # Prime number to reduce collisions
        self.buckets = [None] * self.size

    def _hash(self, key: int) -> int:
        return key % self.size

    def _find(self, head: ListNode, key: int) -> ListNode:
        """
        Returns the previous node of the node containing the key.
        If not found, returns the last node.
        """
        prev = head
        curr = head.next
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self._hash(key)
        # Initialize the bucket with a dummy head node if not present
        if not self.buckets[index]:
            self.buckets[index] = ListNode(-1, -1)
        prev = self._find(self.buckets[index], key)
        if prev.next is None:
            # Key not found, insert new
            prev.next = ListNode(key, value)
        else:
            # Key found, update value
            prev.next.value = value

    def get(self, key: int) -> int:
        index = self._hash(key)
        if not self.buckets[index]:
            return -1
        prev = self._find(self.buckets[index], key)
        if prev.next is None:
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        index = self._hash(key)
        if not self.buckets[index]:
            return
        prev = self._find(self.buckets[index], key)
        if prev.next:
            prev.next = prev.next.next

def demo():
    hm = MyHashMap()
    print("Putting (1, 10) and (2, 20)")
    hm.put(1, 10)
    hm.put(2, 20)

    print("get(1)?", hm.get(1))  # 10
    print("get(3)?", hm.get(3))  # -1

    print("Updating (2, 30)")
    hm.put(2, 30)
    print("get(2)?", hm.get(2))  # 30

    print("Removing key 2")
    hm.remove(2)
    print("get(2)?", hm.get(2))  # -1

    print("All done!")

if __name__ == "__main__":
    demo()

# Time Complexity:
# - put(): O(1) on average
# - get(): O(1) on average
# - remove(): O(1) on average

# Space Complexity: O(n) for n key-value pairs stored

# Did this code successfully run on Leetcode: Yes (706 - Design HashMap)
# Any problem you faced while coding this: No, learned how to use a dummy head node to simplify linked list handling.
