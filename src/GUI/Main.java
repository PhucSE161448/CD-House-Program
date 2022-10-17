/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.ListCD;
import DTO.Menu;
import MyUtils.Utils;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String response;
        int choice;
        Scanner sc = new Scanner(System.in);
        String f = "CD.txt";
        ListCD c = new ListCD();
        Menu menu = new Menu();
        menu.add("1.Add CDs.");
        menu.add("\n2.Search CD by title.");
        menu.add("\n3.Display the catalog.");
        menu.add("\n4.Update/Delete an Employee.");
        menu.add("\n5.Save to file CD.dat.");
        menu.add("\n6.Print from file.");
        menu.add("\n7.Exit.");
        menu.add("\nYour choice :");
        boolean check;
            do {
                check = false;
                System.out.println("\n=======MENU=======");
                choice = menu.getUserChoice();

                switch (choice) {
                    case 1:
                        c.addCd();
                        break;
                    case 2:
                        c.searchTitle();
                        break;
                    case 3:
                        c.printCd();
                        break;
                    case 4:
                        do {
                            c.getUD();
                            response = Utils.getUserchoice("Do you want to go back to MENU ? ");
                        } while (response.equalsIgnoreCase("No"));
                        break;
                    case 5:
                        do {
                            c.saveFromfile(f);
                            response = Utils.getUserchoice("Do you want to go back to MENU ? ");
                        } while (response.equalsIgnoreCase("No"));
                        break;
                    case 6:
                        do {
                            c.addFromFile(f);
                            c.printCd();
                            response = Utils.getUserchoice("Do you want to go back to MENU ? ");
                            if(response.equalsIgnoreCase("No")){
                                System.exit(0);
                            }
                        } while (response.equalsIgnoreCase("No"));
                        break;
                    default:
                        System.out.println("PLEASE ENTER NUMBER 1-6 ");
                        check = true;
                }

            } while (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || check == true);
        }
    }
