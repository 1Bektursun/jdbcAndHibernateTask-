package peaksoft;

import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // реализуйте алгоритм здесь
        //Util.getConnection();
        UserServiceImpl userService = new UserServiceImpl();
        while(true){

            System.out.println("1. User-лерге таблица тузуу\n" +
                    "2. 4 user-ди базага кошуу. Ар бир user базага кошулгандан кийинанын аты - базага кошулду деп консольго чыгуусу керек\n" +
                    "3. Бардык user-лерди алуу жана консольго чыгаруу, toStringметодун override кылышыныз керек\n" +
                    "4. Таблицанын маалыматтарын очуруу\n" +
                    "5. Таблицаны очуруу\n" +
                    "Exit");

            String str = scanner.nextLine();

            if(str.equals("Exit"))
                break;

            switch (str){
                case "1":
                    userService.createUsersTable();
                    break;
                case "2":
                            userService.saveUser("Nurjigit","Malikov",(byte)24);
                            userService.saveUser("Alimbek","Nyshanov",(byte)19);
                            userService.saveUser("Dosboldu","Kanatbek uulu",(byte)25);
                            userService.saveUser("Ali","Kerimbekov",(byte)19);
                            break;
                case "3":
                    System.out.println(userService.getAllUsers());
                    break;
                case "4":
                    userService.cleanUsersTable();
                    break;
                case "5":
                    userService.dropUsersTable();
                    break;
                default:
                    System.out.println("Choose another menu!");
            }
        }
    }
}
