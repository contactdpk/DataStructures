/**
 * Created by Deepak on 5/22/2019.
 */
public class SortMain {
    private static int numberOfElements = 20;
    private static int bound = 30;
    private static SortImpl sortImpl;

    public static void main(String[] args) {
        // write your code here
        sortImpl = new SortImpl();
        quickSortDriver();
    }

    private static void quickSortDriver(){
        int[] arr = sortImpl.createRandomArray(numberOfElements, false, bound);
        sortImpl.quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted Array");
        sortImpl.printArray(arr);
    }

    private static void mergeSortDriver(){
        int[] arr = sortImpl.createRandomArray(numberOfElements, false, bound);
        sortImpl.mergeSort(arr, 0, arr.length-1);
        System.out.println("Sorted Array");
        sortImpl.printArray(arr);
    }
}
