// Name: liamibel Sanchez
// Class: CS 3305
// Term: Spring 2026
// Instructor: Lingyan Wang
// Assignment: 7
// IDE Name: IntelliJ

public class TestHeapSort {

   public static void main(String[] args) {

      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
      Character[] list2 = {'w', 'f', 'A', 'X', 'T', 'Q', 'k', 's', '8', 'L', '3', 'b', 'A', 'w', 's', 'H', 'j', 'K', 'L'};
      String[] list3 = {"Data", "Structure", "Is", "Hard", "Computing", "Class", "To Pass"};

      System.out.print("Original Integer List:\t");
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");

      HeapSort.heapSort(list);

      System.out.print("\n\nSorted Integer List:\t");
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");

      System.out.print("\n\nOriginal Character List:\t");
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");

      HeapSort.heapSort(list2);

      System.out.print("\n\nSorted Character List:\t");
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");

      System.out.print("\n\nOriginal String List:\t");
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");

      HeapSort.heapSort(list3);

      System.out.print("\n\nSorted String List:\t");
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");
   }
}