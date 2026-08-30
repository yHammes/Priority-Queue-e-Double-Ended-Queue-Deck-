import java.util.ArrayList;
import java.util.Collections;

 class PriorityQueue {
    static int parent(int i) { return (i - 1) / 2; }
    static int leftChild(int i) { return 2 * i + 1; }
    static int rightChild(int i) { return 2 * i + 2; }

    static void shiftUp(int i, ArrayList<Integer> arr) {
        while (i > 0 && arr.get(parent(i)) < arr.get(i)) {
            Collections.swap(arr, parent(i), i);
            i = parent(i);
        }
    }

    static void shiftDown(int i, ArrayList<Integer> arr, int size) {
        int maxIndex = i;
        int l = leftChild(i);
        if (l < size && arr.get(l) > arr.get(maxIndex)) maxIndex = l;
        int r = rightChild(i);
        if (r < size && arr.get(r) > arr.get(maxIndex)) maxIndex = r;

        if (i != maxIndex) {
            Collections.swap(arr, i, maxIndex);
            shiftDown(maxIndex, arr, size);
        }
    }

    static void insert(int priority, ArrayList<Integer> arr) {
        arr.add(priority);
        shiftUp(arr.size() - 1, arr);
    }

    static int pop(ArrayList<Integer> arr) {
        int size = arr.size();
        if (size == 0) return -1;
        int result = arr.get(0);
        arr.set(0, arr.get(size - 1));
        arr.remove(size - 1);
        shiftDown(0, arr, arr.size());
        return result;
    }

    static int getMax(ArrayList<Integer> arr) {
        if (arr.isEmpty()) return -1;
        return arr.get(0);
    }

    static void printHeap(ArrayList<Integer> arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();


        insert(45, list);
        insert(20, list);
        insert(14, list);
        insert(12, list);
        insert(31, list);
        insert(7, list);
        insert(11, list);
        insert(13, list);
        insert(7, list);

        System.out.print("Após inserts: ");
        printHeap(list);

        System.out.println("Maior elemento: " + getMax(list));

        pop(list);
        System.out.print("Após pop: ");
        printHeap(list);

    }
}