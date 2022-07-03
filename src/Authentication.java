package src;

import java.util.Scanner;

public class Authentication {

    private static String[] login = new String[] { "alex21", "irina_s", "sup"};
    private static String[] password = new String[] { "123", "4563", "awdsc32"};
    private static int authSuccess = -1;
    private static String username = null;

    public Authentication() {
        authSuccess = authenticate();
    }

    private static int authenticate() {
        Scanner s = new Scanner(System.in);

        boolean isLoginSuccess = false;

        for (int maxCount = 0; maxCount < 5 && !isLoginSuccess; maxCount++) {
            System.out.print("Login: ");
            var loginIn = s.nextLine();

            System.out.print("Password: ");
            var passwordIn = s.nextLine();

            for (int i = 0; i < login.length; i++) {
                if (loginIn.equals(login[i]) && passwordIn.equals(password[i])) {
                    isLoginSuccess = true;
                    break;
                }
            }

            username = isLoginSuccess ? loginIn : null;
        }
        return isLoginSuccess ? 0 : -1;
    }

    public int getAuthSuccess() {
        return authSuccess;
    }

    public String getUsername() {
        return username;
    }
}
