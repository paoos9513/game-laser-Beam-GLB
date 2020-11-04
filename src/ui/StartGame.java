package ui;

import model.LinkedListMatrix;
import java.util.Scanner;

public class StartGame {
    Scanner scan = new Scanner(System.in);
    LinkedListMatrix lm;
    private String[] data;

    public StartGame() {
        System.out.println("Enter the nickname, row, column and the number of mirrors followed by spaces");
        System.out.println("ROW MAX ---> 26 " + " _______ " + "COLUMN MAX ---> 26 " + " _______ " + "MIRROR MAX ---> (ROW*COLUMN)");
        data = scan.nextLine().split(" ");
        if (data.length == 4) {
            String nickname = data[0];
            int row = Integer.parseInt(data[1]);
            int column = Integer.parseInt(data[2]);
            int mirror = Integer.parseInt(data[3]);
            if (row <= 26 && column <= 27 && mirror <= (row * column)) {
                lm = new LinkedListMatrix(row, column,mirror);
                System.out.println(lm.toString());
            } else {
                System.out.println("Exceeds allowed values");
                new StartGame();
            }
        } else {
            System.out.println("Exceeds allowed values");
            new StartGame();
        }
        new SubMenu();
    }
}
