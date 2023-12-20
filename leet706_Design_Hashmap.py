# // Time Complexity : O(1) in amortized time, might go upto O(n/10000) in normal
# // Space Complexity : O(n) since creating nodes for each element and 10000 length list
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Managing the put/remove and get to make sure all the nodes are properly handled
# when there is more elements with same key/collisions took more trial and error


# // Your code here along with comments explaining your approach
# Approach is to use a 10000 length list and for each spot use linkedlist to avoid collisions. Need to handle all the functions properly

# Solution
class ListNode:
    def __init__(self,key,value,next):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self,length=10000):
        self.length = length
        self.nodeList = [None for _ in range(self.length)]

    def hashKey(self,key):
        return hash(key)%self.length

    def put(self, key: int, value: int) -> None:
        keyForHash = self.hashKey(key)

        nodesHead = self.nodeList[keyForHash]
        if nodesHead == None:
            newNode = ListNode(key,value,self.nodeList[keyForHash])
            self.nodeList[keyForHash] = newNode
        else:
            while nodesHead:
                if nodesHead.key == key:
                    nodesHead.value = value
                    return
                nodesHead = nodesHead.next
            newNode = ListNode(key,value,self.nodeList[keyForHash])
            self.nodeList[keyForHash] = newNode

    def get(self, key: int) -> int:
        keyForHash = self.hashKey(key)
        nodesHead = self.nodeList[keyForHash]
        while nodesHead:
            if nodesHead.key == key:
                return nodesHead.value
            nodesHead = nodesHead.next
        return -1

    def remove(self, key: int) -> None:
        keyForHash = self.hashKey(key)
        nodesHead = self.nodeList[keyForHash]
        if nodesHead:
            if nodesHead.key == key:
                nodesHead = nodesHead.next
                self.nodeList[keyForHash] = nodesHead
                return None
            while nodesHead.next:
                if nodesHead.next.key == key:
                    nodesHead.next = nodesHead.next.next
                    return None
                nodesHead = nodesHead.next