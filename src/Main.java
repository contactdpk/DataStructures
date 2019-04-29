import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ListImpl listImpl = new ListImpl();
        LinkedList linkedList = listImpl.createLinkedList(10, false);
        listImpl.printList(linkedList.getHead());
        listImpl.push(linkedList, 999);
        listImpl.printList(linkedList.getHead());
    }
}
