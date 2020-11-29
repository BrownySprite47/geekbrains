package com.geekbrains.course1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main2 {

   public static void main(String[] args) {
       int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
       System.out.println(Arrays.toString(revertArray(array1)));

       int[] array2 = new int[8];
       System.out.println(Arrays.toString(setArrayValuesByNum(array2,0, 3)));

       int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
       System.out.println(Arrays.toString(multipleArray(array3, 6, 2)));

       System.out.println("--------------------------------------------");
       showDiagonalArrayAsString(getDiagonalArray(5));
       System.out.println("--------------------------------------------");

       int[] array4 = {14, 9, -2, 5, 78, 1, 0, 7, 3, -6};
       System.out.println(Arrays.toString(getMaxAndMinArrayValue(array4)));

       int[] array5 = {2, 2, 2, 1, 2, 6, 10, 1};
       System.out.println(checkBalance(array5));

       int[] array6 = {1, 2, 3, 4, 5};
       System.out.println(Arrays.toString(moveArrayIndexesByNum(array6, -2)));
   }

    private static int[] revertArray(int[] array) {
       for (int i = 0; i < array.length; i++) {
           array[i] = array[i] == 1 ? 0 : 1;
       }
       return array;
    }

    private static int[] setArrayValuesByNum(int[] array, int startNum, int num) {
       for (int i = 0; i < array.length; i++) {
           array[i] = startNum;
           startNum += num;
       }
       return array;
    }

    private static int[] multipleArray(int[] array, int checkValue, int multiple) {
       for (int i = 0; i < array.length; i++) {
           if (array[i] < checkValue) {
               array[i] *= multiple;
           }
       }
       return array;
    }

    private static int[][] getDiagonalArray(int num) {
       int [][] array = new int[num][num];
       for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array[i].length; j++) {
               array[i][j + i] = 1;
               array[i][array[i].length - 1 - i] = 1;
               break;
           }
       }
       return array;
    }

    private static void showDiagonalArrayAsString(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    private static int[] getMaxAndMinArrayValue(int[] array) {
        int maxValue = array[0];
        int minValue = array[0];
        for (int item : array) {
            if (item > maxValue) {
                maxValue = item;
            }
            if (item < minValue) {
                minValue = item;
            }
        }
        return new int[]{maxValue, minValue};
    }

    private static boolean checkBalance(int[] array) {
        int total = IntStream.of(array).sum();
        if (array.length != 0 && total % 2 != 0) {
            int summ = 0;
            for (int i = 0; i < array.length; i++) {
                summ += array[i];
                if (summ > total / 2) {
                    break;
                }
                if (summ == total / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] moveArrayIndexesByNum(int[] array, int num) {
        int value;
        if (num > 0) {
            for (int k = 0; k < num; k++) {
                for (int i = 0; i < array.length; i++) {
                    value = array[array.length - 1];
                    array[array.length - 1] = array[i];
                    array[i] = value;
                }
            }
        } else {
            for (int k = num; k < 0; k++) {
                for (int i = array.length - 1; i >= 0; i--) {
                    value = array[array.length - 1];
                    array[array.length - 1] = array[i];
                    array[i] = value;
                }
            }
        }
        return array;
    }
}
