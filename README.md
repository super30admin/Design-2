# Design-2

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/).

Approach:
1. Initialize two stacks (to and from), one for LIFO and one to keep the front variable of the queue. Initialize the variable front to keep the track of first element.
2. if the from stack is empty, add element in the stack and assign first value to front. 
3. To remove the element from the front of the queue, we have to take another stack named to and all the elements from the from stack to it. According to stack property, it would be added in reverse order.
4. Everytime removing the first element, remove one element from 'to' stack.
5. If we want to check the top element, just return to.peek() if to is not empty, otherwise return front.


## Problem 2:(https://leetcode.com/problems/design-hashset/)
Approach
1. Initialize the int array with the limit given.
2. Consider index of array as key and provided value as value.
3. Since hashset does not take duplicate elements, its fine even if elements are repeated because those would be overwriteen in array.
4. To remove any element, initialize that index with -1.
5. for contains, check whether the provided key index is -1 or not, if -1 return false else return true.




