import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String queryString = sc.next();
        String[] splitedQuery = queryString.split("&");
        ArrayList<String> duplicated = new ArrayList<>();
        ArrayList<String> rightSide;
        int sPQL = splitedQuery.length;
        System.out.print("{");
        for (int i = 0; i < sPQL; i++) {
            rightSide = new ArrayList<>();
            //check left side to avoid printing duplicate things
            String leftString = splitedQuery[i].split("=")[0];
            if (duplicated.contains(leftString)) {
                continue;
            }
            else if(i<sPQL-1 && i>0)
                System.out.print(" , ");
            duplicated.add(leftString);


            for (int j = i; j < sPQL; j++) {
                String rightString = splitedQuery[j].split("=")[1];
                if(rightSide.contains(rightString))
                    continue;
                if (splitedQuery[j].split("=")[0].equals(leftString))
                    rightSide.add(rightString);
            }
            print(leftString, rightSide);

        }
        System.out.print("}");
    }

    private static void print(String type, ArrayList<String> value) {
        System.out.print("'" + type + "'" + " = ");
        if (value.size() == 1)
            System.out.print("'" + value.get(0) + "'");
        else {
            System.out.print("[");
            for (int i = 0; i < value.size(); i++) {
                System.out.print("'" + value.get(i) + "'");
                if (i < value.size() - 1) {
                    System.out.print(" , ");
                }
            }
            System.out.print("]");

        }
    }
}
