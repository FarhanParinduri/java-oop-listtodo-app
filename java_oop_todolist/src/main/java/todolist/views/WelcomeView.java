package todolist.views;

import java.util.Scanner;

public class WelcomeView {
    public static void main(String[] args) {
        ShowWelcomeView();
    }

    public static void ShowWelcomeView() {
        Scanner inputScanner = new Scanner(System.in);


        System.out.println("Welcome to My Todo List Apps");
        System.out.println("============================");
        System.out.println();
        System.out.println("[1] - Login Page");
        System.out.println("[2] - Create Account");
        System.out.println("[0] - Exit");
        System.out.println();
        System.out.println("Input Menu (Number): ");
        Integer menu = inputScanner.nextInt();  

        switch (menu) {
            case 1:
                System.out.println("go to menu Login");
                break;
            case 2:
                UserView.ShowUserMain();
                System.out.println("Go to User View");
                break;
            case 3:
                System.out.println("Application Closed!");
                break;
        }

        inputScanner.close();
    }
    
}
