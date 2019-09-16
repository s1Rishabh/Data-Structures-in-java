package L003_StringBuilder;

import java.util.Scanner;

public class StringBuilder_001 {

	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

	input();
	
	}
	
	
	private static void input() {
		StringBuilder sb=new StringBuilder();
		sb.append("hsv");
		sb.append("sacs8716w");
		System.out.println(sb.toString());
		
		sb.deleteCharAt(4);
		System.out.println(sb.toString());
		
		System.out.println(sb.substring(4));
		sb.substring(2, 5);
		
		sb.setCharAt(2,'1');
		System.out.println(sb.toString());
		
		
		
	}
}
