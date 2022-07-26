class MyHashMap() {
    private val bucketSize = 10000
    private val buckets = Array(bucketSize) { LinkedList<Pair<Int,Int>>() }

    fun put(key: Int, value: Int) {
        val bucket = key % bucketSize

        var index = 0
        for (keyValue in buckets[bucket]) {
            if (keyValue.first == key) {
                buckets[bucket].set(index, Pair(key, value))
                return
            }
            index++
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