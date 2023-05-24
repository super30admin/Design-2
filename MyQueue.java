// Time complexity for push function will be o(n) and for other function o(1);
//Space complexity will be o(n) as we are taking an extra stack.
class MyQueue {
    int s1[];
    int s2[];
    int top1;
    int top2,max=100;

    public MyQueue() {
       s1 = new int[max];
       s2= new int[max];
       top1=-1; top2=-1; 
    }
    
    public void push(int x) {
        if(top1==max-1) return;
        
        while(top1 > -1)
        {
            int val = s1[top1];
            top1--;
            top2++;
            s2[top2]=val;
        }
        top2++;
        s2[top2] = x;
        while(top2>-1)
        {
            int val = s2[top2];
            top2--;
            top1++;
            s1[top1]=val;
        }
    }
    
    public int pop() {
       int val = s1[top1];
       top1--;
       return val;
    }
    
    public int peek() {
       return s1[top1];
    }
    
    public boolean empty() {
        if(top1 == -1) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */