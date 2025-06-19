// // Time Complexity : 
// //push(x): O(1)
// // pop(): avg time O(1), worst O(n) if 'out' stack is empty
// // peek(): avg time O(1), worst O(n) if 'out' stack is empty
// // empty(): O(1)
// // Space Complexity : O(n)
// // Did this code successfully run on Leetcode : yes
// // Any problem you faced while coding this :


// // Your code here along with comments explaining your approach
// // Time Complexity :
// // push(x): O(1)
// // pop(): Amortized O(1), worst O(n) if 'out' stack is empty
// // peek(): Amortized O(1), worst O(n) if 'out' stack is empty
// // empty(): O(1)

// // Space Complexity :
// // O(n) where n is the number of elements in the queue (total in 'in' and 'out' stacks)

// // Did this code successfully run on Leetcode :
// // Yes

// // Any problem you faced while coding this :
// // Understanding why pop() calls peek() instead of repeating the logic can be confusing at first,
// // but it improves code reuse and clarity.


// // Your code here along with comments explaining your approach:

// class MyQueue {
//     Stack<Integer> in;   // Stack for inserting operations
//     Stack<Integer> out;  // Stack for dequeue operations (reversed order)

//     public MyQueue() {
//         in = new Stack<>();
//         out = new Stack<>();
//     }

//     // Add element to the back of queue
//     public void push(int x) {
//         in.push(x);  // Always push to 'in'
//     }

//     // Remove the element from front of queue and return it
//     public int pop() {
//         peek();           // Ensure 'out' is up-to-date
//         return out.pop(); // Pop from 'out'
//     }

//     // Get the front element
//     public int peek() {
//         if (out.isEmpty()) {
//             // Transfer all elements from 'in' to 'out' in reverse order
//             while (!in.isEmpty()) {
//                 out.push(in.pop());
//             }
//         }
//         return out.peek();  // Top of 'out' is front of the queue
//     }

//     // Returns true if queue is empty
//     public boolean empty() {
//         return in.isEmpty() && out.isEmpty();
//     }
// }



//PROBLEM -2

// Time Complexity :
// put(): O(N) in worst case (N = length of linked list in a bucket), O(1) average
// get(): O(N) worst case, O(1) average
// remove(): O(N) worst case, O(1) average

// Space Complexity :
// O(K), where K is the number of unique keys inserted (each stored as a node)

// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// Understanding how to manage collisions using chaining with dummy nodes and tracking the previous node.


// Your code here along with comments explaining your approach

// class MyHashMap {
    
//     // Define a Node class for each key-value pair
//     class Node {
//         int key, value;
//         Node next;
        
//         public Node(int k, int v) {
//             key = k;
//             value = v;
//         }
//     }

//     // HashMap uses an array of linked lists (chaining)
//     int buckets;
//     Node[] storage;

//     // Constructor
//     public MyHashMap() {
//         buckets = 1000;
//         storage = new Node[buckets];  // initially, all entries are null
//     }

//     // Hash function to find bucket index
//     int getBucket(int key) {
//         return key % buckets;
//     }

//     // Helper function to find the previous node before the key
//     // This helps in put(), get(), and remove()
//     Node find(Node dummy, int key) {
//         Node prev = dummy;
//         Node current = prev.next;
        
//         // Traverse until you find the key or reach end
//         while (current != null && current.key != key) {
//             prev = current;
//             current = current.next;
//         }
//         return prev;  // return the node just before the target node
//     }

//     // Inserts a new key-value pair or updates if key already exists
//     public void put(int key, int value) {
//         int bucket = getBucket(key);
        
//         // Initialize dummy node if this bucket is empty
//         if (storage[bucket] == null) {
//             storage[bucket] = new Node(-1, -1);
//         }
        
//         Node prev = find(storage[bucket], key);
        
//         // If key doesn't exist, insert new node
//         if (prev.next == null) {
//             prev.next = new Node(key, value);
//         } else {
//             prev.next.value = value;  // If key exists, update value
//         }
//     }

//     // Retrieves the value for the given key or -1 if not found
//     public int get(int key) {
//         int bucket = getBucket(key);
//         if (storage[bucket] == null) return -1;

//         Node prev = find(storage[bucket], key);
//         return (prev.next != null) ? prev.next.value : -1;
//     }

//     // Removes the key-value pair if key exists
//     public void remove(int key) {
//         int bucket = getBucket(key);
//         if (storage[bucket] == null) return;

//         Node prev = find(storage[bucket], key);
//         if (prev.next != null) {
//             prev.next = prev.next.next;  // unlink the node
//         }
//     }
// }
