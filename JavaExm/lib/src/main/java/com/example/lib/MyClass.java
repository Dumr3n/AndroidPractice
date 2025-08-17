package com.example.lib;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter fucking string: ");
        String str = s1.nextLine();
        int len = str.length();
        for (int i = len-1; i > 0; i--) System.out.print(str.charAt(i));
        System.out.println("\nFucking worked!");
    }
}