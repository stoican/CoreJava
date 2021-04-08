package lesson4;

public class BubbleSort {
    public static void main(String[] args) {
       int[] numbers = {1, 9, 8, 100, 85, -1, 0, 999, 1000, 71, 17, 5, 75};

       int stage = 0;
       // worst case it will take n-2 iterations to sort the array
       while (stage < numbers.length - 2) {
           boolean swapped = false;
           for (int i = 0; i < numbers.length - stage - 1; i++) {
               if (!(numbers[i] > numbers[i + 1]))
                   continue;
               int tmp = numbers[i + 1];
               numbers[i + 1] = numbers[i];
               numbers[i] = tmp;
               swapped = true;
           }

           if (!swapped)
               break; // no swaps after one iteration => array is sorted
           stage++; // next iteration
       }

       for (int i = 0; i < numbers.length; i++) {
           System.out.print(numbers[i] + " ");
       }
    }
}
