import java.util.Stack;

public class QUsingStack {
    Stack<Integer> stack;
    Stack<Integer> dupe;
    int length;
    int dlength;

    public QUsingStack() {
        stack = new Stack<Integer>();
        dupe = new Stack<Integer>();
        length = 0;
        dlength = 0;
    }

    public void push(int data){
        stack.push(data);
        length++;

    }

    public int pop(){
    if(length>0 && dlength == 0){
        int x = length;
        while(x>0){
            int y = stack.pop();
            dupe.push(y);
            length--;
            dlength++;
            x--;
        }
        dlength--;
        return dupe.pop();
    }
    else if(length>=0 && dlength>0){
        dlength--;
        return dupe.pop();
    }
    else {
        System.out.println("Queue Underflow");
        return -1;
    }

    }

    public int peek(){
        if(length>0 && dlength == 0){
            int x = length;
            while(x>0){
                int y = stack.pop();
                dupe.push(y);
                length--;
                dlength++;
                x--;
            }
            return dupe.peek();
        }
        else if(length>=0 && dlength>0){
            return dupe.peek();
        }
        else {
            System.out.println("Queue Underflow");
            return -1;
        }

    }

    public boolean empty(){
    if(length<1 && dlength<1)
        return true;
    else
        return false;
    }

    public static void main(String[] args) {
        QUsingStack q = new QUsingStack();
        q.push(2);
        q.push(1);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
