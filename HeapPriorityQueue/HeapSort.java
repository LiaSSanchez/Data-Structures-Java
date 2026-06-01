// Name: liamibel Sanchez
// Class: CS 3305
// Term: Spring 2026
// Instructor: Lingyan Wang
// Assignment: 7
// IDE Name: IntelliJ

public class HeapSort {
   /** Heap sort method */
   public static <E extends Comparable<E>> void heapSort(E[] list) {
      // Create a Heap of integers
      Heap<E> heap = new Heap<E>();
   
      // Add elements to the heap
      for (int i = 0; i < list.length; i++)
         heap.add(list[i]);
   
      // Remove elements from the heap
      for (int i = list.length - 1; i >= 0; i--)
         list[i] = heap.remove();
   }
}
