import java.util.Random;

/**
 * Created by Deepak on 5/22/2019.
 */
public class SortImpl {

    public int[] createRandomArray(int numberOfElements, boolean printElement, int bound) {
        Random random = new Random();
        int[] arr = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = random.nextInt(bound);
            if (printElement) {
                System.out.println("Element " + (i + 1) + "\t" + arr[i]);
            }
        }
        printArray(arr);
        return arr;
    }

    public void printArray(int[] arr) {
        System.out.println("Print Array----------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        int j = end - 1;
        while (i <= j) {
            if (arr[i] < pivot) {
                i++;
            } else if (arr[j] > pivot) {
                j--;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        int temp = arr[i];
        arr[i] = pivot;
        arr[end] = temp;
        return i;
    }
}
