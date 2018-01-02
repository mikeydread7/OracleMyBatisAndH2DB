package com.mybatis.demo;

import java.util.Scanner;

public class tree {

	public static void main(String[] args) {
		int row;
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Please enter the tree height: ");
				row = sc.nextInt();
				if (row > 3) {
					sc.close();
					System.out.println();
					break;
				}
			}
			catch (Exception ex) {
				//error occurred do or say something
			}
		}

		String element = "X";

		for (int i = 0; i < row; i++) { // 1. row = 4
			for (int j = 0; j < row - i; j++) { //
				System.out.print(" "); // print space
			}
			for (int k = 0; k < (2 * i + 1); k++) { // 1. k=0; 0+1 2. 2*1+1= 3
													// 3.2*2+1 =5
				System.out.print(element); //print X
			}
			System.out.println();
		}
		printBase(row, element);

	}
    /**
     * print the base of the tree
     * @param count
     * @param element
     */
	private static void printBase(int count, String element) {

		for (int i = 0; i < count; i++) {
			System.out.print(" "); //print space
		}
		System.out.println(element); //print X
	}
}