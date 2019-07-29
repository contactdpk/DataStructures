package linkedList;

import java.util.HashSet;
import java.util.Random;

/**
 * Created by Deepak on 4/28/2019.
 */
public class ListImpl {

    public LinkedList createLinkedList(int numberOfNodes, boolean printNodeData, int bound) {
        Random random = new Random();
        LinkedList linkedList = new LinkedList();
        Node last = null;
        for (int i = 0; i < numberOfNodes; i++) {
            Node node = new Node(random.nextInt(bound));
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

    public LinkedList createLoopedLinkedList(int numberOfNodes, boolean printNodeData, int bound) {
        Random random = new Random();
        LinkedList linkedList = new LinkedList();
        Node last = null;
        for (int i = 0; i < numberOfNodes; i++) {
            Node node = new Node(random.nextInt(bound));
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
        last.setNext(linkedList.getHead().getNext());
        return linkedList;
    }

    public LinkedList createOddPalindromeList() {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(0);
        linkedList.setHead(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        return linkedList;
    }

    public LinkedList createEvenPalindromeList() {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(0);
        linkedList.setHead(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return linkedList;
    }

    public LinkedList createSortedLinkedList(int startData, int endData, boolean printNodeData) {
        LinkedList linkedList = new LinkedList();
        Node last = null;
        for (int i = startData; i <= endData; i++) {
            Node node = new Node(i);
            if (linkedList.getHead() == null) {
                linkedList.setHead(node);
            } else {
                last.setNext(node);
            }
            last = node;
            if (printNodeData) {
                System.out.println("Data " + i + "\t" + node.getData());
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
            System.out.println("Random linkedList.Node Position" + "\t" + position + "\t" + "Data" + "\t" + node.getData());
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

    /**
     * Find the nth element from the end iteratively
     */
    public void printNthFromLastIterative(LinkedList linkedList, int n) {
        if (n <= 0) {
            return;
        }
        int length = lengthRecursive(linkedList.getHead(), 0);
        if (n > length) {
            return;
        }
        int indexFromFront = length - n;
        Node current = linkedList.getHead();
        for (int i = 0; i < indexFromFront; i++) {
            current = current.getNext();
        }
        System.out.println(current.getData());
    }

    /**
     * Find the nth element from the end recursively
     */
    static int count = 0;

    public void printNthFromLastRecursively(Node node, int n) {
        if (node == null) {
            return;
        }
        printNthFromLastRecursively(node.getNext(), n);
        count = count + 1;
        if (count == n) {
            System.out.println(node.getData());
        }
    }

    /**
     * Find the middle element of linked list by using length
     */
    public void findMiddleElement1(LinkedList linkedList) {
        int length = lengthRecursive(linkedList.getHead(), 0);
        if (length <= 0) {
            return;
        }
        int nodeIndex = length / 2;
        Node current = linkedList.getHead();
        while (nodeIndex > 0) {
            current = current.getNext();
            nodeIndex--;
        }
        System.out.println(current.getData());
    }

    /**
     * Find the middle element of linked list by using two pointers
     */
    public void findMiddleElement2(LinkedList linkedList) {
        Node slow, fast;
        slow = fast = linkedList.getHead();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        System.out.println(slow.getData());
    }

    /**
     * Find the middle element of linked list by incrementing when counter is odd
     */
    public void findMiddleElement3(LinkedList linkedList) {
        Node mid = linkedList.getHead();
        Node current = linkedList.getHead();
        int count = 0;
        while (current != null) {
            if ((count & 1) == 1) { //check if count is odd
                mid = mid.getNext();
            }
            count++;
            current = current.getNext();
        }
        System.out.println(mid.getData());
    }

    /**
     * Find how many times a number appears in a linked list
     */
    public void countIteratively(LinkedList linkedList, int data) {
        int count = 0;
        Node current = linkedList.getHead();
        while (current != null) {
            if (current.getData() == data) {
                count++;
            }
            current = current.getNext();
        }
        System.out.println("Count = " + count);
    }

    /**
     * Find how many times a number appears in a linked list
     */
    public int countRecursively(Node node, int data) {
        if (node == null) {
            return 0;
        } else {
            if (node.getData() == data) {
                return 1 + countRecursively(node.getNext(), data);
            } else {
                return countRecursively(node.getNext(), data);
            }
        }
    }

    /**
     * Detect loop in a linked list by hashing
     */
    public boolean detectLoopByHashing(LinkedList linkedList) {
        HashSet<Node> set = new HashSet<>();
        Node current = linkedList.getHead();
        while (current != null) {
            if (!set.add(current)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Detect loop in a linked list by Floyd’s Cycle-Finding Algorithm
     */
    public boolean detectLoopByFloydsAlgo(LinkedList linkedList) {
        Node slow, fast;
        slow = fast = linkedList.getHead();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function to check if given linked list is palindrome or not
     */
    public boolean isPalindrome(LinkedList linkedList) {
        Node firstHalf = linkedList.getHead();
        Node slow = linkedList.getHead();
        Node fast = linkedList.getHead();
        Node slowPrev = null;
        Node mid = null;
        while (fast != null && fast.getNext() != null) {
            slowPrev = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if (fast != null) {
            mid = slow;
            slow = slow.getNext();
        }
        slowPrev.setNext(null);
        Node secondHalf = reverseLinkedList(slow);
        boolean isPalindrome = compareList(firstHalf, secondHalf);
        //Reconstruct the original list
        secondHalf = reverseLinkedList(secondHalf);
        if (mid != null) {
            slowPrev.setNext(mid);
            mid.setNext(secondHalf);
        } else {
            slowPrev.setNext(secondHalf);
        }
        return isPalindrome;
    }

    private boolean compareList(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;
        while (curr1 != null && curr2 != null) {
            if (curr1.getData() != curr2.getData()) {
                return false;
            }
            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
        }
        if (curr1 == null && curr2 == null) {
            return true;
        }
        return false;
    }


    /**
     * Function to check if given linked list is palindrome or not recursively
     */
    static Node left;

    public boolean isPalindromeRecursiveHelper(Node right) {
        this.left = right;
        return isPalindromeRecursive(right);
    }

    private boolean isPalindromeRecursive(Node right) {
        if (right == null) {
            return true;
        }
        if (!isPalindromeRecursive(right.getNext())) {
            return false;
        }
        boolean isCurrentDataEqual = right.getData() == left.getData();
        left = left.getNext();
        return isCurrentDataEqual;
    }

    /**
     * Function to reverse a linked List
     */
    public Node reverseLinkedList(Node node) {
        Node previous = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * Function to pairwise swap elements of a linked list
     */
    public void pairwiseSwap(LinkedList linkedList) {
        Node current = linkedList.getHead();
        Node prevX = null;
        Node nextX = null;
        while (current != null && current.getNext() != null) {
            nextX = current.getNext();
            if (prevX == null) {
                linkedList.setHead(nextX);
            } else {
                prevX.setNext(nextX);
            }
            current.setNext(nextX.getNext());
            nextX.setNext(current);

            prevX = current;
            current = current.getNext();
        }
        printList(linkedList);
    }

    /**
     * Function to swap two nodes of a linked list
     */
    public void swapNodes(LinkedList linkedList, int x, int y) {
        printList(linkedList);
        if (x == y) {
            return;
        }
        Node prevX = null;
        Node currX = linkedList.getHead();
        while (currX != null && currX.getData() != x) {
            prevX = currX;
            currX = currX.getNext();
        }
        Node prevY = null;
        Node currY = linkedList.getHead();
        while (currY != null && currY.getData() != y) {
            prevY = currY;
            currY = currY.getNext();
        }

        if (currX == null || currY == null) { //Either x or y is not present
            return;
        }
        if (prevX == null) { // If x is head
            linkedList.setHead(currY);
        } else {
            prevX.setNext(currY);
        }
        if (prevY == null) { //If Y is head
            linkedList.setHead(currX);
        } else {
            prevY.setNext(currX);
        }
        Node temp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(temp);
        printList(linkedList);
    }

    /**
     * Function to create a linked list which is intersection of two sorted linked lists
     */
    public void sortedIntersect(LinkedList listX, LinkedList listY) {
        LinkedList intersectionList = new LinkedList();
        Node currentX = listX.getHead();
        Node currentY = listY.getHead();
        Node tailZ = null;
        while (currentX != null && currentY != null) {
            if (currentX.getData() == currentY.getData()) {
                Node node = new Node(currentX.getData());
                if (intersectionList.getHead() == null) {
                    intersectionList.setHead(node);
                } else {
                    tailZ.setNext(node);
                }
                tailZ = node;
                currentX = currentX.getNext();
                currentY = currentY.getNext();
            } else if (currentX.getData() < currentY.getData()) {
                currentX = currentX.getNext();
            } else {
                currentY = currentY.getNext();
            }
        }
        printList(intersectionList);
    }

    /**
     * Function to segregate even and odd nodes in a Linked List
     * @param linkedList
     */
    public void segregateEvenOdd(LinkedList linkedList) {
        Node prev = null;
        Node last = linkedList.getHead();
        while (last.getNext() != null) {
            last = last.getNext();
        }
        Node newLast = last;
        Node current = linkedList.getHead();
        while (current != last) {
            if (current.getData() % 2 != 0) {
                if (linkedList.getHead() == current) {
                    Node node = current;
                    newLast.setNext(node);
                    newLast = node;
                    linkedList.setHead(node.getNext());
                    current = node.getNext();
                    node.setNext(null);
                } else {
                    Node node = current;
                    prev.setNext(current.getNext());
                    current = current.getNext();
                    newLast.setNext(node);
                    newLast = node;
                    node.setNext(null);
                }
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        if (newLast != last && last.getData() % 2 != 0) {
            prev.setNext(current.getNext());
            current.setNext(null);
            newLast.setNext(current);
        }
    }

    public void printReverseRecursive(Node node){
        if(node == null){
            return;
        }else{
            printReverseRecursive(node.getNext());
            System.out.print(node.getData()+"\t");
        }
    }
}
