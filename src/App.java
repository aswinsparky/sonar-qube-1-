public class main {
    // Hardcoded credentials (Sensitive data exposure)
    private static final String SECRET_KEY = "MySuperSecretKey123";
    public static final String pw = "ThisIsASecret!"; // Hardcoded password

    // Unused variable
    private int unused = 0;

    public static void main(String[] args) {
        String input = null;
        // NullPointerException possible (input is null)
        if (input.length() > 0) {
            System.out.println("Input is: " + input);
        }

        // Use of System.out instead of logger (Code quality issue)
        System.out.println("Hardcoded password is: " + pw);

        // Compromised password printed in logs (Sensitive info exposure)
        String compromisedPassword = "p@ssw0rd";
        System.out.println("Compromised password: " + compromisedPassword);

        // Redundant conditional branches (Code smell)
        int num = 10;
        if (num > 5) {
            System.out.println("Num is greater than 5");
        } else {
            System.out.println("Num is greater than 5");
        }

        // SQL injection risk: No parameterization in query (Vulnerability)
        String username = "user";
        String password = "pass";
        String query = "SELECT * FROM users WHERE name = '" + username + "' AND password = '" + password + "'";
        System.out.println("Query: " + query);
    }
}