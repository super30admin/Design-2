'''Approach:
This Hashap is designed by using an Array and linked list
Initialize the primary index with the bucket size. when we encounter a primary index with None,
then initialize a dummy node in the first index which can be used to cover the edge case (to remove first element
in the linked list)
find method is used to get to the location of where the key is present.
in find method curr and prev pointers are used to keep track of the pointer
In case we need to add/remove element at curr pointer, we can do that with the help of prev pointer's next
'''

#Time Complexity : O(n) - put, get, remove, find
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class MyHashMap:
    def __init__(self):
        '''
        Keeping the bucket size as 10**4 to keep the number of nodes in linked list as constant
        '''
        self.bucket = 10000
        self.storage = [None] * 10000

    ''' Used for linked list initialization '''
    class Node:
        def __init__(self, key: int, value: int):
            self.key = key
            self.value = value
            self.next = None

    def getBucket(self, key: int) -> int:
        bucket = key % self.bucket
        return bucket

    def find(self, key: int, head: Node) -> Node:
        '''
        prev is pointed to the calculated bucket location(head) and curr to its next value
        '''
        prev = head
        curr = head.next
        '''
        Traverse through the linked list till the last element is reached
        or the key is found. once the key is found to update/remove, return the prev pointer
        '''
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        ''' 
        whenever we reached a empty storage[bucket] we need to initialize a dummy node
        This covers the edge case, whenever a deletion of first element is encountered
        '''
        if self.storage[bucket] == None:
            self.storage[bucket] = self.Node(-1, -1)

        prev = self.find(key, self.storage[bucket])
        ''' 
        if the next to prev pointer is empty initialize a node there
        else update the value with the recent value
        '''
        if prev.next == None:
            prev.next = self.Node(key, value)

        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return -1

        prev = self.find(key, self.storage[bucket])
        '''
        if we reach the last node and has not found the key, return -1
        else return the prev node's next value
        '''
        if prev.next == None:
            return -1

        return prev.next.value

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return
        prev = self.find(key, self.storage[bucket])
        '''
        if we reached the last node and has not found the key, return
        else we nedd to update the prev's next to prev.next to next 
        which means the prev.next link is broken/ element is deleted from linked list
        '''
        if prev.next == None:
            return
        prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)