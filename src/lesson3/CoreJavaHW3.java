package lesson3;

public class CoreJavaHW3 {
    public static void main(String[] args) {
        System.out.println("1. Create an array and fill it with 2 number.");

        int[] numbersTwo = new int[10];
        for (int i = 0; i < numbersTwo.length; i++) {
            numbersTwo[i] = 2;
        }

        System.out.println("2. Create an array and fill it with numbers from 1:1000.");

        int[] from1to1000 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            from1to1000[i] = i + 1;
        }

        System.out.println("3. Create an array and fill it with odd numbers from -20:20.");

        int[] oddNumbersTo20 = new int[20];
        for (int i = 0, num = -19; i < oddNumbersTo20.length; i++, num += 2) {
            oddNumbersTo20[i] = num;
        }

        System.out.println("4. Create an array and fill it. Print all elements which can be divided by 5.\n");

        int[] arrayOfNumbers = {5, 0, 1, -22, 50, 25, 255, -75, 465, -10, 999, 980};
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] % 5 == 0) {
                System.out.println(arrayOfNumbers[i]);
            }
        }

        System.out.println("\n5. Create an array and fill it. Print all elements which are between 24.12 and 467.23.");

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] > 24.12 && arrayOfNumbers[i] < 467.23) {
                System.out.println(arrayOfNumbers[i]);
            }
        }

        System.out.println("\n6. Create an array and fill it. Print count of elements which can be divided by 2.");

        int counter = 0;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.println("Count of elements divisible by 2: " + counter);

        System.out.println("\n7. Given an integer, 0< N < 21 , print its first 10 multiples.\n");

        int n = 2;
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}
