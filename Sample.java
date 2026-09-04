// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class MyQueue {
    private var inStack: [Int] = []
    private var outStack: [Int] = []

    //O(1) always
    func push(_ x: Int) {
        inStack.append(x)
    }

    //O(1) amortized
    func pop() -> Int {
        transferIfNeeded()
        return outStack.removeLast()
    }

    //O(1) amortized, O(n) worst case,
    func peek() -> Int {
        transferIfNeeded()
        return outStack.last!
    }

    //O(1) always.
    func empty() -> Bool {
        return inStack.isEmpty && outStack.isEmpty
    }

    private func transferIfNeeded() {
        if outStack.isEmpty {
            while !inStack.isEmpty {
                outStack.append(inStack.removeLast())
            }
        }
    }
}


    

/**
 * Your MyQueue object will be instantiated and called as such:
 * let obj = MyQueue()
 * obj.push(x)
 * let ret_2: Int = obj.pop()
 * let ret_3: Int = obj.peek()
 * let ret_4: Bool = obj.empty()
 */

    

//Design Hashmap
    
    //put, get, remove: average O(1), worst case O(n)  - Time Complexity
        //O(n) - Space complexity
    
    class MyHashMap {
        class Node {
            var key: Int
            var value: Int
            var next: Node?
            init(_ key: Int, _ value: Int) {
                self.key = key
                self.value = value
            }
        }

        private var storage: [Node?]
        private let buckets = 1000

        init() {
            storage = [Node?](repeating: nil, count: buckets)
        }

        private func getHash(_ key: Int) -> Int {
            return key % buckets
        }

        private func getPrev(_ head: Node, _ key: Int) -> Node {
            var prev: Node? = nil
            var curr: Node? = head
            while curr != nil && curr!.key != key {
                prev = curr
                curr = curr!.next
            }
            return prev!
        }

        func put(_ key: Int, _ value: Int) {
            let index = getHash(key)
            if storage[index] == nil {
                storage[index] = Node(-1, -1)
                storage[index]!.next = Node(key, value)
                return
            }
            let prev = getPrev(storage[index]!, key)
            if prev.next == nil {
                prev.next = Node(key, value)
            } else {
                prev.next!.value = value
            }
        }

        func get(_ key: Int) -> Int {
            let index = getHash(key)
            guard let head = storage[index] else { return -1 }
            let prev = getPrev(head, key)
            return prev.next?.value ?? -1
        }

        func remove(_ key: Int) {
            let index = getHash(key)
            guard let head = storage[index] else { return }
            let prev = getPrev(head, key)
            guard let curr = prev.next else { return }
            prev.next = curr.next
            curr.next = nil
        }
    }
