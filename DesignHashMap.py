# Time Complexity :
    #findFunc runs in O(L), L is the length of the LinkedList
    #put O(L), get O(L) and remove also runs in O(L) 
# Space Complexity : Number of key,value pairs that needs to be put into the HashMap so O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
    #None

# Your code here along with comments explaining your approach


class MyHashMap:

    class Node:
        def __init__(self, k, v):
            self.key = k
            self.val = v
            self.next = None

    #find function
    #loop through the linkedlist with the help of two pointers prev and curr
    #once curr reaches null or we found the curr.val matches our expected key, we stop the traversal
    #and return the prev
    def findFunc(self, dummy, key):
        prev = dummy
        curr = dummy.next
        while curr and curr.key != key :
            prev = curr
            curr = curr.next
        return prev

    #get Bucket for the index of primary array
    def getBucket(self, key):
        return key % self.buckets

    #initiailize buckets and storage
    def __init__(self):
        self.buckets = 1000 #10^3
        self.storage = [None] * self.buckets
        
    #first gets the index of bucket based on the hashing logic
    #checks if a LinkedList is present at that index
    #if a Node/LinkedList is not present then creating a dummyNode and putting it into that bucket
    #loop through the linkedList and get the prev node
    #in case of prev.next does not exist then append the new node to the next of prev
    #if it does exist then update its value
    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] is None:
            dummyNode = MyHashMap.Node(-1, -1)
            self.storage[bucket] = dummyNode
        prev = self.findFunc(self.storage[bucket], key)
        if prev.next is None:
            prev.next = MyHashMap.Node(key, value)
        else:
            prev.next.val = value 

    
    #similar process is followed here
    #if we found the matching key then we return th value
    #else we return -1
    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.storage[bucket] is None:
            return -1
        prev = self.findFunc(self.storage[bucket], key)
        if prev.next:
            return prev.next.val
        return -1

    #check if Node exists at a given bucket index, if not simply return and exit out, we did not find the key.
    #else traverse through the LinkedList, until we either find the element or we reach the end of the LinkedList
    #If we did find the the element then set prev's next node to prev's next next
    #and if we did not find the element/key then exit out 
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] is None:
            return
        prev = self.findFunc(self.storage[bucket], key)
        if prev.next:
            prev.next = prev.next.next
        return



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)