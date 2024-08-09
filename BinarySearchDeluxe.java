import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        if (a == null) {
            throw new IllegalArgumentException();
        }

        int left = 0;
        int right = a.length - 1;

        int result = -1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            int compare = comparator.compare(a[middle], key);

            if (compare == 0) {
                result = middle;
                right = middle - 1;
            }
            else if (compare < 0) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return result;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        if (a == null) {
            throw new IllegalArgumentException();
        }

        int left = 0;
        int right = a.length - 1;

        int result = -1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            int compare = comparator.compare(a[middle], key);

            if (compare == 0) {
                result = middle;
                left = middle + 1;
            }
            else if (compare < 0) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return result;
    }
}
