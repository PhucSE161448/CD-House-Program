/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Menu extends Vector<String> {

    public static Scanner sc = new Scanner(System.in);

    public Menu() {
    }

    public void addMenu(String S) {
        this.add(S);
    }

    public int getUserChoice() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        int choice = sc.nextInt();
        return choice;
    }

    public void showMenu() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
