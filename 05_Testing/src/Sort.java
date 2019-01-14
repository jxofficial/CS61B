public class Sort {

    public static void sort(String[] array) {
        // find the smallest item
        // move it to the front
        // selection sort the rest (using recursion?)
        sort(array, 0);

    }
    /** Helper method to sort an array starting from a particular index. Destructive! */
    private static void sort(String[] array, int start) {
        if (start == array.length) {
            return;
        }

        int smallestIndex = findSmallestIndex(array, start);
        // this changes array from {1, 4, 10, 3} to {1, 3, 10, 4}
        swap(array, start, smallestIndex);
        // now the smallest values are already at the front
        sort(array, start + 1);

    }


    public static void swap(String[] array, int a, int b) {
        String temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }



    public static int findSmallestIndex(String[] array, int start) {
        int smallestIndex = start;

        for (int i = smallestIndex; i < array.length; i++) {
            int value = array[i].compareTo(array[smallestIndex]);
            if (value < 0) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }
}
