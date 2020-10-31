package ui;

import java.util.Scanner;

public class Menu {
    int option;
    Scanner scan = new Scanner(System.in);
    public Menu() {
        showMenu();
    }
// solo se debe manejar recursividad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! PELIGRO!!!
    public void showMenu(){
        System.out.println("-------------------------------");
        System.out.println("      GAME LASER BEAM GLB");
        System.out.println("-------------------------------");
        System.out.println("1).Play \n"+
                           "2).See position board\n"+
                           "3).Exit game\n"
        );
        option = Integer.parseInt(scan.nextLine());
        while (option!=3){
            switch (option){
                case 1:
                    new EnterDate();
                    break;
                case 2:
                    break;
                case 3:
                    scan.close();
                    break;
                default:
                    System.out.println("The option incorrect");
            }
        }
    }
}
