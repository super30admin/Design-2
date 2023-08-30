//Time complexity: O(n)
//Spave comple]xity: O(n)

class MyHashMap {
public:
int bucket;
vector<list<pair<int,int>>> storage;

    MyHashMap() {
        bucket=1000;
        storage.resize(bucket);
    }
    
    int getBucket(int key)
    {
        return key%bucket;
    }

    list<pair<int,int>> :: iterator search(int key)
    {
        int bucket=getBucket(key);
        list<pair<int,int>>::iterator itr=storage[bucket].begin();
        while(itr!=storage[bucket].end())
        {
            if(itr->first==key)
            {
                return itr;
            }
            itr++;
        }
        return itr;
    }
    void put(int key, int value) {
        int bucket=getBucket(key);
        remove(key);
        storage[bucket].push_back({key, value});
    }
    
    int get(int key) {
        int bucket=getBucket(key);
        list<pair<int,int>> :: iterator itr=search(key);
        if(itr==storage[bucket].end())
        {
            return -1;
        }
        else
            return itr->second;
    }
    
    void remove(int key) {
        int bucket=getBucket(key);
        list<pair<int,int>>:: iterator itr=search(key);
        if(itr!=storage[bucket].end())
        {
            storage[bucket].erase(itr);
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */