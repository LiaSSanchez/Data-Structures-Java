// Name:          Your Name
// Class:         CS 3305
// Term:          Spring 2026
// Instructor:    Lingyan Wang
// Assignment:    5
// IDE Name:      IntelliJ IDEA

import java.util.Scanner;

/**
 * Test program for the generic Queue class.
 * This program allows the user to interactively test
 * enqueue, dequeue, front, size, isEmpty, and print operations.
 */

public class TestQueue {

    /**
     * Displays the main menu.
     */
    public static void displayMenu() {
        System.out.println();
        System.out.println("--------MAIN MENU--------");
        System.out.println("1 – Enqueue element");
        System.out.println("2 – Dequeue element");
        System.out.println("3 – Get front element");
        System.out.println("4 – get queue size");
        System.out.println("5 – Is Empty queue?");
        System.out.println("6 - Print queue");
        System.out.println("7 - Exit program");
        System.out.println();
        System.out.print("Enter option number: ");
    }

    /**
     * Main method begins program execution.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Queue<Integer> queue = new Queue<>();

        int choice = 0;

        // Sentinel loop
        while (choice != 7) {

            displayMenu();
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter integer to enqueue: ");
                    int value = input.nextInt();
                    queue.enqueue(value);
                    System.out.println("Element enqueued.");
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                    } else {
                        int removed = queue.dequeue();
                        System.out.println("Dequeued element: " + removed);
                    }
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                    } else {
                        System.out.println("Front element: " + queue.front());
                    }
                    break;

                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                    } else {
                        System.out.println("Queue size: " + queue.size());
                    }
                    break;

                case 5:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is NOT empty.");
                    }
                    break;

                case 6:
                    queue.printQueue();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }
}