package ui;

import model.LinkedListMatrix;

import java.util.Scanner;

public class StartGame {
    Scanner scan = new Scanner(System.in);
    LinkedListMatrix lm;

    public StartGame() {
        System.out.println("Enter the nickname, row, column and the number of mirrors followed by spaces");
        System.out.println("ROW MIN ---> 1 " + " _______ " + "COLUMN MAX ---> 26 " + " _______ " + "MIRROR MAX ---> (ROW*COLUMN)");

        String[] data = scan.nextLine().split(" ");
        if (data.length == 4) {
            String nickname = data[0];
            int row = Integer.parseInt(data[1]);
            int column = Integer.parseInt(data[2]);
            int mirror = Integer.parseInt(data[3]);
            if ((row > 0) && (column > 0 && column <= 26) && (mirror > 0 && mirror <= (row * column))) {
                lm = new LinkedListMatrix(row, column, mirror);
                System.out.println(lm.toString());

            } else {
                System.out.println("The data entered is incorrect");
                new StartGame();
            }
        } else {
            System.out.println("The data entered is incorrect");
            new StartGame();
        }
        subMenu();
    }

    // disparar un rayo laser
    public void shootLaserBeam() {
        System.out.println("(1..n).Enter the row number\n" + "(A-Z).The column letter\n");
        String action = scan.nextLine();

        if (action.length() > 0) {
            lm.shootLaserAction(action);
            //lm.selectNode(action);
            System.out.println(lm.toString());

            /**
             int rowSelect = Integer.parseInt(action.substring(0,action.length()-1));
             //System.out.println(rowSelect + " " + action);
             char columnSelect = action.charAt(action.length()-1);
             //System.out.println(columnSelect + " " + action);

             System.out.println(rowSelect + " " + columnSelect);
             **/
        } else {
            System.out.println("the values entered exceed the allowed limit");
            shootLaserBeam();
        }
        subMenu();
    }

    //subMenu para dar opciones de disparar y adivinar
    public void subMenu() {
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
                    shootLaserBeam();
                    break;
                case 2:
                    guessMirrorPosition();
                    break;
                case 3:
                    new Menu();
                    break;
            }
        }else {
            System.out.println("The option incorrect");
            subMenu();
        }
    }

    //metodo para adivinar espejo

    public void guessMirrorPosition() {
        System.out.println("(1..n).Enter the row number\n" + "(A-Z).The column letter\n" +
                "(R).Right or (L). Left in uppercase");
        String select = scan.nextLine();
        System.out.println(" ");
        //agregar condicion de que se debe lanzar solo desde las filas y columnas principales
        if (select.length() > 0) {
            lm.selectNode(select);
            System.out.println(lm.toString());
            /**
            int rowSelect = Integer.parseInt(select.substring(0, select.length()-2));
            char columnSelect = select.charAt(select.length()-2);
            char position = select.charAt(select.length()-1);
            System.out.println(rowSelect + " " + columnSelect + " " + position);
            **/
        } else {
            System.out.println("the values entered exceed the allowed limit");
            guessMirrorPosition();
        }
        subMenu();
    }
}


