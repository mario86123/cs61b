/** Array based list. */
public class ArrayDeque<T> {
    private T[] arr;
    private int size;
    private int nextFirst;
    private int nextLast;
    /** Creates an empty list. */
    public ArrayDeque() {
        size = 0;
        arr = (T []) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }
    public ArrayDeque(ArrayDeque<T> other) {
        size = other.size;
        arr = (T []) new Object[other.arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            arr[i] = other.arr[i];
        }
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
    }
    private int plusOne(int x) {
        return (x + 1) % arr.length;
    }
    private int minusOne(int x) {
        return (x - 1 + arr.length) % arr.length;
    }
    private void resize(int cap) {
        T[] a = (T []) new Object[cap];
        for (int i = 0; i < size; i += 1) {
            a[i] = arr[(nextFirst + 1 + i) % arr.length];
        }
        arr = a;
        nextFirst = arr.length - 1;
        nextLast = size;
    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (size == arr.length) {
            resize(size * 2);
        }
        arr[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == arr.length) {
            resize(arr.length * 2);
        }
        arr[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line. */
    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(arr[(nextFirst + i + 1) % arr.length] + " ");
        }
        System.out.println();
    }
    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T tmp = arr[plusOne(nextFirst)];
        arr[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size -= 1;
        if ((float) size / arr.length > 0.25) {
            resize(arr.length / 2);
        }
        return tmp;
    }
    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T tmp = arr[minusOne(nextLast)];
        arr[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size -= 1;
        if ((float) size / arr.length > 0.25) {
            resize(arr.length / 2);
        }
        return tmp;
    }
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        return arr[(index + nextFirst + 1) % arr.length];
    }
}