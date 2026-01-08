//
//  ImplementHashMapUsingLinearChaining.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 12/29/25.
//

class MyHashMap {
    class LCNode {
        var key: Int
        var value: Int
        var next: LCNode?
        
        init(key: Int, value: Int, next: LCNode? = nil) {
            self.key = key
            self.value = value
            self.next = next
        }
    }
    
    var storage: [LCNode?]
    
    private var buckets: Int
    private func hash(key: Int) -> Int {
        return key % buckets
    }
    
    //storage will be an arry of linked lists.
    init() {
        //an array of 10000 elements while having range from 0 to 1 million (for input)
        self.storage = Array(repeating: nil, count: 10000)
        buckets = 10000
    }
    
    //for below three functions, this function will be used
    private func find(head: LCNode, key: Int) -> LCNode {
        //set previous pointer to head of the linked list
        var prev = head //at head we will be having a dummy node.
        var current = head.next
        //Stop when the current reaches the length or we find the value
        while (current != nil && current?.key != key) {
            prev = current!
            current = current?.next
        }
        return prev
    }
    
    func put(key: Int, value: Int) {
        let index = hash(key: key)
        if (storage[index] != nil) {
            //traverse through this linked list
            //thers is no linked list, so initiate the linked list
            storage[index] = LCNode(key: -1, value: -1)
        }
        //when linked list is already there
        let prev = find(head: storage[index]!, key: key)
        //if key is in the current linked list.
        
        //if current key is not there in the list
        //it will tell us that the current node is not present in the node.
        if (prev.next == nil) {
            let newNode = LCNode(key: key, value: value)
            prev.next = newNode
        } else {
            //current key is there.
            prev.next?.value = value
        }
    }
    
    func get(key: Int) -> Int {
        let index = hash(key: key)
        if (storage[index] == nil) {
            return -1
        }
        let prev = find(head: storage[index]!, key: key)
        if (prev.next == nil) {
            return -1
        }
        
        return prev.next!.value
    }
    
    //key is equal to the index of the array we took
    func remove(key: Int) {
        let index = hash(key: key)
        //If linked list is not present then return
        if (storage[index] == nil) {
            return
        }
        
        //otherwise traverse through the linked list
        let prev: LCNode = find(head: storage[index]!, key: key)
        if (prev.next == nil) {
            return
        }
        let temp: LCNode = prev.next!
        prev.next = prev.next?.next
        temp.next = nil
    }
}
