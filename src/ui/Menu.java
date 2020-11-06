package ui;

import java.util.Scanner;

public class Menu {
    int option;
    Scanner scan = new Scanner(System.in);
//metodo constructor
    public Menu() {
        showMenu();
    }
//muestra el menu principal
    public void showMenu() {
        System.out.println("*******************************");
        System.out.println("      GAME LASER BEAM GLB");
        System.out.println("*******************************");
        System.out.println("1).Play \n" +
                "2).See Score\n" +
                "3).Exit game\n"
        );
        option = Integer.parseInt(scan.nextLine());
        if (option < 4) {
            switch (option) {
                case 1:
                    new StartGame();
                    break;
                case 2:
                    //new Score();
                    break;
                case 3:
                    scan.close();
                    break;
            }
        } else {
            System.out.println(" Option incorrect");
            showMenu();
        }
    }
}
