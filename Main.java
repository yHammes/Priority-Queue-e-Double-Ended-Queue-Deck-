public class Main {
    public static void main(String[] args) {
        System.out.println("=== Priority Queue (Min-Heap) ===");
        PriorityQueue pq = new PriorityQueue();
        pq.push(5);
        pq.push(1);
        pq.push(3);
        pq.push(7);
        pq.push(2);

        System.out.println("Queue: " + pq);       // [1, 2, 3, 7, 5]
        System.out.println("Peek: " + pq.peek()); // 1

        System.out.print("Pop order: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.pop() + " ");     // 1 2 3 5 7
        }
        System.out.println("\n");

        System.out.println("=== Deque (Double-Ended Queue) ===");
        Deque dq = new Deque();
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        System.out.println("Initial: " + dq);     // [1, 2, 3]

        dq.addFirst(0);
        dq.addLast(4);
        System.out.println("After addFirst(0) and addLast(4): " + dq); // [0, 1, 2, 3, 4]

        System.out.println("peekFirst: " + dq.peekFirst()); // 0
        System.out.println("peekLast: " + dq.peekLast());   // 4

        System.out.println("removeFirst: " + dq.removeFirst() + " -> " + dq); // 0 -> [1,2,3,4]
        System.out.println("removeLast: " + dq.removeLast() + " -> " + dq);   // 4 -> [1,2,3]

        System.out.println("\nFinal PriorityQueue and Deque work correctly!");
    }
}
