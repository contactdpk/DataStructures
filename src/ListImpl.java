import java.util.Random;

/**
 * Created by Deepak on 4/28/2019.
 */
public class ListImpl {

    public LinkedList createLinkedList(int numberOfNodes, boolean printNodeData) {
        Random random = new Random();
        LinkedList linkedList = new LinkedList();
        Node last = null;
        for (int i = 0; i < numberOfNodes; i++) {
            Node node = new Node(random.nextInt(100));
            if (linkedList.getHead() == null) {
                linkedList.setHead(node);
            } else {
                last.setNext(node);
            }
            last = node;
            if (printNodeData) {
                System.out.println("Data " + (i + 1) + "\t" + node.getData());
            }
        }
        return linkedList;
    }

    public void printList(Node start) {
        System.out.println("Print List----------------------");
        while (start != null) {
            System.out.print(start.getData() + "\t");
            start = start.getNext();
        }
    }

    /**Insert at the begining of a list*/
    public void push(LinkedList linkedList, int data){
        Node node = new Node(data);
        node.setNext(linkedList.getHead());
        linkedList.setHead(node);;
    }
}
