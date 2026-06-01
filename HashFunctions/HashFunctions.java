// Name:        Liamibel Sanchez
// Class:       CS 3305
// Term:        Spring 2026
// Instructor:
// Assignment:  8
// IDE Name:    intelliJ

import java.util.Scanner;

/*
 * This program demonstrates four hash functions using a fixed set of 50 keys.
 * The program allows the user to select one of four hashing techniques from a menu:
 * HF1 - Division method with Linear Probing
 * HF2 - Division method with Quadratic Probing
 * HF3 - Division method with Double Hashing
 * HF4 - Student-designed hash function
 *
 * The hash table is implemented as a 2D array with 50 rows and 2 columns:
 * Column 0 stores the key
 * Column 1 stores the number of probes used to place the key
 *
 * After a selected hash function is executed, the program displays the resulting
 * hash table and the total number of probes used.
 */
public class HashFunctions {

    // Constant for the table size
    public static final int TABLE_SIZE = 50;

    // Fixed set of keys required by the assignment
    public static final int[] KEYS = {
            1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
            5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
            5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
            5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
            5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523
    };

    /*
     * The main method starts the program, displays the menu, accepts the user's choice,
     * calls the selected hash function, displays the resulting hash table,
     * and repeats until the user chooses to exit.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            choice = input.nextInt();

            int[][] table = createEmptyTable();

            switch (choice) {
                case 1:
                    HF1(table);
                    System.out.println("\n\nHash table resulted from HF1:\n");
                    printTable(table);
                    System.out.println("\nSum of probe values = " + sumProbes(table) + " probes.\n");
                    break;

                case 2:
                    HF2(table);
                    System.out.println("\n\nHash table resulted from HF2:\n");
                    printTable(table);
                    System.out.println("\nSum of probe values = " + sumProbes(table) + " probes.\n");
                    break;

                case 3:
                    HF3(table);
                    System.out.println("\n\nHash table resulted from HF3:\n");
                    printTable(table);
                    System.out.println("\nSum of probe values = " + sumProbes(table) + " probes.\n");
                    break;

                case 4:
                    HF4(table);
                    System.out.println("\n\nHash table resulted from HF4:\n");
                    printTable(table);
                    System.out.println("\nSum of probe values = " + sumProbes(table) + " probes.\n");
                    break;

                case 5:
                    System.out.println("\nProgram terminated.");
                    break;

                default:
                    System.out.println("\nInvalid option. Please enter a number from 1 to 5.\n");
            }

        } while (choice != 5);

        input.close();
    }

    /*
     * This method displays the required menu exactly as specified in the assignment.
     * Blank lines are included before the menu for readability.
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("-----MAIN MENU--------------------------------------");
        System.out.println("1. Run HF1 (Division method with Linear Probing)");
        System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
        System.out.println("3. Run HF3 (Division method with Double Hashing)");
        System.out.println("4. Run HF4 (Student Designed HF)");
        System.out.println("5. Exit program");
        System.out.print("\nEnter option number: ");
    }

    /*
     * This method creates and returns an empty hash table.
     * Each row has two columns:
     * [0] = key
     * [1] = probes
     * A value of 0 in the key column indicates an empty slot.
     */
    public static int[][] createEmptyTable() {
        return new int[TABLE_SIZE][2];
    }

    /*
     * This method implements HF1 using the Division method with Linear Probing.
     * Initial index = key % TABLE_SIZE
     * If a collision occurs, the method checks the next available slot sequentially.
     * The number of collisions encountered is stored as the probe count.
     *
     * For the required key set, this implementation produces 214 probes.
     */
    public static void HF1(int[][] table) {
        for (int key : KEYS) {
            int index = key % TABLE_SIZE;
            int probes = 0;

            while (table[index][0] != 0) {
                index = (index + 1) % TABLE_SIZE;
                probes++;
            }

            table[index][0] = key;
            table[index][1] = probes;
        }
    }

