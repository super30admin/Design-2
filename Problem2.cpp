//
// Created by shazmaan on 7/2/2019.
//

#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
#include <bits/stdc++.h>


#define MAX 10
#define BuckSize 5

using namespace std;

class MyHashSet {

    /** Initialize your data structure here. */

public:
    int array[MAX][BuckSize];

    MyHashSet() {
//            std::fill_n(array[0][0], array[0][0] + sizeof(array), -1);
//            std::fill_n(array,MAX,(-1));
        memset(array,-1,sizeof(array));
    }
    void add(int key);
    bool contains(int key);
    void remove(int key);
    int hashfunc(int key);
    void ReHash();
};

/** value will always be non-negative. */

void MyHashSet::add(int key) {
    int newKey = MyHashSet::hashfunc(key)%MAX; //find first index
    int BuckKey = MyHashSet::hashfunc(newKey)%BuckSize;
    if(array[newKey][BuckKey]!=(-1)){
        array[newKey][BuckKey]=key;//rehash or update value
    }else{
        array[newKey][BuckKey]=key;
    }
}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */

bool MyHashSet::contains(int key) {
    int newKey = MyHashSet::hashfunc(key)%MAX; //find first index
    int BuckKey = MyHashSet::hashfunc(newKey)%BuckSize;
    if(array[newKey][BuckKey]!=(-1)){
        return true;
    }return false;
//    cout<<"KEY : "<<key<<" ";
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */

void MyHashSet::remove(int key) {
    int newKey = MyHashSet::hashfunc(key)%MAX; //find first index
    int BuckKey = MyHashSet::hashfunc(newKey)%BuckSize;
    if(array[newKey][BuckKey]!=(-1)){
        array[newKey][BuckKey]=(-1);
    }
}
void MyHashSet::ReHash(){
    //rehash function
}
int MyHashSet::hashfunc(int key) {  //HashFunction for main Array
    return std::hash<int>()(key);
}

