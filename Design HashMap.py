#Time Complexity:O(n)
#Space Compleixty:O(n)
class ListNode(object):
    def __init__(self,key=0,data=0,next=None):
        self.data=data
        self.key=key
        self.next=next

class MyHashMap(object):
    def __init__(self):
        self.primaryArr=[None for i in range(10000)]

    def find(self,head,key):
        prev=head
        curr=head.next
        while(curr!=None and curr.key!=key):
            prev=curr
            curr=curr.next
        return prev

    def getBucket(self,key):
        return key%10000

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        bucket=key%10000
        if self.primaryArr[bucket]==None:
            dummy=ListNode(-1,-1)
            self.primaryArr[bucket]=dummy
        prev=self.find(self.primaryArr[bucket],key)
        if prev.next==None:
            prev.next=ListNode(key,value)
        else:
            prev.next.data=value
        
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        bucket=self.getBucket(key)
        if self.primaryArr[bucket]==None:
            return -1
        prev=self.find(self.primaryArr[bucket],key)
        if prev.next:
            return prev.next.data
        return -1



    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket=self.getBucket(key)
        if self.primaryArr[bucket]==None:
            return
        prev=self.find(self.primaryArr[bucket],key)
        if prev.next==None:
            return 
        prev.next=prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)