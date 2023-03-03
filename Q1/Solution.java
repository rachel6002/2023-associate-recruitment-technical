package Q1;

import java.util.*;
import java.util.Scanner;

public class Solution {
    static TreeMap<Integer, Integer> shirtValue = new TreeMap<>();

    public static int computeValue (String shirt) {
        if(shirt.endsWith("S")) {
            int prefix = shirt.length() - 1;
            int value = prefix * -1 + 10;
            return value;
        } else if (shirt.endsWith("M")) {
            return 20;
        } else if (shirt.endsWith("L")) {
            int prefix = shirt.length() - 1;
            int value = prefix * 1 + 30;
            return value;
        }
        return 0;
    }

    public static boolean check (int numShirts, String[] allShirts, int numReq, String[] shirtReq) {
        if (numShirts < numReq) {
            return false;
        }

        
        // size s = 10; size m = 20; size L = 30; X before S = -1; s after L = + 1
        for (String shirt : allShirts) {
            int value = computeValue(shirt);
            shirtValue.put(value, shirtValue.getOrDefault(value, 0) + 1);
        }

        for (String req : shirtReq) {
            boolean flag = false;
            for(Map.Entry<Integer, Integer> ent: shirtValue.entrySet()) {
                int value = computeValue(req);
                if (value >= ent.getKey() && ent.getValue() > 0) {
                    shirtValue.put(ent.getKey(), shirtValue.getOrDefault(ent.getKey(), 0) - 1);
                    flag = true;
                    break;
                }     
            }
            if(!flag) {
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        int numShirts = scnr.nextInt();
        String allShirtsAvail = scnr.nextLine();
        int numReq = scnr.nextInt();
        String shirtReqs = scnr.nextLine();

        String[] shirtsAvail = allShirtsAvail.split(" ");
        String[] shirtReq = shirtReqs.split(" ");

        if (check(numShirts, shirtsAvail, numReq, shirtReq)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }
}