package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] binary = new int[]{1, 0, 0, 1, 0, 1, 0, 1, 1, 0};
        replaceZero(binary);

	    int[] aProgression = new int[8];
        addProgression(aProgression);

	    int[] lessSix = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
	    doubleNumbers(lessSix);

	    int[][] diagonal = new int[10][10];
	    addDiagonal(diagonal);

	    int[] extremum = new int[]{3, -600, 0, -5, 10, 16, 22, 100, -100, 3, 4};
	    printExtr(extremum);

	    int[] parts = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(isEqualParts(parts) ? "Есть равные части." : "Нет равных частей.");
        for(int bias = -12; bias < 12; bias++) {
            int[] mass = new int[]{1, 2, 3, 4, 5, 6};
            biasMass(mass, bias);
        }

    }

    //for checking tasks
    private static void printMass(int[] mass){
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println(" ");
    }

    //task1
    private static void replaceZero(int[] binary){
        for (int i = 0; i < binary.length; i++) {
            binary[i] = binary[i] == 0 ? 1 : binary[i];
        }
        printMass(binary);
    }

    //task2
    private static void addProgression(int [] aProgression){
        int number = 0;
        for (int i = 0; i < aProgression.length; i++) {
            aProgression[i] = number;
            number += 3;
        }
        printMass(aProgression);
    }

    //task3
    private static void doubleNumbers(int[] lessSix){
        for (int i = 0; i < lessSix.length; i++) {
            lessSix[i] = lessSix[i] < 6 ? lessSix[i] * 2 : lessSix[i];
        }
        printMass(lessSix);
    }

    //task4
    private static void addDiagonal(int[][] diagonal){
        for (int i = 0; i < diagonal.length; i++) {
            for (int j = 0; j < diagonal[i].length; j++) {
                if (i == j || i+j == diagonal.length-1){
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    //task5
    private static void printExtr(int[] extremum){
        int min = 2147483647;
        int max = -2147483648;
        for (int i = 0; i < extremum.length; i++) {
            if (extremum[i] < min){
                min = extremum[i];
            } else if (extremum[i] > max){
                max = extremum[i];
            }
        }
        System.out.println("Минимум: " + min + "; Максимум: " + max + ".");
    }

    //task6
    private static boolean isEqualParts(int[] parts){
        int sum = 0;
        for (int i = 0; i < parts.length; i++) {
            sum += parts[i];
        }

        int half = sum%2 == 0 ? sum/2 : 0;
        if (half == 0){
            return false;
        }
        int part = 0;
        for (int i = 0; i < parts.length; i++) {
            part += parts[i];
            if (part == half){
                return true;
            }
        }
        return false;
    }

    //task7
    private static void biasMass(int[] mass, int bias){
        int l = mass.length;
        bias = bias%l;
        if(bias < 0){
            bias += l;
        }
        reverseMass(mass, 0, l);
        reverseMass(mass, 0, bias);
        reverseMass(mass, bias, l);
        printMass(mass);
    }

    private static void reverseMass(int[] mass, int start, int finish){
        int temp;
        for (int i = 0; i < (finish-start)/2;  i++) {
            temp = mass[start+i];
            mass[start + i] = mass[finish - i - 1];
            mass[finish - i - 1] = temp;
        }
    }
    //useless comment for branch changing
}



