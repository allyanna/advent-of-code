package code;

import java.io.BufferedReader;
import java.io.FileReader;

public class day2 {

	private int rColor;
	private int gColor;
	private int bColor;

	// store the minimum of each cube
	private int minR;
	private int minG;
	private int minB;

	public static void main(String[] args) {
		/**
		 * Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green Game 2: 1 blue, 2
		 * green; 3 green, 4 blue, 1 red; 1 green, 1 blue Game 3: 8 green, 6 blue, 20
		 * red; 5 blue, 4 red, 13 green; 5 green, 1 red Game 4: 1 green, 3 red, 6 blue;
		 * 3 green, 6 red; 3 green, 15 blue, 14 red Game 5: 6 red, 1 blue, 3 green; 2
		 * blue, 1 red, 2 green
		 */

		// 12 red cubes, 13 green cubes, and 14 blue cubes
		day2 d = new day2();

//		try {
//			d.findPossibleGames("src/day2pt1", 12, 13, 14);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		day2 d1 = new day2();
		try {
			//d1.findMinPossibleCubeMultiplied("src/day2test", 12, 13, 14);

			d1.findMinPossibleCubeMultiplied("src/day2pt1", 12, 13, 14);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int findPossibleGames(String file, int red, int green, int blue) throws Exception {

		rColor = red;
		gColor = green;
		bColor = blue;
		int gameCount = 0;

		BufferedReader reader = new BufferedReader(new FileReader(file));

		String currentLine = reader.readLine();
		while (currentLine != null) {
			// System.out.println(currentLine);

			String[] splitStr = currentLine.split(" ");
			// game
			// #
			int gameNum = Integer.parseInt(splitStr[1].substring(0, splitStr[1].length() - 1));

			System.out.println("game: " + gameNum);

			boolean subColor = false;
			// start at the third value
			for (int i = 2; i < splitStr.length; i = i + 2) {
				System.out.println(splitStr[i]);
				System.out.println(splitStr[i + 1]);

				int num = Integer.parseInt(splitStr[i]);
				String colorName = splitStr[i + 1];
				subColor = canSubtractColor(num, colorName);
				if (!subColor)
					break;

			}

			if (subColor) {
				System.out.println("game num added: " + gameNum);
				gameCount += gameNum;
			}

			currentLine = reader.readLine();
			rColor = 12;
			gColor = 13;
			bColor = 14;
		}

		reader.close();

		System.out.println(gameCount);
		return gameCount;
	}

	// true meaning passing, false meaning fail
	public boolean canSubtractColor(int num, String color) {
		// rColor
		// gColor
		// bColor

		if (color.startsWith("red")) {
			rColor = rColor - num;
			if (num > minR)
				minR = num;
		} else if (color.startsWith("green")) {
			gColor = gColor - num;
			if (num > minG)
				minG = num;
		} else if (color.startsWith("blue")) {
			bColor = bColor - num;
			if (num > minB)
				minB = num;
		}

		boolean toReturn = true;//rColor >= 0 && gColor >= 0 && bColor >= 0;

//		if (color.substring(color.length() - 1).equals(";")) {
//			rColor = 12;
//			gColor = 13;
//			bColor = 14;
//		}

		return toReturn;

	}

	public int findMinPossibleCubeMultiplied(String file, int red, int green, int blue) throws Exception {

		rColor = red;
		gColor = green;
		bColor = blue;

		// store the minimum of each cube
		minR = 0;
		minG = 0;
		minB = 0;

		int gameCount = 0;

		BufferedReader reader = new BufferedReader(new FileReader(file));

		String currentLine = reader.readLine();
		while (currentLine != null) {
			// System.out.println(currentLine);

			String[] splitStr = currentLine.split(" ");
			// game
			// #
			int gameNum = Integer.parseInt(splitStr[1].substring(0, splitStr[1].length() - 1));

			System.out.println("game: " + gameNum);

			boolean subColor = false;
			// start at the third value
			for (int i = 2; i < splitStr.length; i = i + 2) {
				System.out.println(splitStr[i]);
				System.out.println(splitStr[i + 1]);

				int num = Integer.parseInt(splitStr[i]);
				String colorName = splitStr[i + 1];
				subColor = canSubtractColor(num, colorName);
				if (!subColor)
					break;

			}

			if (subColor) {
				System.out.println("game num added: " + minR * minG * minB);
				gameCount += minR * minG * minB;
			}

			currentLine = reader.readLine();
			minR = 0;
			minG = 0;
			minB = 0;
			rColor = red;
			gColor = green;
			bColor = blue;
		}

		reader.close();

		System.out.println(gameCount);
		return gameCount;
	}

}
