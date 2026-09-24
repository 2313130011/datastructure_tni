package ss;

public class TestApp {

    public static void main(String[] args) {

        int[] nums1 = {11, 9, 23, 87, 38, 22, 92, 10};
        Sorting sort1 = new Sorting(nums1);

        System.out.print("Bubble Sort: ");
        sort1.bubbleSort();
        sort1.printSortedData();

        System.out.println("");


        int[] nums2 = {11, 9, 23, 87, 38, 22, 92, 10};
        Sorting sort2 = new Sorting(nums2);

        System.out.print("Selection Sort: ");
        sort2.selectionSort();
        sort2.printSortedData();

        System.out.println();


        int[] nums3 = {11, 9, 23, 87, 38, 22, 92, 10};
        Sorting sort3 = new Sorting(nums3);

        System.out.print("Insertion Sort: ");
        sort3.insertionSort();
        sort3.printSortedData();

        System.out.println();


        int[] nums4 = {11, 9, 23, 87, 38, 22, 92, 10};
        Sorting sort4 = new Sorting(nums4);

        System.out.print("Quick Sort: ");
        sort4.quicksort();
        sort4.printSortedData();

    }

}