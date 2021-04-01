package lesson2;

public class coreJavaHW2 {
    // arrays
    public static void main(String[] args) {
        int[] numbers = {2, 3, 6, 3, 6, 9};
        numbers[0]++; // postfix increment (same for decrement)
        --numbers[1]; // prefix decrement (same for increment)
        // another way to initialize an array
        String[] colors = new String[3];
        colors[0] = "red";
        colors[1] = "green";
        colors[2] = "blue";
        // yet another way to initialize an array
        double[] rationalNumbers = new double[]{2.2, 3.3, 9.5};
        // find the number that doesn't have a pair

        // find max number
        double maxNumber = rationalNumbers[0];
        if (rationalNumbers[1] > maxNumber) {
            maxNumber = rationalNumbers[1];
        }
        // unless you have more than one statement, not using brackets is fine
        if (maxNumber > rationalNumbers[2]) maxNumber = rationalNumbers[2];

        // we can use ternary operator for simple operations
        final int ln = numbers.length - 1; // const
        boolean isLastNumberEven = numbers[ln] % 2 == 0 ? true : false;

        if (!isLastNumberEven) {
            numbers[ln] *= 2; // make it even with the assignment operator
            // determine if a number is power of 2 using Bitwise & operator
            if ((numbers[ln] & numbers[ln]-1) == 0) {
                System.out.println("Some Math Magic");
            } else {
                System.out.println("Second class number. Setting it to zero.");
                numbers[ln] = numbers[ln] ^ numbers[ln];
            }
        }
    }
}
