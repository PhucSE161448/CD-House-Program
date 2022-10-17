/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import MyUtils.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListCD extends ArrayList<Cd> {

    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Cd> list = new ArrayList<>(3);
    int count = 0;

    public ListCD() {
    }

    public void addCd() {
        System.out.println("The list has " + this.size() + " elements.");
        int size = this.size();
        System.out.println(size);
        if (size > 3) {
            System.out.println("UNABLE TO ADD CD ! ");
        } else {
            String name, type, year, title, ID;
            double price;
            name = Utils.getString1("Enter a name of CD : ", "(game|movie|music)", "MUST BE ENTER GAME/MOVIE/MUSIC");
            type = Utils.getString1("Enter type of CD : ", "(audio|video)", "MUST BE ENTER AUDIO/VIDEO");
            title = Utils.getString("Enter title of CD : ");
            price = Utils.getDouble("Enter price of CD : ", 0);
            while (true) {
                ID = Utils.getString("Enter ID of CD : ");
                Cd cd = findCode(ID);
                if (cd == null) {
                    break;
                } else {
                    System.out.println("DUPLICATE ID !!");
                }
            }
            year = Utils.getString1("Enter year of publishing CD : ", "\\d{4}", "MUST BE 4 NUMBER !! ");
            Cd cd = new Cd(name, title, ID, type, year, price);
            this.add(cd);
            count++;
        }
    }

    public Cd findCode(String ID) {
        for (Cd x : this) {
            if (ID.equalsIgnoreCase(x.getID())) {
                return x;
            }
        }
        return null;
    }

    public Cd findName(String Name) {
        for (Cd x : this) {
            if (Name.equalsIgnoreCase(x.getTitle())) {
                return x;
            }
        }
        return null;
    }


    public void searchTitle() {
        String title;
        System.out.print("Enter Title you want to search : ");
        title = sc.nextLine();
        Cd cd = findName(title);
        if (cd == null) {
            System.out.println("CD " + title + "NOT EXITS. ");
        } else {
            System.out.println("Here !!! ");
            System.out.println(cd.toString());
        }
    }

    public void printCd() {
        Collections.sort(this, new Comparator<Cd>() {
            @Override
            public int compare(Cd o1, Cd o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("");
        System.out.println("There are " + count + " CD in storage. ");
        for (Cd x : this) {
            System.out.println(x.toString());
        }
    }

    public void UpdateCd() {
        String title1;
        System.out.print("Enter Title you want to update : ");
        title1 = sc.nextLine();
        Cd cd = findName(title1);
        if (cd == null) {
            System.out.println("CD " + title1 + " NOT FOUND !!! ");
        } else {
            String oldID = cd.getID();
            System.out.print("Enter new ID : ");
            String newID = sc.nextLine();
            double oldPrice = cd.getPrice();
            System.out.print("Enter new Price : ");
            double newPrice = Double.parseDouble(sc.nextLine());
            System.out.println("Old ID : " + oldID + " => New ID : " + newID + "\nOld Price : " + oldPrice + " => New Price : " + newPrice);
            cd.setID(newID);
            cd.setPrice(newPrice);
            System.out.println("UPDATE SUCESSFULLY <3");
        }
    }

    public void RemoveCd() {
        String title2;
        System.out.print("Enter Title you want to remove : ");
        title2 = sc.nextLine();
        Cd cd = findName(title2);
        if (cd == null) {
            System.out.println("CD " + title2 + " NOT FOUND !!! ");
        } else {
            this.remove(cd);
            System.out.println("REMOVE SUCESSFULLY <3 ");
        }
    }

    public void addFromFile(String fname) {
        try {
            File f = new File(fname);
            if (f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details;
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, "-");
                String name = stk.nextToken().toUpperCase();
                String title = stk.nextToken().toUpperCase();
                String ID = stk.nextToken().toUpperCase();
                String year = stk.nextToken();
                double price = Double.parseDouble(stk.nextToken());
                Cd cd = new Cd(name, title, ID, title, year, price);
                this.add(cd);
                count++;
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
    }

    public void saveFromfile(String fname) {
        if (this.isEmpty()) {
            System.out.println("EMPTY FILE !! ");
        }
        try {
            File f = new File(fname);
            FileWriter fw = new FileWriter(fname, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Cd x : this) {
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public void getUD() {
        boolean check ;
        String choice;
        System.out.println("1.Update CD");
        System.out.println("2.Remove CD");
        do {
            check = false;
            System.out.print("Enter your choice : ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.UpdateCd();
                    break;
                case "2":
                    this.RemoveCd();
                    break;
                default:
                    System.out.println("RE-ENTER NUMBER 1 OR 2.");
                    check = true;
            }
        } while ( check == true);
    }
}
