# Approach:
# This implementation uses Linear Chaining with Linked Lists.
# A fixed-size array of 10,000 buckets is used. Each bucket stores a dummy head node of a linked list,
# where each node holds a (key, value) pair and resolves collisions via chaining.

# Time Complexity:
# put(key, value)    : O(N) 
# get(key)           : O(N) 
# remove(key)        : O(N) 
# find_index(key)    : O(1)
# find_node(head, k) : O(N) in worst-case chain

# Overall Space Complexity: O(K + N), where K = 10,000 (bucket size), N = number of stored elements


class MyHashMap(object):

    class Node(object):
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.Hashlist = [None] * 10000

    def put(self, key, value):
        i = self.find_index(key)
        if self.Hashlist[i] is None:
            self.Hashlist[i] = self.Node(-1, -1)
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next is None:
            prev_node.next = self.Node(key, value)
        else:
            prev_node.next.val = value

    def get(self, key):
        i = self.find_index(key)
        if self.Hashlist[i] is None:
            return -1
        prev_node = self.find_node(self.Hashlist[i], key)
        return -1 if prev_node.next is None else prev_node.next.val

    def remove(self, key):
        i = self.find_index(key)
        if self.Hashlist[i] is None:
            return
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next is None:
            return
        prev_node.next = prev_node.next.next

    def find_index(self, key):
        return hash(key) % len(self.Hashlist)

    def find_node(self, head, key):
        cur = head
        prev = None
        while cur is not None and cur.key != key:
            prev = cur
            cur = cur.next
        return prev
