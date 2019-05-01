import java.util.Scanner;

public class Main {
    private static int numberOfNodes = 10;
    private static ListImpl listImpl;
    private static LinkedList linkedList;

    public static void main(String[] args) {
        // write your code here
        listImpl = new ListImpl();
        linkedList = listImpl.createLinkedList(numberOfNodes, false);
        listImpl.printList(linkedList);
        /*listImpl.push(linkedList, 999);
        listImpl.insertAfter(listImpl.getRandomNode(linkedList, numberOfNodes), 999);
        listImpl.append(linkedList, 999);*/
        //System.out.println(listImpl.lengthRecursive(linkedList.getHead(), 0));
        //searchRecursiveDriver();
    }

    private static void deleteNodeDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Node Key To Delete");
        listImpl.deleteNode(linkedList, scanner.nextInt());
        listImpl.printList(linkedList);
    }

    private static void searchRecursiveDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Node Key To Search");
        System.out.println(listImpl.searchRecursive(linkedList.getHead(), scanner.nextInt()));
    }
}
