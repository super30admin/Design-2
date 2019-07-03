public class HashSet {
	int arr[]=new int[1000000];
    int size=0,index=-1;
    
    
    public void add(int key) {
        if(!this.contains(key)){
        arr[size++]=key;
        }
    }
    
    public void remove(int key) {
        if(this.contains(key)){
            for(int i=index;i<size;i++)
            {
               
                    arr[i]=arr[i+1];
                
            }
            index=-1;
            size--;
        }
    }
    

    public boolean contains(int key) {
     for(int i=0;i<size;i++){
    	 if(arr[i]==key)
    	 { index=i;
    	 return true;
    	}
    	 }   
    return false;    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet obj = new HashSet();
		 obj.add(1);
		 boolean param = obj.contains(1);
		 System.out.println(param);
		 obj.remove(1);
		  param = obj.contains(1);
		  System.out.println(param);

	}

}
