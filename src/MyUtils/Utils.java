/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyUtils;

import DTO.Cd;
import java.util.Scanner;

public class Utils {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String msg) {
        String result = "";
        boolean check = false;
        do {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("CAN NOT BE EMPTY !!! ");
            } else {
                check = true;
            }
        } while (!check);
        return result;
    }

    public static double getDouble(String msg, double min) {
        double n = 0;
        boolean check = false;
        do {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (n <= min) {
                    System.out.println("CAN NOT LESS THAN " + min + " !!! ");
                } else {
                    check = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ENTER A NUMBER !!! ");
            }
        } while (!check);
        return n;
    }

    public static String getString1(String msg, String pattern, String err) {
        String result = "";
        boolean check = false;
        do {
            System.out.print(msg);
            result = sc.nextLine();
            if (!result.matches(pattern)) {
                System.out.println(err);
            } else {
                check = true;
            }
        } while (!check);
        return result;
    }
    
    public static String getUserchoice(String msg){
        String result = "";
        boolean check = false;
        do {            
            System.out.print(msg);
            String x = sc.nextLine();
            if(!x.isEmpty() && x.equalsIgnoreCase("YES") || x.equalsIgnoreCase("NO")){
                result = x;
                check = true;
            }else
                System.out.println("PLEASE CHOOSE YES/NO !!! ");
        } while (!check);
        return result;
    }
    
    
}
