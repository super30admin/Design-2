# Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
# Time Complexity : 
# for push  - O(1)
# for pop - ammortized O(1)
# for peek - ammortized O(1)
# for isEmpty - O(1)
# Space Complexity : 0(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

class MyQueue(object):

    def __init__(self):
        self.in_ = deque()
        self.out = deque()

    ## maintain two stacks in and out.
    ## for pushing without any condition push into in_
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.in_.append(x)

    ## for poping check if out is not empty pop from out
    ## if out is empty take all the elements from in and move to out 
    ## then pop from out
    def pop(self):
        """
        :rtype: int
        """
        if self.out:
            return self.out.pop()
        else:
            while self.in_:
                self.out.append(self.in_.pop())
            return self.out.pop()

    ## if out not empty look at the first element
    ## if out empty move all the elements from out to in,and then look for first element
    def peek(self):
        """
        :rtype: int
        """
        if self.out:
            return self.out[-1]
        else:
            while self.in_:
                self.out.append(self.in_.pop())
            return self.out[-1]
    ## just check the len of in and out and return true or false    
    def empty(self):
        """
        :rtype: bool
        """
        if self.in_ or self.out:
            return False
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


#####################################

# Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)
# Time Complexity :
# for find : O(1) -> because we will only take 100 steps in worst case
# for put : O(1) -> because we will only take 100 steps in worst case
# for get : O(1) -> because we will only take 100 steps in worst case
# for remove : O(1) -> because we will only take 100 steps in worst case
# Space Complexity : O(10000 + 100) -> O(n) -> since we are using memory to store all the elements? 
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : no

class ListNode:
    def __init__(self, key,value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap(object):

    
    def __init__(self):
        self.bucket = 10000
        self.primary = [None]* self.bucket
    ## using the hash function to get the primary bucket where LL nodes are stored
    def hash1(self,key):
        return key%self.bucket

    ## this will look for the primary bucket, if do not exist create a new LLNode
    ## if it does exist, since the first node is dummy, that can be out prev
    ## using prev and cur iterate until we find the key or end of LL
    ## return prev
    def find(self,key):
        h1 = self.hash1(key)
        if self.primary[h1] is None:
            return ListNode(-1,-1)

        prev = self.primary[h1]
        cur = prev.next
        while cur:
            if cur.key == key:
                return prev
            prev = cur
            cur = cur.next
        return prev
        
    ## Look if the key already exist by using the hash function, if not create a new LL and push
    ## if we find the LL, then traverse until we find the key or to the end
    ## replace if key found, else add new
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        h = self.hash1(key)
        if self.primary[h] is None:
            dummy = ListNode(-1,-1)
            newNode = ListNode(key,value)
            dummy.next = newNode
            self.primary[h] = dummy
        else:
            prev = self.find(key)
            if prev.next and prev.next.key== key:
                prev.next.value = value
            else:
                prev.next = ListNode(key,value)
        
    ## this will look if LL exist in primary bucket if not merry xmas
    ## if we find the node get the value
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        prev = self.find(key)
        if prev.next and prev.next.key == key:
            return prev.next.value
        return -1


    ## find the key , if exist get the prev node and point it to next.next
    ## this do not return anything
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        prev = self.find(key)
        if prev.next and prev.next.key == key:
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)