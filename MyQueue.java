class MyQueue {
Stack <Integer> in;
Stack <Integer> t;

    public MyQueue() {
        in=new Stack<>();
       t= new Stack<>();
    }
    
    public void push(int x) {
       in.push(x); 
    }
    
    public int pop() {
        if(t.isEmpty())
        {
            while(!in.isEmpty())
{t.push(in.pop());}
        }

       return t.pop();
    }
    
    public int peek() {
       if(t.isEmpty())
       {
        while(!in.isEmpty())

        {
            t.push(in.pop());
        }
      

       }
        return  t.peek();

    }
    
    public boolean empty() {
        return in.isEmpty() && t.isEmpty();
    }
}

