public class MinQueueTester {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(5);
        obj.push(57);
        obj.push(53);
        obj.push(35);

        int param_2 = obj.pop();
        System.out.println(param_2);

        int param_3 = obj.peek();

        System.out.println(param_3);

        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
