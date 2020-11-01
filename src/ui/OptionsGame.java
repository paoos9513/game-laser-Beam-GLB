package ui;

import java.util.Scanner;

public class OptionsGame {
    Scanner scan = new Scanner(System.in);
    public OptionsGame() {
        System.out.println("--------------------");
        System.out.println(" Options to execute");
        System.out.println("--------------------");
        System.out.println("1.Show score");
        System.out.println("2.shoot laser beam");
        System.out.println("3.end game");

        int option = Integer.parseInt(scan.nextLine());
        switch (option){
            case 1:
                subtraction();
                break;
            case 2:
                break;
            case 3:
                new Menu();
                break;
        }
    }

    public void subtraction(){
        System.out.println("Guess mirror location");
        System.out.println("enter row and column in uppercase");
        String select = scan.nextLine();
        if(select.length()==2){
            char rowSelect = (select.charAt(0));
            char columnSelect = select.charAt(1);

            System.out.println(rowSelect + " " + columnSelect);
        }else if(select.length()==3){
            int rowSelect = (Integer.parseInt(select.substring(0,1)));
            char columnSelect = select.charAt(2);
            System.out.println(rowSelect + " " + columnSelect);
        }else{
            System.out.println("the values entered exceed the allowed limit");
            subtraction();
        }
    }
}
