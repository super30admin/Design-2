//Time complexity: O(1) on average for put, get, and remove operations
//Space complexity: O(n) where n is the number of unique keys stored in the Hash

import java.util.*

class HashMap() {
    private val bucketSize = 10000
    private val buckets = Array(bucketSize) { LinkedList<Pair<Int,Int>>() }

    fun put(key: Int, value: Int) {
        val bucket = key % bucketSize

        for ((index, keyValue) in buckets[bucket].withIndex()) {
            if (keyValue.first == key) {
                buckets[bucket][index] = Pair(key, value)
                return
            }
        }

        buckets[bucket].add(Pair(key, value))
    }

    fun get(key: Int): Int {
        val bucket = key % bucketSize
        return buckets[bucket].find { it.first == key }?.second ?: -1
    }

    fun remove(key: Int) {
        val bucket = key % bucketSize
        for (keyValue in buckets[bucket]) {
            if (keyValue.first == key) {
                buckets[bucket].remove(keyValue)
                break
            }
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */