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
