/** Array based list. */
public class ArrayDeque<T> {
    private T[] arr;
    private int size;
    /** Creates an empty list. */
    public ArrayDeque() {
        size = 0;
        arr = (T []) new Object[8];
    }
    public ArrayDeque(ArrayDeque<T> other) {

    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {

    }
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == arr.length) {

        }
        arr[size] = item;
        size += 1;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int size() {
        return size;
    }
    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line. */
    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(arr[i] + "");
        }
    }
    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {

    }
    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        T tmp = arr[size - 1];
        arr[size - 1] = null;
        size -= 1;
        return tmp;
    }
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        return arr[index];
    }
}