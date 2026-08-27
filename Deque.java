/**
 * Simple Double-Ended Queue (Deque / Deck)
 * Implemented with Doubly Linked List.
 * Allows adding/removing from both ends in O(1).
 */
public class Deque {

    private static class Node {
        int value;
        Node prev, next;
        Node(int value) { this.value = value; }
    }

    private Node head; // front
    private Node tail; // back
    private int size = 0;

    // Add to front
    public void addFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // Add to back
    public void addLast(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // Remove from front
    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        int value = head.value;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return value;
    }

    // Remove from back
    public int removeLast() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        int value = tail.value;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return value;
    }

    // Peek front
    public int peekFirst() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        return head.value;
    }

    // Peek back
    public int peekLast() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        return tail.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value);
            if (cur.next != null) sb.append(", ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
