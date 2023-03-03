package Q2;

import java.util.*;

public class Solution {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        int num = scnr.nextInt();

        ArrayList<String> res = new ArrayList<>();
        int falseCount = 0;

        for (int i = 0; i < num; i++) {
            String input = scnr.nextLine();
            String[] str = input.split(" ");
            if(str[1].trim().equals("false")) {
                res.add(str[2].trim());
                falseCount++;
            }
        }
        if (falseCount > 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

        String err = "";
        StringBuilder sb = new StringBuilder();
        if (res.size() > 0) {
            for (String s : res) {
                sb.append(s);
                sb.append(" ");
            }
            err = sb.toString().trim();
        }
        
        if (falseCount > 0) {
            System.out.println(err);
        }

    }
}
