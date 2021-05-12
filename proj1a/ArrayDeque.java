public class ArrayDeque<T> {
    public T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int INITIAL_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[])new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = items.length / 2;
        nextLast = items.length / 2 + 1;
    }

    /** Must take constant time. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Each time we use addLast, the nextLast will step to the next index. But there's a special case.
     * If the the nextLast is located in the end of the array, then it should skip to the head of the array. */
    public int plusOne(int index) {
        index = (index + 1) % items.length;
        return index;
    }

    /** Each time we use addFirst, the nextFirst will step to the previous index. But there's a special case.
     * If the the nextFirst is located in the head of the array, then it should skip to the end of the array. */
    public int minusOne(int index) {
        index = (index - 1) % items.length;
        return index;
    }

    /** Must take constant time, except during resizing operations. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextFirst] = item;
        size = size + 1;
        nextFirst = minusOne(nextFirst);
    }

    /** Must take constant time, except during resizing operations. */
    public void addLast(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextLast] = item;
        size = size + 1;
        nextLast = plusOne(nextLast);
    }

    /** Must take constant time, except during resizing operations. */
    public T removeFirst() {
        size = size - 1;
        /** The nextFirst should go next. */
        nextFirst = plusOne(nextFirst);
        T removedNode = items[nextFirst];
        items[nextFirst] = null;
        return removedNode;
    }

    /** Must take constant time, except during resizing operations. */
    public T removeLast() {
        size = size - 1;
        /** The nextLast should go previously. */
        nextLast = minusOne(nextLast);
        T removedNode = items[nextLast];
        items[nextLast] = null;
        return removedNode;
    }

    /** Must take constant time. */
    public T get(int index) {
        if (index < 0 || index >= items.length) {
            return null;
        }
        return items[index];
    }

    public void resize() {
        /** Is the array full? */
        if (size == items.length) {
            expand();
        }
        /** For arrays of length 16 or more,
         * your usage factor should always be at least 25%. */
        if (size <= (items.length / 4) && size > 8) {
            reduce();
        }
    }

    public void expand() {
        T[] resizedArray = (T[])new Object[items.length * 2];
        System.arraycopy(items, nextFirst, resizedArray, 0, items.length);
        nextFirst = resizedArray.length - 1;
        nextLast = items.length;
        items = resizedArray;
    }

    public void reduce() {
        return;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addFirst(3);
        d.addLast(6);
        d.addLast(7);
        d.addFirst(-1);
        d.addFirst(-2);
        d.addFirst(-3);
        d.addFirst(-3);
        d.addFirst(-3);
        d.addFirst(-3);
        d.addFirst(-3);
        System.out.println(d.get(5));
    }

}
