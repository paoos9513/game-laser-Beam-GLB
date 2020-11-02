package ui;

import java.util.Scanner;

public class ShootLaserBeam {
    Scanner scan = new Scanner(System.in);

    public ShootLaserBeam() {
        System.out.println("Enter the row number\n" +
                "(A-Z).The column letter\n" +
                "(V).vertical or (H). horizontal in uppercase");
        String select = scan.nextLine();
        //agregar condicion de que se debe lanzar solo desde las filas y columnas principales
        if (select.length() < 4) {
            char rowSelect = select.charAt(0);
            char columnSelect = select.charAt(1);
            char orientation = select.charAt(2);

            System.out.println(rowSelect + " " + columnSelect + " " + orientation);
        } else if (select.length() < 5) {
            String rowSelect = select.substring(0,2);
            char columnSelect = select.charAt(2);
            char orientation = select.charAt(3);
            System.out.println(rowSelect + " " + columnSelect + " " + orientation);
        } else {
            System.out.println("the values entered exceed the allowed limit");
        }
        new ShootLaserBeam();
    }
}

