package stack;

/**
 * Created by Deepak on 7/14/2019.
 */
public class StackMain {

    public static void main(String[] args) {
        queueUsingStackDriver();
    }

    public static void queueUsingStackDriver(){
        QueueUsingStack queue = new QueueUsingStack();
        queue.enQueue2(1);
        queue.enQueue2(2);
        queue.enQueue2(3);
        System.out.println(queue.deQueue2());
        System.out.println(queue.deQueue2());
        System.out.println(queue.deQueue2());
        System.out.println(queue.deQueue2());
    }
}
