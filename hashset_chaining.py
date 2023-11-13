class ListNode(object):
    def __init__(self,key,next):
        self.key = key
        self.next = next

class MyHashSet(object):

    def __init__(self):
        self.size = 10000
        self.buckets = [None]*self.size

    def add(self, key):

        outerhash = key % self.size
        cur = self.buckets[outerhash]
        if not cur: 
            self.buckets[outerhash] = ListNode(key, None)
            return
        if cur.key == key:
            return 
        while cur:
            if cur.key == key: 
                return
            if not cur.next: 
                cur.next = ListNode(key,None)
                return 
            if cur.next: 
                cur = cur.next
        return 

    def remove(self, key):

        outerhash = key % self.size
        cur = self.buckets[outerhash]
        if not cur:
            return 
        if cur.key == key:
            self.buckets[outerhash] = cur.next
        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return 
            cur = cur.next
        return
        

    def contains(self, key):

        outerhash = key % self.size
        cur = self.buckets[outerhash]
        while cur:
            if cur.key == key:
                return True
            cur = cur.next
        return False
