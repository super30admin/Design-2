"""
Rasika Sasturkar
Time Complexity: O(1) averagely
Space Complexity: O(n), worst case can be O(n^2)
I was able to understand the working of this code in Java, but implementing
in Python was a bit challenging. I had to first understand how Nodes and pointers
will work to write down an efficient code.
"""


class Node:
    def __init__(self, key, value):
        """
        Initializing the Node key and value, next is always None
        """
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        """
        Creates a primary array of 10000 nodes with (key, value) = (-1,-1)
        """
        self.storage = [Node(-1, -1) for _ in range(10000)]

    def hash_funct(self, key):
        """
        Hash function
        """
        return key % 10000

    def find(self, start, end):
        """
        Helper function to iterate over the chained linked list and get the prev pointer
        """
        prev = None
        curr = start
        while curr is not None and curr.key != end:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        """
        Put involves 2 conditions - If the key is not present then we add a new node
        or if key is already present in out hashmap, then we just update the value of that entry
        """
        hash = self.hash_funct(key)
        prev = self.find(self.storage[hash], key)
        if prev.next is None:
            prev.next = Node(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        """
        If the key does not exist, we return -1, or we return the value
        """
        hash = self.hash_funct(key)
        prev = self.find(self.storage[hash], key)
        if prev.next is None:
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        """
        To delete the node (if exists), we cut out the link between prev pointer
        and the node to be deleted by linking the prev.next to prev.next.next
        """
        hash = self.hash_funct(key)
        prev = self.find(self.storage[hash], key)
        if prev.next is not None:
            prev.next = prev.next.next


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    myHashMap = MyHashMap()
    myHashMap.put(1, 1)  # The map is now[[1, 1]]
    myHashMap.put(2, 2)  # The map is now[[1, 1], [2, 2]]
    print(myHashMap.get(1))  # return 1, The map is now[[1, 1], [2, 2]]
    print(myHashMap.get(3))  # return -1(i.e., not found), The map is now[[1, 1], [2, 2]]
    myHashMap.put(2, 1)  # The map is now[[1, 1], [2, 1]](i.e., update the existing value)
    print(myHashMap.get(2))  # return 1, The map is now[[1, 1], [2, 1]]
    myHashMap.remove(2)  # remove the mapping for 2, The map is now[[1, 1]]
    print(myHashMap.get(2))  # return -1(i.e., not found), The map is now[[1, 1]]


if __name__ == "__main__":
    main()
