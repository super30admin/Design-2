//
//  ImplementQueueUsingTwoStacks.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 12/30/25.
//

//Implment queue using 2 stacks.

class QueueImpl {
    var inStack = StackUsingLL(llList: LLLinkedList<Int>())
    var outStack = StackUsingLL(llList: LLLinkedList<Int>())
    
    func push(element: Int) {
        //push element in stack1
        inStack.push(value: element)
    }
    
    func pop() -> Int? {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                //push all elements from stack1 to stack2 and then pop
                outStack.push(value: inStack.pop()!)
            }
        }
        return outStack.pop()
    }

    func peek() -> Int? {
        while (!inStack.isEmpty()) {
            outStack.push(value: inStack.pop()!)
        }
        return outStack.peek()
    }
    
    func isEmpty() -> Bool {
        return (inStack.isEmpty() && outStack.isEmpty())
    }
    
    init() {
        let inputArray: [Any] = [4, 2, 1, 3, 5, "P", 6, 7, "P", "P"]
        for element in inputArray {
            if (element as? String != "P") {
                push(element: element as! Int)
            } else {
                let poppedElement = pop()
                print("poppedElement \(poppedElement, default: "NA")")
            }
        }
        print("stack1 \(inStack.description)")
        print("stack2 \(outStack.description)")
    }
}
