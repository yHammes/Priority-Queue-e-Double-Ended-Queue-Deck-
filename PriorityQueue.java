import java.util.ArrayList;

/**
 * Simple Priority Queue (Min-Heap) for integers.
 * Smallest number has highest priority.
 *
 * How it works: binary heap stored in ArrayList
 *   parent = (i-1)/2 , left = 2*i+1 , right = 2*i+2
 */
public class PriorityQueue {

    private ArrayList<Integer> heap = new ArrayList<>();

    // Add element
    public void push(int value) {
        heap.add(value);
        siftUp(heap.size() - 1);
    }

    // Remove and return smallest element
    public int pop() {
        if (isEmpty()) throw new RuntimeException("PriorityQueue is empty");
        int top = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return top;
    }

    // See smallest without removing
    public int peek() {
        if (isEmpty()) throw new RuntimeException("PriorityQueue is empty");
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void clear() {
        heap.clear();
    }

    // Move element up to correct position
    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                swap(i, parent);
                i = parent;
            } else break;
        }
    }

    // Move element down to correct position
    private void siftDown(int i) {
        int n = heap.size();
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < n && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < n && heap.get(right) < heap.get(smallest)) smallest = right;

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
