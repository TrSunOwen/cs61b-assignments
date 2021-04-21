/** I choose circular sentinel here. */
public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }

    /** Sentinel */
    private Node sentinel;

    /** The size of the deque */
    private int size;

    /** I choose to use the circular sentinel. */

    /** Create an empty deque. */
    public LinkedListDeque() {
        /** A sentinel, point to nothing at the initialization.
         * Here I set the default value of item in the sentinel as null */
        this.sentinel = new Node(null);
        this.sentinel.prev = sentinel;
        this.sentinel.next = sentinel;

        /** Create the empty deque: size should be 0. */
        size = 0;
    }

    /** Create deque with an element. */
    public LinkedListDeque(T item) {
        /** A sentinel, point to nothing at the initialization.
         * Here I set the default value of item in the sentinel as null */
        this.sentinel = new Node(null);
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;

        /** Create the deque with parameters, so size should be 1. */
        size = 1;

        this.sentinel.next = new Node(item);
        this.sentinel.next.prev = sentinel;
        this.sentinel.next.next = sentinel;
        this.sentinel.prev = sentinel.next;
    }

    /** Judge whether the deque is empty. */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Return the size of the deque. */
    public int size() {
        return size;
    }

    /** Add an item of type T to the front of the deque. */
    public void addFirst(T item) {
        /** One item has been added. */
        size = size + 1;

        /** Add the first node, namely following the sentinel */
        Node first = new Node(item);
        sentinel.next.prev = first;
        first.next = sentinel.next;
        sentinel.next = first;
        first.prev = sentinel;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        /** One item has been added. */
        size = size + 1;

        /** Add the last node. */
        Node last = new Node(item);
        last.prev = sentinel.prev;
        sentinel.prev.next = last;
        last.next = sentinel;
        sentinel.prev = last;
    }

    /** Remove and return the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        /** No such item exists, returns null. */
        if (this.size == 0) {
            return null;
        }

        /** A pointer, f, points to the first node. */
        Node f = sentinel.next.next;
        sentinel.next = f.next;
        f.next.prev = sentinel;

        /** One item has been removed. */
        size = size - 1;

        /** Return the item at the front of the deque. */
        return f.item;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null. */
    public T removeLast() {
        /** No such item exists, returns null. */
        if (this.size == 0) {
            return null;
        }

        /** A pointer, l, points to the last node. */
        Node l = sentinel.prev;
        sentinel.prev = l.prev;
        l.prev.next = sentinel;

        /** One item has been removed. */
        size = size - 1;

        /** Return the item at the end of the deque. */
        return l.item;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * Must use iteration, not recursion. */
    public T get(int index) {
        /** Create a pointer, pointing at the sentinel at the beginning. */
        Node p = sentinel;

        /** Count the iteration times. It should be never larger than the value of index! */
        int count = 0;

        /** If p.next == sentinel, it means that the whole deque has been gone through. */
        while (p.next != sentinel) {
            p = p.next;
            /** Find the item!  */
            if (count == index) {
                return p.item;
            }
            count++;
        }
        /** The item doesn't exist. */
        return null;
    }

    /** Same as get, but use recursion. */
    public T getRecursive(int index) {
        return null;
    }

    /** get() by Recursion. This is the helper function. */
    public T getRecursiveHelper(int index) {
        return null;
    }

    /** Print the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            System.out.print(p.item);
            System.out.print(" ");
        }
    }

//    public static void main(String[] args) {
//        LinkedListDeque<Integer> L = new LinkedListDeque<>(3);
//        L.addFirst(2);
//        L.addFirst(1);
//        L.addLast(4);
//        L.addLast(3);
//        System.out.println(L.get(3));
//        L.printDeque();
//    }
}
