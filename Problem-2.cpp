// Time Complexity : O(N) 

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: For the hashMap used the linear chaining approach, where
// we created a vector of nodes and corresponding linked lists to store 
// the key and value pairs.

#include <bits/stdc++.h>
using namespace std;

class MyHashMap
{
public:
    struct Node
    {
        int key;
        int value;
        Node *next;
    };
    vector<Node *> storage;
    MyHashMap()
    {
        storage = vector<Node*>(10000, NULL);
    }

    int hashFunc(int key)
    {
        return key % storage.size();
    }

    Node *find(Node *node, int key)
    {
        Node *curr = node;
        Node *prev = NULL;
        while (curr != NULL && curr->key != key)
        {
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }

    void put(int key, int value)
    {
        int idx = hashFunc(key);
        if (storage[idx] == NULL)
        {
            storage[idx] = new Node{-1, -1};
        }

        Node *prev = find(storage[idx], key);

        if (prev->next == NULL)
            prev->next = new Node{key, value};
        else
            prev->next->value = value;
    }

    int get(int key)
    {
        int idx = hashFunc(key);

        if (storage[idx] == NULL)
            return -1;

        Node *prev = find(storage[idx], key);

        if (prev->next == NULL)
            return -1;

        return prev->next->value;
    }

    void remove(int key)
    {
        int idx = hashFunc(key);

        if (storage[idx] == NULL)
            return;

        Node *prev = find(storage[idx], key);

        if (prev->next == NULL)
            return;

        Node *temp = prev->next;
        prev->next = prev->next->next;
        delete temp;
    }
};