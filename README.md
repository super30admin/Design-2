# Day2

#Problem 1:
Design a Skip List.A skip list is a data structure for storing a sorted list of items using a hierarchy of linked lists that connect increasingly sparse subsequences of the items. These auxiliary lists allow item lookup with efficiency comparable to balanced binary search trees (that is, with number of probes proportional to log n instead of n). 

#Problem 2:
Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:
set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item.
get(key): gets the value at key. If no such key exists, return null.
Each operation should run in O(1) time.

#Problem 3:
Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