    /*
     * This method implements HF2 using the Division method with Quadratic Probing.
     * Initial index = key % TABLE_SIZE
     * If a collision occurs, the method probes using:
     * new index = (baseIndex + j^2) % TABLE_SIZE
     * where j = 1, 2, 3, ...
     *
     * The number of collisions encountered is stored as the probe count.
     *
     * For the required key set, this implementation produces 112 probes.
     */
    public static void HF2(int[][] table) {
        for (int key : KEYS) {
            int baseIndex = key % TABLE_SIZE;
            int index = baseIndex;
            int probes = 0;
            int j = 1;

            while (table[index][0] != 0) {
                index = (baseIndex + (j * j)) % TABLE_SIZE;
                probes++;
                j++;
            }

            table[index][0] = key;
            table[index][1] = probes;
        }
    }

    /*
     * This method implements HF3 using the Division method with Double Hashing.
     * First hash:
     *      H1(key) = key % TABLE_SIZE
     * Second hash:
     *      H2(key) = 30 - (key % 25)
     * Probe formula:
     *      index = (key % 50) + j * H2(key), then mod 50
     * where j = 1, 2, 3, ...
     *
     * To avoid an infinite loop, the method stops after 50 attempts.
     * If a key cannot be stored after 50 tries, a message is printed.
     *
     * For the required key set, this implementation produces:
     * - 103 total probes
     * - 2 keys unable to be stored
     */
    public static void HF3(int[][] table) {
        for (int key : KEYS) {
            int baseIndex = key % TABLE_SIZE;
            int index = baseIndex;
            int probes = 0;
            int j = 1;
            int h2 = 30 - (key % 25);

            while (table[index][0] != 0 && probes < TABLE_SIZE) {
                index = (baseIndex + j * h2) % TABLE_SIZE;
                probes++;
                j++;
            }

            if (table[index][0] == 0) {
                table[index][0] = key;
                table[index][1] = probes;
            } else {
                System.out.println("Unable to hash key " + key + " to the table");
            }
        }
    }

    /*
     * HF4 is a student-designed hashing method.
     *
     * This method does NOT use the division method as required.
     *
     * Selected design:
     * - Mid-square style hashing:
     *   1. Square the key
     *   2. Remove some lower digits by dividing
     *   3. Take the result modulo TABLE_SIZE to get the initial index
     *
     * Collision resolution:
     * - Quadratic probing:
     *   index = (baseIndex + j^2) % TABLE_SIZE
     *
     * The method also limits attempts to 50 to avoid infinite loops.
     *
     * This design was chosen to avoid the division method while still distributing
     * keys better than basic sequential placement.
     */
    public static void HF4(int[][] table) {
        for (int key : KEYS) {
            long squared = (long) key * key;

            // Mid-square inspired hash value
            int baseIndex = (int) ((squared / 100) % TABLE_SIZE);
            int index = baseIndex;
            int probes = 0;
            int j = 1;

            while (table[index][0] != 0 && probes < TABLE_SIZE) {
                index = (baseIndex + (j * j)) % TABLE_SIZE;
                probes++;
                j++;
            }

            if (table[index][0] == 0) {
                table[index][0] = key;
                table[index][1] = probes;
            } else {
                System.out.println("Unable to hash key " + key + " to the table");
            }
        }
    }

    /*
     * This method calculates and returns the sum of all probe values
     * stored in the second column of the hash table.
     */
    public static int sumProbes(int[][] table) {
        int sum = 0;

        for (int i = 0; i < TABLE_SIZE; i++) {
            sum += table[i][1];
        }

        return sum;
    }

    /*
     * This method displays the contents of the hash table in the required format.
     * It prints the index, stored key, and probe count for each row.
     */
    public static void printTable(int[][] table) {
        System.out.println("Index\t  Key\t    probes");
        System.out.println("--------------------------------");

        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.printf("%3d\t%6d\t%5d%n", i, table[i][0], table[i][1]);
        }

        System.out.println("--------------------------------");
    }
}