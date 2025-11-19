public class main {
    // Constant name does not follow convention
    public static final String pw = "ThisIsASecret!"; // Hardcoded password

    // Unused variable
    private int unused = 0;

    public static void main(String[] args) {
        String input = null;
        if (input.length() > 0) { // Possible NullPointerException
            System.out.println("Input is: " + input);
        }

        // Use of System.out instead of logger
        System.out.println("Hardcoded password is: " + pw);

        // Compromised password in code
        String compromisedPassword = "p@ssw0rd";
        System.out.println("Compromised password: " + compromisedPassword);

        // All code branches do the same thing
        int num = 10;
        if (num > 5) {
            System.out.println("Num is greater than 5");
        } else {
            System.out.println("Num is greater than 5");
        }
    }
}
