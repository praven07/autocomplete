import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        if (a == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < a.length; i++) {
            if (comparator.compare(a[i], key) == 0) {
                return i;
            }
        }

        return -1;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        if (a == null) {
            throw new IllegalArgumentException();
        }

        for (int i = a.length - 1; i >= 0; i--) {
            if (comparator.compare(a[i], key) == 0) {
                return i;
            }
        }

        return -1;
    }
}
