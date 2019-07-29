package linkedList;

import java.util.Scanner;

public class Main {
    private static int numberOfNodes = 5;
    private static int bound = 20;
    private static ListImpl listImpl;
    private static LinkedList linkedList;

    public static void main(String[] args) {
        // write your code here
        listImpl = new ListImpl();
        linkedList = listImpl.createLinkedList(numberOfNodes, false, bound);
        listImpl.printList(linkedList);
        listImpl.printReverseRecursive(linkedList.getHead());
    }

    private static void deleteNodeDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter linkedList.Node Key To Delete");
        listImpl.deleteNode(linkedList, scanner.nextInt());
        listImpl.printList(linkedList);
    }

    private static void searchRecursiveDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter linkedList.Node Key To Search");
        System.out.println(listImpl.searchRecursive(linkedList.getHead(), scanner.nextInt()));
    }

    private static void countIterativeDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter linkedList.Node Key To Count");
        int dataToCount = scanner.nextInt();
        listImpl.countIteratively(linkedList, dataToCount);
        System.out.println("Count Recursive = " + listImpl.countRecursively(linkedList.getHead(), dataToCount));
    }

    private static void detectLoopDriver() {
        System.out.println("Loop Found : " + listImpl.detectLoopByHashing(linkedList));
        System.out.println("Loop Found : " + listImpl.detectLoopByFloydsAlgo(linkedList));
        linkedList = listImpl.createLoopedLinkedList(numberOfNodes, true, bound);
        System.out.println("Loop Found : " + listImpl.detectLoopByHashing(linkedList));
        System.out.println("Loop Found : " + listImpl.detectLoopByFloydsAlgo(linkedList));
    }

    private static void isPalindromeDriver() {
        System.out.println("Is Palindrome : " + listImpl.isPalindrome(linkedList));
        System.out.println("Is Palindrome : " + listImpl.isPalindromeRecursiveHelper(linkedList.getHead()));
        listImpl.printList(linkedList);
        LinkedList oddPalindromeList = listImpl.createOddPalindromeList();
        listImpl.printList(oddPalindromeList);
        System.out.println("Is Palindrome : " + listImpl.isPalindrome(oddPalindromeList));
        System.out.println("Is Palindrome : " + listImpl.isPalindromeRecursiveHelper(oddPalindromeList.getHead()));
        listImpl.printList(oddPalindromeList);
        LinkedList evenPalindromeList = listImpl.createEvenPalindromeList();
        listImpl.printList(evenPalindromeList);
        System.out.println("Is Palindrome : " + listImpl.isPalindrome(evenPalindromeList));
        System.out.println("Is Palindrome : " + listImpl.isPalindromeRecursiveHelper(evenPalindromeList.getHead()));
        listImpl.printList(evenPalindromeList);
    }

    private static void swapNodesDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Nodes To Swap");
        listImpl.swapNodes(linkedList, scanner.nextInt(), scanner.nextInt());
    }

    private static void sortedIntersectDriver() {
        LinkedList listX = listImpl.createSortedLinkedList(5, 10, true);
        LinkedList listY = listImpl.createSortedLinkedList(8, 15, false);
        listImpl.sortedIntersect(listX, listY);
    }
}
