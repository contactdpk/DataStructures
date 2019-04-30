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

    public void printList(LinkedList linkedList) {
        System.out.println("Print List----------------------");
        Node start = linkedList.getHead();
        while (start != null) {
            System.out.print(start.getData() + "\t");
            start = start.getNext();
        }
        System.out.println();
    }

    public Node getRandomNode(LinkedList linkedList, int length) {
        Random random = new Random();
        int position = random.nextInt(length);
        Node node = linkedList.getHead();
        int i = 0;
        while (node.getNext() != null && i != position - 1) {
            node = node.getNext();
            i++;
        }
        if (node != null) {
            System.out.println("Random Node Position" + "\t" + position + "\t" + "Data" + "\t" + node.getData());
        }
        return node;
    }

    /**
     * Insert at the begining of a list
     * Time Complexity O(1)
     */
    public void push(LinkedList linkedList, int data) {
        Node node = new Node(data);
        node.setNext(linkedList.getHead());
        linkedList.setHead(node);
        ;
    }

    /**
     * Insert after the given prevNode
     * Time Complexity O(1)
     */
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
    }

    /**
     * Insert node at the end of the list
     * Time Complexity O(n)
     */
    public void append(LinkedList linkedList, int data) {
        Node newNode = new Node(data);
        Node node = linkedList.getHead();
        if (node == null) {
            linkedList.setHead(newNode);
            return;
        }
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(newNode);
    }

    /**
     * Given a key, deletes the first occurrence of key in linked list
     */
    public void deleteNode(LinkedList linkedList, int dataKey) {
        Node current = linkedList.getHead();
        Node previous = null;
        if (current != null && current.getData() == dataKey) {
            linkedList.setHead(current.getNext());
            return;
        }
        while (current != null && current.getData() != dataKey) {
            previous = current;
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        previous.setNext(current.getNext());
    }

    public int lengthRecursive(Node node, int length) {
        if (node == null) {
            return length;
        } else {
            return lengthRecursive(node.getNext(), length + 1);
        }
    }

    public boolean searchRecursive(Node node, int data) {
        if (node == null) {
            return false;
        } else if (node.getData() == data) {
            return true;
        } else {
            return searchRecursive(node.getNext(), data);
        }
    }
}
