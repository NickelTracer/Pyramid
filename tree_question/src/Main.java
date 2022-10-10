import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class Main {
    private int height;

    private void getData(){
        Scanner in = new Scanner(System.in);

        try{
            System.out.print("Enter height of a pyramid: ");
            height = in.nextInt();

            while (height <= 0){
                System.out.print("Height cannot be lower or equal to 0! Try again...");
                in.nextInt();
            }
        }catch(InputMismatchException e){
            System.out.println("Integer value expected! Try again...");
            in.nextLine();
        }


    }

    public static void main(String[] args){
        Main obj = new Main();
        obj.getData();

        TreeReversed obj1 = new TreeReversed();
        obj1.fun(obj.height);

        System.out.print("\n\n\n");

        TreeReversed obj2 = new Tree();
        obj2.fun(obj.height);
    }
}

class TreeReversed {
    public void fun(int heightOfTree){
        StringBuilder result = new StringBuilder();
        int rows = heightOfTree * 2 - 1;

        for (int i = 0; i < rows; i++){
            result.insert(i, '*');
        }

        for (int j = 0; j < heightOfTree - 1; j++){

            if(j == 0){
                System.out.println(j + 1 + ". " + result);
            }

            result.setCharAt(j, ' ');
            result.setCharAt(rows-1 - j, ' ');

            System.out.println(j + 2 + ". " + result);
        }
    }
}

class Tree extends TreeReversed {
    public void fun(int heightOfTree){
        StringBuilder result = new StringBuilder();
        int rows = heightOfTree * 2 - 1;

        for (int i = 0; i < rows; i++){
            result.insert(i, ' ');
        }

        for (int j = 0; j < heightOfTree; j++){

            result.setCharAt(rows / 2, '*');
            result.setCharAt(rows / 2 + j, '*');
            result.setCharAt(rows / 2 - j, '*');

            System.out.println(j + 1 + ". " + result);
        }
    }
}