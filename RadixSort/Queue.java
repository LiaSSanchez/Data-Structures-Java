// Name:          Your Name
// Class:         CS 3305
// Term:          Spring 2026
// Instructor:    Lingyan Wang
// Assignment:    5
// IDE Name:      IntelliJ IDEA

/**
 * Generic Queue class implemented using a linked list.
 * This class provides basic queue operations such as enqueue,
 * dequeue, front, size, isEmpty, and printQueue.
 */

public class Queue<E> {

    /**
     * Private Node class to represent each element in the queue.
     */
    private class Node {
        E data;
        Node next;

        /**
         * Constructor to create a new node.
         * @param data The data stored in the node.
         */
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;   // Points to first element
    private Node rear;    // Points to last element
    private int size;     // Number of elements in queue

    /**
     * Constructor initializes an empty queue.
     */
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Adds a new element to the rear of the queue.
     * @param e The element to be added.
     */
    public void enqueue(E e) {
        Node newNode = new Node(e);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    /**
     * Removes and returns the front element of the queue.
     * @return The removed element, or null if queue is empty.
     */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E removedData = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return removedData;
    }

    /**
     * Returns the front element without removing it.
     * @return The front element, or null if queue is empty.
     */
    public E front() {
        if (isEmpty()) {
            return null;
        }

        return front.data;
    }

    /**
     * Returns the number of elements in the queue.
     * @return The size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the queue is empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints all elements in the queue from front to rear.
     */
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }

        Node current = front;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }
}