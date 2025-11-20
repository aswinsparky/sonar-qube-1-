public class Main {

    public static void main(String[] args) {
        // Using a logger is possible in real apps, but System.out is fine for simple demos

        int score = 100;
        if (score > 50) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }

        String userInput = "something";
        if ("something".equals(userInput)) {
            System.out.println("User input matches!");
        }

        String username = "baduser";
        String query = String.format(
            "SELECT * FROM accounts WHERE username = ? AND password = ?"
        );
        System.out.println("Prepared query: " + query);

        try {
            int x = 10 / 2;
            System.out.println("Computation result: " + x);
        } catch (ArithmeticException ex) {
            System.out.println("Computation error: " + ex.getMessage());
        }
    }
}
