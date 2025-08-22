// Time Complexity : O(1)
// O(1) Space Complexity : O(n) where n is the max size of the value
// successfully run on Leetcode : Yes
// Any problem you faced while coding this : This is not yet an optimized
// solution, since we are taking lot of memory
#include <bits/stdc++.h>
using namespace std;

// Used this struct for Linear Chaining (Linked List) based node to avoid hash
// collisions
struct Node {
  int val;
  int key;
  Node *next;
  Node(int k, int v) {
    key = k;
    val = v;
    next = nullptr;
  }
};

class MyHashMap {
public:
  vector<Node *> vec;
  int buckets;

  MyHashMap() {
    buckets = 1e4;
    // resized buckets for our primary buckets to be 10000, so that when we
    // search through linked list to put, remove, get we get amortized O(1)
    // since linked list has to go through atmost 100 items since that will be
    // the amount of collisions
    vec.resize(buckets, nullptr);
  }

  // to get the particular storage bucket
  int hash(int key) { return key % buckets; }

  // a helper function which returns the prev node pointer
  Node *helper(Node *head, int key) {
    Node *prev = nullptr;
    Node *curr = head;
    while (curr && curr->key != key) {
      prev = curr;
      curr = curr->next;
    }
    return prev;
  }

  void put(int key, int value) {
    // calculate the hash
    int hashKey = hash(key);
    // if storage bucket is null create a dummy node, to simplify things
    if (!vec[hashKey]) {
      Node *newhead = new Node(-1, -1);
      newhead->next = new Node(key, value);
      vec[hashKey] = newhead;
    }
    Node *head = vec[hashKey];
    Node *prev = helper(head, key);
    // helper always returns the previous node
    // if prev->next which is current is null, that means we are the last node,
    // so insert the node
    if (prev->next == nullptr) {
      prev->next = new Node(key, value);
    } else {
      // otherwise just update the value
      prev->next->val = value;
    }
  }

  int get(int key) {
    int hashKey = hash(key);
    // check if bucket exists
    if (!vec[hashKey])
      return -1;
    Node *head = vec[hashKey];
    Node *prev = helper(head, key);
    // if last node reached then we did not  find the key
    if (prev->next == nullptr)
      return -1;
    // we found the key so return the value
    return prev->next->val;
  }

  void remove(int key) {
    int hashKey = hash(key);
    if (!vec[hashKey])
      return;
    Node *head = vec[hashKey];
    Node *prev = helper(head, key);
    Node *curr = prev->next;
    // check if last node is null, then means key did not exist
    if (curr == nullptr)
      return;
    // point the prev's next to curr's next
    // remove the curr->next pointer since it's of no use
    // delete to free memory
    prev->next = curr->next;
    curr->next = nullptr;
    delete curr;
  }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
