//706. Design HashMap

/*
Time Complexity: O(N/K) - N = all possible keys, K = bucket size
Space Complexity: O(K+N)
*/


class Bucket{
    private: 
        list<pair<int,int>> bucket;
    
    public:

        int get(int key){
            for(const auto& p : bucket){
                if(p.first == key) return p.second;
            }

            return -1;
        }

        void update(int key, int value){
            bool found = false;
            for(auto& p: bucket){
                if(p.first == key){
                    p.second = value;
                    found = true;
                }
            }
            if(!found)
                bucket.push_back(make_pair(key,value));
        }

        void remove(int key){
            for(auto it = bucket.begin(); it != bucket.end(); it++){
                if(it->first == key){
                    bucket.erase(it);
                    break;
                }
            }
        }
};

class MyHashMap {
    private: 
    int keySpace;
    vector<Bucket> hashTable;
    
public:
    MyHashMap() {
        keySpace = 2069;
        hashTable.resize(keySpace, Bucket());        
    }
    
    void put(int key, int value) {
        int hashKey = key % keySpace;
        return hashTable[hashKey].update(key,value);            
    }
    
    int get(int key) {
        int hashKey = key % keySpace;
        return hashTable[hashKey].get(key);    
    }
    
    void remove(int key) {
        int hashKey = key % keySpace;
        return hashTable[hashKey].remove(key);            
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */