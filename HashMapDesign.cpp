const int N=1e6+10;
int arr[N];
class MyHashMap {
public:
    MyHashMap(){
        for(int i=0;i<N;i++)arr[i]=-1;
    }
    
    void put(int key, int value){
        arr[key]=value; 
    }       
    
    int get(int key){
        return arr[key];
    }        
    
    void remove(int key){
        arr[key]=-1;
    }

};