package eg.edu.alexu.csd.datastructure.queue.cs44_cs42_cs65;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author Muhammad Salah
 *
 */
public class QueueArrayBased implements IQueue, IArrayBased {
    /**
     *
     */
    private int max = 0;
    /**
     *
     */
    private Object[] arr = null;
    /**
     *
     */
    private int f = 0;
    /**
     *
     */
    private int r = 0;
    /**
     *
     */
    private int size = 0;
    /**
     *
     */
    public QueueArrayBased() {
    }
    /**
     * @param n max index
     */
    QueueArrayBased(final int n) {
        arr = new Object[n];
        max = n;
    }
    /**
     *
     */
    @Override
    public void enqueue(final Object item) {
        if (size == max) {
            throw new RuntimeException();
        }
        arr[r] = item;
        r++;
        size++;
        if (r == max) {
            r = 0;
        }
    }
   /**
    *
    */
    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new RuntimeException();
        }
        Object obj = arr[f];
        f++;
        size--;
        if (f == max) {
            f = 0;
        }
        return obj;
    }
   /**
    *
    */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
   /**
    *
    */
    @Override
    public int size() {
        return size;
    }

}