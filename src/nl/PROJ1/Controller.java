public class Controller {

    private static int screenNumber = 1;

    public static void start() {
        checkScreen();
    }

    private static void checkScreen() {

        switch (screenNumber) {
            case 0 -> System.out.println("Exit");
            case 1 -> screenLogin();
            case 2 -> screenUserPortal();
            case 3 -> screenAdminPortal();
        }
    }

    private static void screenLogin() {
        //screenNumber = Login.startLogin();
        checkScreen();
    }

    private static void screenUserPortal() {
        //screenNumber = UserPortal.startUserPortal();
        checkScreen();
    }

    private static void screenAdminPortal() {
        //screenNumber = AdminPortal.startAdminPortal();
        checkScreen();
    }
}