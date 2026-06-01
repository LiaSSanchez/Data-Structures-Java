// Name: liamibel Sanchez
// Class: CS 3305
// Term: Spring 2026
// Instructor: Lingyan Wang
// Assignment: 7
// IDE Name: IntelliJ

import java.util.Scanner;

public class TestPQH {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PQ_heap<Integer> intQueue = null;
        PQ_heap<String> stringQueue = null;

        boolean queueTypeSelected = false;
        int queueType = -1;
        int option;

        do {
            System.out.println("\n----------------MAIN MENU---------------");
            System.out.println("0. Enter Queue Type (integer or string)");
            System.out.println("1. Enqueue Element");
            System.out.println("2. Dequeue Element");
            System.out.println("3. Check is_Full");
            System.out.println("4. Check is_Empty");
            System.out.println("5. Print PQueue Size");
            System.out.println("6. Display Front Element");
            System.out.println("7. Print PQueue Elements");
            System.out.println("8. Exit program");
            System.out.print("Enter option number: ");

            option = input.nextInt();
            input.nextLine();

            if (!queueTypeSelected && option != 0 && option != 8) {
                System.out.println("\nYou must start with option 0 and select a queue type first.");
                continue;
            }

            switch (option) {
                case 0:
                    System.out.print("\nEnter queue type (1 for integer, 2 for string): ");
                    queueType = input.nextInt();
                    input.nextLine();

                    if (queueType == 1) {
                        intQueue = new PQ_heap<>();
                        stringQueue = null;
                        queueTypeSelected = true;
                        System.out.println("Integer priority queue selected.");
                    } else if (queueType == 2) {
                        stringQueue = new PQ_heap<>();
                        intQueue = null;
                        queueTypeSelected = true;
                        System.out.println("String priority queue selected.");
                    } else {
                        System.out.println("Invalid queue type.");
                    }
                    break;

                case 1:
                    System.out.println("\nTesting method Enqueue Element (Option 1)");
                    if (queueType == 1) {
                        System.out.print("Enter integer to enqueue: ");
                        int intValue = input.nextInt();
                        input.nextLine();
                        intQueue.enqueue(intValue);
                        System.out.println("Element enqueued.");
                    } else {
                        System.out.print("Enter string to enqueue: ");
                        String strValue = input.nextLine();
                        stringQueue.enqueue(strValue);
                        System.out.println("Element enqueued.");
                    }
                    break;

                case 2:
                    System.out.println("\nTesting method Dequeue Element (Option 2)");
                    if (queueType == 1) {
                        if (intQueue.is_empty()) {
                            System.out.println("Priority queue is empty.");
                        } else {
                            System.out.println("Dequeued element: " + intQueue.dequeue());
                        }
                    } else {
                        if (stringQueue.is_empty()) {
                            System.out.println("Priority queue is empty.");
                        } else {
                            System.out.println("Dequeued element: " + stringQueue.dequeue());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nTesting method Check is_Full (Option 3)");
                    if (queueType == 1) {
                        System.out.println("PQueue is full: " + intQueue.is_full());
                    } else {
                        System.out.println("PQueue is full: " + stringQueue.is_full());
                    }
                    break;

                case 4:
                    System.out.println("\nTesting method Check is_Empty (Option 4)");
                    if (queueType == 1) {
                        System.out.println("PQueue is empty: " + intQueue.is_empty());
                    } else {
                        System.out.println("PQueue is empty: " + stringQueue.is_empty());
                    }
                    break;

                case 5:
                    System.out.println("\nTesting method Print PQueue Size (Option 5)");
                    if (queueType == 1) {
                        System.out.println("PQueue size: " + intQueue.size());
                    } else {
                        System.out.println("PQueue size: " + stringQueue.size());
                    }
                    break;

                case 6:
                    System.out.println("\nTesting method Display Front Element (Option 6)");
                    if (queueType == 1) {
                        if (intQueue.is_empty()) {
                            System.out.println("Priority queue is empty.");
                        } else {
                            System.out.println("Front element: " + intQueue.front());
                        }
                    } else {
                        if (stringQueue.is_empty()) {
                            System.out.println("Priority queue is empty.");
                        } else {
                            System.out.println("Front element: " + stringQueue.front());
                        }
                    }
                    break;

                case 7:
                    System.out.println("\nTesting method Print PQueue Elements (Option 7)");
                    if (queueType == 1) {
                        intQueue.printPQueue();
                    } else {
                        stringQueue.printPQueue();
                    }
                    break;

                case 8:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 8);

        input.close();
    }
}