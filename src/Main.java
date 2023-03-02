public class Main {
    public static void main(String[] args) {

        Solution demo = new Solution();
        // initialise the required reference tables
        demo.initializeTables();

        // encode text
        // for this implementation, offset char is included as first element in the input string
        String encodedText = demo.encode("FHELLO WORLD");
        System.out.println(encodedText);

        // decode text
        // for this implementation, offset char is included as first element in the input string
        String decodedText = demo.decode("FC/GGJ RJMG.");
        System.out.println(decodedText);
    }
}