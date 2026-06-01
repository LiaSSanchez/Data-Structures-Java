// Name: liamibel Sanchez
// Class: CS 3305
// Term: Spring 2026
// Instructor: Lingyan Wang
// Assignment: 7
// IDE Name: IntelliJ

public class PQ_heap<E extends Comparable<E>> {

    private Heap<E> heap;
    private static final int CAPACITY = 100;

    // Constructor method
    public PQ_heap() {
        heap = new Heap<>();
    }

    // Return true if priority queue is empty; otherwise return false
    public boolean is_empty() {
        return heap.getSize() == 0;
    }

    // Return true if priority queue is full; otherwise return false
    public boolean is_full() {
        return heap.getSize() >= CAPACITY;
    }

    // Return (don't remove) the front element from the priority queue
    // Precondition: priority queue is not empty.
    public E front() {
        if (is_empty()) {
            return null;
        }

        E top = heap.remove();
        heap.add(top);
        return top;
    }

    // Return number of elements in the queue
    public int size() {
        return heap.getSize();
    }

    // Remove the largest value from this priority queue and return it.
    // Precondition: priority queue is not empty.
    public E dequeue() {
        if (is_empty()) {
            return null;
        }

        return heap.remove();
    }

    // Inserts the value into the priority queue.
    // Precondition: priority queue is not full
    public void enqueue(E value) {
        if (!is_full()) {
            heap.add(value);
        }
    }

    // Print the priority queue elements in heap format
    public void printPQueue() {
        if (is_empty()) {
            System.out.println("Priority queue is empty.");
            return;
        }

        for (int i = 0; i < heap.getSize(); i++) {
            System.out.print("Index " + i + ": " + heap.getElement(i));

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < heap.getSize()) {
                System.out.print(" " + heap.getElement(left));
            }

            if (right < heap.getSize()) {
                System.out.print(" " + heap.getElement(right));
            }

            System.out.println();
        }
    }
}