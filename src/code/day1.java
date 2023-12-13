package code;
import java.util.Scanner;

public class day1 {

	public static void main(String[] args) {
		// System.out.println("count: " + readtext.readIntNum());
		System.out.println("count: " + day1.readTextInt());
	}

	// reads ints only to form a two diigit number using the first and last number which are summed up
	public static int readIntNum() {
		Scanner scn = new Scanner(System.in);

		int count = 0;

		while (scn.hasNext()) {
			int firstInt = 0;
			int fIndex = 0;

			int secInt = 0;
			int sIndex = 0;
			String sent = scn.nextLine();
			// System.out.println(sent);

			// start from the front
			for (int i = 0; i < sent.length(); i++) {
				char letter = sent.charAt(i);
				if (Character.isDigit(letter)) {
					firstInt = Character.getNumericValue(letter);
					break;
				}
			}

			// start from the back
			for (int i = sent.length() - 1; i >= 0; i--) {
				char letter = sent.charAt(i);
				if (Character.isDigit(letter)) {
					secInt = Character.getNumericValue(letter);
					break;
				}
			}

			// System.out.println(firstInt + "" + secInt);
			count += (firstInt * 10) + secInt;

			System.out.println(count);

		}

		scn.close();
		return count;

	}

	// reads text and ints to form a two diigit number using the first and last number which are summed up
	public static int readTextInt() {
		Scanner scn = new Scanner(System.in);

		int count = 0;

		while (scn.hasNext()) {
			int firstInt = 0;
			int secInt = 0;

			String sent = scn.nextLine();
			// System.out.println(sent);

			// start from the front
			for (int i = 0; i < sent.length(); i++) {
				char letter = sent.charAt(i);
				if (Character.isDigit(letter)) {
					firstInt = Character.getNumericValue(letter);
					break;
				}

				int num = findInt(sent.substring(i));
				if (num != 0) {
					firstInt = num;
					// System.out.println(firstInt);
					break;
				}
			}

			// start from the back
			for (int i = sent.length() - 1; i >= 0; i--) {

				char letter = sent.charAt(i);
				if (Character.isDigit(letter)) {
					secInt = Character.getNumericValue(letter);
					break;
				}

				int num = findInt(sent.substring(i));
				if (num != 0) {
					secInt = num;
					// System.out.println(secInt);
					break;
				}
			}

			System.out.println(firstInt + "" + secInt);
			count += (firstInt * 10) + secInt;

			System.out.println("total: " + count);

		}

		scn.close();
		return count;

	}

	public static int findInt(String item) {

		int length = item.length();

		if (length >= 3 && item.substring(0, 3).equals("one")) {
			// System.out.println(item.substring(0, 3));
			return 1;
		} else if (length >= 3 && item.substring(0, 3).equals("two")) {
			// System.out.println(item.substring(0, 3));
			return 2;
		} else if (length >= 5 && item.substring(0, 5).equals("three")) {
			// System.out.println(item.substring(0, 5));
			return 3;
		} else if (length >= 4 && item.substring(0, 4).equals("four")) {
			// System.out.println(item.substring(0, 4));
			return 4;
		} else if (length >= 4 && item.substring(0, 4).equals("five")) {
			// System.out.println(item.substring(0, 4));
			return 5;
		} else if (length >= 3 && item.substring(0, 3).equals("six")) {
			// System.out.println(item.substring(0, 3));
			return 6;
		} else if (length >= 5 && item.substring(0, 5).equals("seven")) {
			// System.out.println(item.substring(0, 5));
			return 7;
		} else if (length >= 5 && item.substring(0, 5).equals("eight")) {
			// System.out.println(item.substring(0, 5));
			return 8;
		} else if (length >= 4 && item.substring(0, 4).equals("nine")) {
			// System.out.println(item.substring(0, 4));
			return 9;
		}
		// one, two, three, four, five, six, seven, eight, and nine

		return 0;
	}

}
