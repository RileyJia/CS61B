package synthesizer;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 3;
        last = first;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */

    @Override
    public void enqueue(T x) {
        if (!isFull()){
            rb[last] = x;
            fillCount++;
            if(last == this.capacity - 1){
                last = 0;
            }else last ++;
        }else throw new IllegalArgumentException("Ring Buffer Overflow");
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if(!isEmpty()){
            T removedItem = rb[first];
            rb[first] = null;
            fillCount--;
            if (first == this.capacity - 1){
                first = 0;
            }else first++;
            return removedItem;
        }else throw new IllegalArgumentException("Ring Buffer Underflow");
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if(!isEmpty()){
            return rb[first];
        }else throw new IllegalArgumentException("Ring Buffer Underflow");
    }

    public class myIterator implements Iterator<T>{
        private int num;

        public myIterator(){
            num = 0;
        }

        public boolean hasNext(){
            return num < capacity;
        }

        public T next(){
            T thisOne = rb[num];
            num++;
            return thisOne;
        }

    }
    public Iterator<T> iterator(){
        return new myIterator();
    }
}
