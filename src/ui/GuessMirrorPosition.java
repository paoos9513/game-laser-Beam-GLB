package ui;

import java.util.Scanner;

public class GuessMirrorPosition {
    Scanner scan = new Scanner(System.in);

    public GuessMirrorPosition() {
        //se puede buscar desde cualquier fila y columna
        System.out.println("enter row and column in uppercase");
        String select = scan.nextLine();
        System.out.println("");
        //agregar condicion de que se debe lanzar solo desde las filas y columnas principales
        if (select.length() == 2) {
            char rowSelect = select.charAt(0);
            char columnSelect = select.charAt(1);

            System.out.println(rowSelect + " " + columnSelect);
        } else if (select.length() == 3) {
            int rowSelect = (Integer.parseInt(select.substring(0, 1)));
            char columnSelect = select.charAt(2);
            System.out.println(rowSelect + " " + columnSelect);
        } else {
            System.out.println("the values entered exceed the allowed limit");
            new ShootLaserBeam();
        }
    }
}
