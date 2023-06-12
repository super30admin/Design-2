// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
 * Implement queue using Stacks
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * Time Complexity:
 * push() operation : O(n)
 * pop() operation : O(1)
 * peek() operation : O(1)
 * Empty() operation : O(1)
 * Space Complexity:
 * Since we are two stacks to implement queue , space complexity will be O(n)
 * 
 * Approach :
 * Push Operation :
 * I am using two stacks to implement push operation in queue , first I am removing all the items from stack1 and inserting them into stack2. Now Insert the element into stack1. After this remove all the elements from stack2 and insert them into stack1.
 * Pop Operation :
 * Removing the top element of stack1 and returning it.
 * Peek Operation :
 * returning the top element from stack1
 * Empty Operation :
 * check if stack1 is empty or not
 */

/*
 * Design HashMap
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * Time complexity :
 * put() operation : O(1)
 * get() operation : O(1)
 * remove() operation : O(1)
 * Approach :
 * Put Operation :
 * Here , I am creating a array of linked list , firstly I am using hashIdx function which will return the value from 0 to 10000 , which is the index of array. Now I am checking if at any particular the value is not there , first i will creating a dummy node whose value will be -1. Now after this I am using find function which will search whether the key is present or not. if present then update the value and if not present then create a new node with key-value pair.
 * Get Operation :
 * In Get Operation , I am using the hash function which will return the value from 0 to 10000. I am checking if at particular index if there is no node then simply returning -1 which means that there is no key present in the array. Now the second case , I am using find function which will search whether the key is present or not. if key is present then return the value otherwise return -1.
 * Remove Operation : 
 * In Remove Operation,I am checking if at particular index if there is no node then simply returning nothing which means that there is no key present in the array so we cannot remove anything.Now the second case , I am using find function which will search whether the key is present or not. if key is present then it returns prev pointer and using this prev pointer we can remove the current node and if previous.next is null then that means the key is not there , so we will return nothing.
 
 */
