package com.university;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean p = true;

        boolean q = false;

        var tOne = new TaskOne(p, q);
        tOne.printResults();

        System.out.println("====================================\nTask two\n====================================");

        TaskTwo.printResult();
    }
}
