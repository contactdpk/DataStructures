import java.util.Random;

public class Main {
    static int numberOfNodes = 5;
    public static void main(String[] args) {
        // write your code here
        ListImpl listImpl = new ListImpl();
        LinkedList linkedList = listImpl.createLinkedList(numberOfNodes, false);
        listImpl.printList(linkedList.getHead());
        /*listImpl.push(linkedList, 999);
        listImpl.printList(linkedList.getHead());*/
        listImpl.insertAfter(listImpl.getRandomNode(linkedList, numberOfNodes), 999);
        listImpl.printList(linkedList.getHead());
    }
}
