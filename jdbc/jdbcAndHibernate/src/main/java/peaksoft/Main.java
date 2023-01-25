package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.model.User;
import peaksoft.service.UserHibernateService;
import peaksoft.service.UserHibernateServiceImpl;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // реализуйте алгоритм здесь
        //Util.getConnection();

       // UserServiceImpl userService = new UserServiceImpl();

        while (true){
            System.out.println("1. Hibernate\n" +
                    "2. JDBC \n" +
                    "0. Exit\n");
            String str = scanner.nextLine();
            if(str.equals("0"))
                break;

            switch (str){

                case "1":
                    while (true){
                        UserHibernateService userHibernateService = new UserHibernateServiceImpl();
                        System.out.println("~~~~~~~~~~Hibernate~~~~~~~~~~~\n" +
                                "1. User-лерге таблица тузуу\n" +
                                "2. user-ди базага кошуу. Ар бир user базага кошулгандан кийинанын аты - базага кошулду деп консольго чыгуусу керек\n" +
                                "3. Бардык user-лерди алуу жана консольго чыгаруу, toStringметодун override кылышыныз керек\n" +
                                "4. Таблицанын маалыматтарын очуруу\n" +
                                "0. Exit");
                        String string = scanner.nextLine();
                        if(string.equals("0"))
                            break;

                        switch (string){
                            case "1":
                                userHibernateService.createUsersTable();
                                break;
                            case "2":
                                userHibernateService.saveUser("Bektursun","Adylbek uulu",(byte) 23);
                                break;
                            case "3":
                                userHibernateService.getAllUsers().forEach(System.out::println);
                                break;
                            case "4":
                                userHibernateService.cleanUsersTable();
                                break;
                            default:
                                System.out.println("Choose another menu!");


                        }
                    }
                    break;
                case "2":
                    while(true){
                        UserServiceImpl userService = new UserServiceImpl();
                        System.out.println("~~~~~~~~~~~~~~~JDBC~~~~~~~~~~~~~\n" +
                                "1. User-лерге таблица тузуу\n" +
                                "2. 4 user-ди базага кошуу. Ар бир user базага кошулгандан кийинанын аты - базага кошулду деп консольго чыгуусу керек\n" +
                                "3. Бардык user-лерди алуу жана консольго чыгаруу, toStringметодун override кылышыныз керек\n" +
                                "4. Таблицанын маалыматтарын очуруу\n" +
                                "5. Таблицаны очуруу\n" +
                                "0. Exit");

                        String str1 = scanner.nextLine();

                        if(str1.equals("0"))
                            break;

                        switch (str1){
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
                    break;
                default:
                    System.out.println("Choose another menu!");

            }

        }

    }
}
