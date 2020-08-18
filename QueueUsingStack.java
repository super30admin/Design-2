import java.util.Stack;
public class QueueUsingStack{
    Stack<Integer> pushStack;
    Stack<Integer> popAndPeekStack;
    public static void main(String[] args){
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.pushonStack(10);
        queueUsingStack.pushonStack(1);
        int element = queueUsingStack.popFromStack();
        int element1 = queueUsingStack.popFromStack();
        System.out.println(queueUsingStack.empty());
    }

    public QueueUsingStack(){
        pushStack = new Stack<>();
        popAndPeekStack = new Stack<>();
    }

    public void pushonStack(int element){
        System.out.println(element);
        pushStack.push(element);
        System.out.println(pushStack);
    }

    public int popFromStack(){
        if(popAndPeekStack.isEmpty()){
            while(! pushStack.isEmpty())
                popAndPeekStack.push(pushStack.pop());
        }
        int element=0;
        if(!popAndPeekStack.isEmpty())
            element = popAndPeekStack.pop();
        return element;
    }

    public int peek() {
        if(popAndPeekStack.isEmpty()){
            while(! pushStack.isEmpty())
                popAndPeekStack.push(pushStack.pop());
        }
        int element=0;
        if(!popAndPeekStack.isEmpty())
            element = popAndPeekStack.peek();
        return element;       
    }

    public boolean empty() {
        return (pushStack.isEmpty() && popAndPeekStack.isEmpty());
    }

}