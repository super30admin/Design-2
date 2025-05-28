# Time Complexity : O(1) as maximum would always be 100
# Space Complexity : O(n) n => number of key value pairs inserted
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I didn't get why and how the helper function was used


# Your code here along with comments explaining your approach


class MyHashMap:
    # Node will contain the things of the hashmap so it has key values and the next pointer
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            # next is initially assigned to None
            self.next = None

    def __init__(self):
        self.primary_list = [None] * 10000

    def hash(self,key):
        return key % 10000

    # This function searches the linked list (starting from head) for the node before the node with the given key.
    def helper(self,head,key):
        prev = head
        curr = head.next

        # to loop until current is there(i.e. elements are there in the linked list) and we have not found the key
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
    
        return prev

    def put(self, key: int, value: int) -> None:
        idx = self.hash(key)
        if self.primary_list[idx] == None:
        # start with a dummy node for the edge case of removing the head node as we will not have previous pointer if dummy node is not there
            self.primary_list[idx]= self.Node(-1,-1) # Node(-1,-1) because we need to provide a key and a value
        previous_hash = self.helper(self.primary_list[idx],key)
        # if current is at None that is at the tail then new node or else update the value
        if previous_hash.next is None:
            previous_hash.next = self.Node(key, value)
        else:
            previous_hash.next.value = value

        

    def get(self, key: int) -> int:
        idx = self.hash(key)
        if self.primary_list[idx] == None:
            return -1
        # if linked list is there search for prev
        previous_hash = self.helper(self.primary_list[idx],key)
        # when current is not there
        if previous_hash.next is None:
            return -1
        # if previous is there return 
        else:
            return previous_hash.next.value
        

    def remove(self, key: int) -> None:
        idx = self.hash(key)
        if self.primary_list[idx] == None:
            return
        # If linked list is there search for previous
        previous_hash = self.helper(self.primary_list[idx],key)
        # If current is not there
        if previous_hash.next is None:
            return
        else:
            temp = previous_hash.next
            previous_hash.next = previous_hash.next.next
            temp.next = None