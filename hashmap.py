# Time Complexity : Best case O(1), Worst case O(n), Space Complexity : O(n)
class ListNode:
    def __init__(self, key=-1, value=-1, next=None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self):
        # Initialize an array of size 1000 with a dummy node at each index.
        self.map = [ListNode() for i in range(1000)]
        
    def hash(self, key):
        # Compute hash value of the key by modding it with length of the map.
        return key % len(self.map)

    def put(self, key: int, value: int) -> None:
        # If inserting key for the first time, create a new ListNode. If the key exists, update value of key.
        current = self.map[self.hash(key)]      # Start of the LinkedList (i.e. Dummy Node)
        while current.next:                     # Loop from Dummy Node onwards
            if current.next.key == key:
                current.next.value = value
                return
            current = current.next
        current.next = ListNode(key, value)     # Post loop termination at end when current.next is null, we add the new Node since it wasn't present before.
        

    def get(self, key: int) -> int:
        current = self.map[self.hash(key)].next  # Head will be from the node next to dummy node
        while current:
            if current.key == key:
                return current.value
            current = current.next
        return -1                                # If we didn't find the value.
        

    def remove(self, key: int) -> None:
        current = self.map[self.hash(key)]
        while current and current.next:
            if current.next.key == key:           # If next Node's key is matching, then remove that node.
                current.next = current.next.next
                return
            current = current.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)