// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Creates a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        rb = (T[])new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount == capacity) { /* If array is full, throw an exception. */
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        /* If last = capacity, it would be 0, that is , the last pointer will skip to the index 0!
        Otherwise, last just steps to the next index! */
        last = (last + 1) % capacity;

        fillCount = fillCount + 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) { /* If array is empty, throw an exception. */
            throw new RuntimeException("Ring buffer underflow");
        }
        /* Finds out the oldest element in this array. */
        T result = rb[first];
        /* Deletes the oldest element in this array. */
        rb[first] = null;
        /* If first = capacity, it would be 0, that is, the first pointer will skip to the index 0!
        Otherwise, first just steps to the next index! */
        first = (first + 1) % capacity;

        fillCount = fillCount - 1;
        /* Returns the oldest element in this array. */
        return result;
    }

    /**
     * Returns oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (isEmpty()) { // If the array is empty, throw an exception.
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class BufferIterator implements Iterator<T> {
        private int pointer;

        public BufferIterator() {
            pointer = 0;
        }

        @Override
        public boolean hasNext() {
            return pointer < fillCount();
        }

        @Override
        public T next() {
            T res = rb[pointer];
            pointer = pointer + 1;
            return res;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }
}
