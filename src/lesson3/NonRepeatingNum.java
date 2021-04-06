package lesson3;

public class NonRepeatingNum {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 1, 2, 5, 9, 5, 9, 10, 6, 6};
        int num = 0;
        for (int i = 0; i < numbers.length; i++)
            num ^= numbers[i]; // numbers that repeat will cancel out

        // solution is right assuming we don't have zeros in the array
        if (num != 0)
          System.out.println("The unique number is " + num);
        else
            System.out.println("Each number has its pair!");
    }
}
