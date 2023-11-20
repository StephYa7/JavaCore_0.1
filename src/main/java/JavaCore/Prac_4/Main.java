package JavaCore.Prac_4;

import JavaCore.Prac_4.Task_01_Logger.WrongLoginException;
import JavaCore.Prac_4.Task_01_Logger.WrongPasswordException;
import JavaCore.Prac_4.Task_01_Logger.logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("Enter password: ");
        String pass = scanner.nextLine();
        System.out.println("Enter password: ");
        String confirmPass = scanner.nextLine();

        try {
            System.out.println(logger.checkLoginPassword(login, pass, confirmPass));
        } catch (WrongLoginException e) {
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            throw new RuntimeException(e);
        }

    }
}