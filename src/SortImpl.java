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
            int pivot = partition1(arr, start, end);
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

    //Another approach to write the partition method for quick sort
    private int partition1(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] sortedArr = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sortedArr[k++] = arr[i++];
            } else {
                sortedArr[k++] = arr[j++];
            }
        }
        if (i <= mid) {
            while (i <= mid) {
                sortedArr[k++] = arr[i++];
            }
        }
        if (j <= end) {
            while (j <= end) {
                sortedArr[k++] = arr[j++];
            }
        }
        for (int l = 0; l < sortedArr.length; l++) {
            arr[start++] = sortedArr[l];
        }
    }
}
