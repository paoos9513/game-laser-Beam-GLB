package ui;

import java.util.Scanner;

public class SubMenu {
    Scanner scan = new Scanner(System.in);

    public SubMenu() {
        System.out.println("--------------------");
        System.out.println(" Options to execute");
        System.out.println("--------------------");
        System.out.println("1.shoot laser beam");
        System.out.println("2.Guess mirror location");
        System.out.println("3.Start menu");

        int option = Integer.parseInt(scan.nextLine());
        if (option<4) {
            switch (option) {
                case 1:
                    new ShootLaserBeam();
                    break;
                case 2:
                    new GuessMirrorPosition();
                    break;
                case 3:
                    new Menu();
                    break;
            }
        }else {
            System.out.println("The option incorrect");
            new SubMenu();
        }
    }
}
