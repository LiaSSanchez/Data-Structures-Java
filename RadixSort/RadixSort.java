// Name:          Your Name
// Class:         CS 3305
// Term:          Spring 2026
// Instructor:    Lingyan Wang
// Assignment:    5
// IDE Name:      IntelliJ IDEA

import java.util.Scanner;

/**
 * RadixSort program that sorts positive integers using queues.
 * This program uses ONE integer array (inputs) and ONE set of 10 queues (Q0...Q9).
 * All digit extraction is done mathematically (no string manipulation for sorting).
 */
public class RadixSort {

    /**
     * Displays the main menu.
     */
    public static void displayMenu() {
        System.out.println();
        System.out.println("---------------MAIN MENU---------------");
        System.out.println("1 – Read array size");
        System.out.println("2 – Read array values");
        System.out.println("3 – Run Radix Sort and print outputs");
        System.out.println("4 – Exit program");
        System.out.println();
        System.out.print("Enter option number: ");
    }

    /**
     * Counts how many digits are in a non-negative integer.
     * Example: 0 -> 1 digit, 7 -> 1 digit, 45 -> 2 digits, 3465 -> 4 digits.
     *
     * @param number non-negative integer
     * @return number of digits
     */
    public static int CountDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    /**
     * Extracts the digit at a given position from a non-negative integer.
     * position 0 = ones digit, position 1 = tens digit, etc.
     *
     * @param number   non-negative integer
     * @param position digit position (0 for ones, 1 for tens, ...)
     * @return extracted digit (0..9)
     */
    public static int ExtractDigit(int number, int position) {
        int divisor = 1;
        for (int i = 0; i < position; i++) {
            divisor *= 10;
        }
        return (number / divisor) % 10;
    }

    /**
     * Sends a value into the correct queue based on the digit (0..9).
     */
    public static void enqueueByDigit(int digit, int value,
                                      Queue<Integer> Q0, Queue<Integer> Q1, Queue<Integer> Q2, Queue<Integer> Q3, Queue<Integer> Q4,
                                      Queue<Integer> Q5, Queue<Integer> Q6, Queue<Integer> Q7, Queue<Integer> Q8, Queue<Integer> Q9) {

        switch (digit) {
            case 0: Q0.enqueue(value); break;
            case 1: Q1.enqueue(value); break;
            case 2: Q2.enqueue(value); break;
            case 3: Q3.enqueue(value); break;
            case 4: Q4.enqueue(value); break;
            case 5: Q5.enqueue(value); break;
            case 6: Q6.enqueue(value); break;
            case 7: Q7.enqueue(value); break;
            case 8: Q8.enqueue(value); break;
            case 9: Q9.enqueue(value); break;
            default:
                // Should never happen for radix digits
                break;
        }
    }

    /**
     * Dequeues all queues in order Q0..Q9 back into the inputs array.
     */
    public static void rebuildArrayFromQueues(int[] inputs,
                                              Queue<Integer> Q0, Queue<Integer> Q1, Queue<Integer> Q2, Queue<Integer> Q3, Queue<Integer> Q4,
                                              Queue<Integer> Q5, Queue<Integer> Q6, Queue<Integer> Q7, Queue<Integer> Q8, Queue<Integer> Q9) {

        int index = 0;

        while (!Q0.isEmpty()) inputs[index++] = Q0.dequeue();
        while (!Q1.isEmpty()) inputs[index++] = Q1.dequeue();
        while (!Q2.isEmpty()) inputs[index++] = Q2.dequeue();
        while (!Q3.isEmpty()) inputs[index++] = Q3.dequeue();
        while (!Q4.isEmpty()) inputs[index++] = Q4.dequeue();
        while (!Q5.isEmpty()) inputs[index++] = Q5.dequeue();
        while (!Q6.isEmpty()) inputs[index++] = Q6.dequeue();
        while (!Q7.isEmpty()) inputs[index++] = Q7.dequeue();
        while (!Q8.isEmpty()) inputs[index++] = Q8.dequeue();
        while (!Q9.isEmpty()) inputs[index++] = Q9.dequeue();
    }

    /**
     * Converts an int array to a comma-separated string for printing.
     * (This is ONLY for printing output; sorting is not done using strings.)
     */
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Main method begins program execution.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ONE array only (per assignment)
        int[] inputs = null;
        int size = 0;

        boolean sizeRead = false;
        boolean valuesRead = false;

        // ONE set of Queue objects only (Q0...Q9)
        Queue<Integer> Q0 = new Queue<>();
        Queue<Integer> Q1 = new Queue<>();
        Queue<Integer> Q2 = new Queue<>();
        Queue<Integer> Q3 = new Queue<>();
        Queue<Integer> Q4 = new Queue<>();
        Queue<Integer> Q5 = new Queue<>();
        Queue<Integer> Q6 = new Queue<>();
        Queue<Integer> Q7 = new Queue<>();
        Queue<Integer> Q8 = new Queue<>();
        Queue<Integer> Q9 = new Queue<>();

        int choice = 0;

        // Sentinel loop
        while (choice != 4) {

            displayMenu();
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    // Read array size
                    System.out.print("Enter array size (positive integer): ");
                    size = input.nextInt();

                    while (size <= 0) {
                        System.out.print("Invalid size. Enter a positive integer: ");
                        size = input.nextInt();
                    }

                    inputs = new int[size];   // allocate the ONE array
                    sizeRead = true;
                    valuesRead = false;       // reset because values must be re-entered if size changes
                    break;

                case 2:
                    // Read array values
                    if (!sizeRead) {
                        System.out.println("Please select option 1 first to read array size.");
                        break;
                    }

                    System.out.println("Enter " + size + " non-negative integer value(s):");

                    for (int i = 0; i < size; i++) {
                        System.out.print("Value " + (i + 1) + ": ");
                        int val = input.nextInt();

                        // Reject negatives
                        while (val < 0) {
                            System.out.print("Negative not allowed. Re-enter Value " + (i + 1) + ": ");
                            val = input.nextInt();
                        }

                        inputs[i] = val;
                    }

                    valuesRead = true;
                    break;

                case 3:
                    // Run Radix Sort and print outputs
                    if (!sizeRead || !valuesRead || inputs == null) {
                        System.out.println("Please complete option 1 (size) and option 2 (values) first.");
                        break;
                    }

                    // Copy original array into a STRING before sorting (required for outputs)
                    String before = arrayToString(inputs);

                    // Find max digits among all inputs
                    int maxDigits = 1;
                    for (int i = 0; i < inputs.length; i++) {
                        int d = CountDigits(inputs[i]);
                        if (d > maxDigits) {
                            maxDigits = d;
                        }
                    }

                    // Radix Sort: process digit positions from 0 (ones) to maxDigits-1
                    for (int position = 0; position < maxDigits; position++) {

                        // Distribute into queues by current digit
                        for (int i = 0; i < inputs.length; i++) {
                            int digit = ExtractDigit(inputs[i], position);
                            enqueueByDigit(digit, inputs[i],
                                    Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9);
                        }

                        // Collect back into inputs in order Q0...Q9
                        rebuildArrayFromQueues(inputs, Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9);
                    }

                    // Print outputs
                    System.out.println("Array values before sorting:    " + before);
                    System.out.println("Array values after sorting:     " + arrayToString(inputs));
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }
}