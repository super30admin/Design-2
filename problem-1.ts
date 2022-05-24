// Time Complexity O(1)
// Space Complexity O(n)
class MyHashSet {
    obj = {};

    add(key: number) {
        this.obj[key] = true;
    }

    remove(key: number) {
        this.obj[key] = false;
    }

    contains(key: number) {
        return this.obj[key] ? true : false;
    }
};

const hashSet = new MyHashSet();
hashSet.add(5);
hashSet.add(10);
hashSet.remove(5);
hashSet.contains(5); // returns false
const isExists = hashSet.contains(10);
console.log(isExists);
    

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */