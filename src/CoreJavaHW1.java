public class CoreJavaHW1 {
    public static void main(String[] args) {
        byte daysInMonth = 31; // 1 byte, min value: -128, max: 127
        short daysInYear = 365; // 2 bytes, min value: -32,768, max: 32767
        int pcsArtMAU = 180000000; // 4 bytes, min: -2^31, max: 2^31-1
        long someCrazyFactorial = 3333333333333333333L; // 8 bytes, min val: -2^63, max: 2^63-1

        double eulersNumber = 2.718281828459045D; // 8 bytes
        float pi = 3.145926F; // 4 bytes
        System.out.println(eulersNumber);

        char armLetter = 'Է'; // unicode 16
        String armWord = armLetter + "հեհեհեհե՜";
        // string concat
        System.out.println(armWord + " Java");

        boolean isJavaJavaScript = false;
    }
}
