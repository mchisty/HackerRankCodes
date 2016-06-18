package org.hackerrank;

//------------------------
// Sample input
//5
//10 10
//1 1 1
//5 9
//2 3 4
//3 6
//9 1 1
//7 7
//4 2 1
//3 3
//1 9 2
//------------------------
// Output
//20
//37
//12
//35
//12
import java.util.Scanner;

public class TaumAndBDay {
    public TaumAndBDay() {
    }

    public static void main(String[] args) {
	TaumAndBDay tb = new TaumAndBDay();
	// -------------------------------------------
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	for (int a0 = 0; a0 < t; a0++) {
	    long b = in.nextLong();
	    long w = in.nextLong();
	    long x = in.nextLong();
	    long y = in.nextLong();
	    long z = in.nextLong();
	    // ----------------------------------
	    long result = tb.getCheaperPrice(b, w, x, y, z);
	    System.out.println("value: " + result);
	}
	in.close();
    }

    boolean isBlackExpensiveThanWhite(long blackPrice, long whitePrice) {
	return blackPrice > whitePrice;
    }

    boolean isConversionNeeded(long black, long white, long X, long Y, long Z) {
	long blackPrice = black * X;
	long whitePrice = white * Y;
	long convBlackPrice = black * Y;
	long convWhitePrice = white * X;
	if (isBlackEqualToWhite(blackPrice, whitePrice)) {
	    return false;
	}
	if (blackPrice > whitePrice) {
	    if (convBlackPrice < convWhitePrice) {
		// TODO: Proceed
		return true;
	    }
	} else if (whitePrice > blackPrice) {
	    if (convWhitePrice < convBlackPrice) {
		// TODO: Proceed
		return true;
	    }
	}
	return false;
    }

    boolean isBlackEqualToWhite(long blackPrice, long whitePrice) {
	return blackPrice == whitePrice;
    }

    long getCheaperPrice(long black, long white, long X, long Y, long Z) {
	long blackPrice = black * X;
	long whitePrice = white * Y;
	long sum = 0L;
	if (!isConversionNeeded(black, white, X, Y, Z)) {
	    sum = blackPrice + whitePrice;
	} else if (isBlackExpensiveThanWhite(blackPrice, whitePrice)) {
	    sum = (black * (Y + Z)) + whitePrice;
	} else {
	    sum = (white * (X + Z)) + blackPrice;
	}
	return sum;
    }
    // ----------------------------------------------------------------------------------------
    // boolean isBlackExpensiveThanWhite(BigInteger blackPrice, BigInteger whitePrice) {
    // return blackPrice.compareTo(whitePrice) > 0;
    // }
    //
    // boolean isBlackEqualToWhite(BigInteger blackPrice, BigInteger whitePrice) {
    // return blackPrice.compareTo(whitePrice) == 0;
    // }
    //
    // BigInteger getCheaperPrice(BigInteger black, BigInteger white, BigInteger X, BigInteger Y, BigInteger Z) {
    // BigInteger blackPrice = black.multiply(X);
    // BigInteger whitePrice = white.multiply(Y);
    // BigInteger sum = BigInteger.ZERO;
    // if (isBlackEqualToWhite(blackPrice, whitePrice)) {
    // sum = blackPrice.add(whitePrice);
    // } else if (isBlackExpensiveThanWhite(blackPrice, whitePrice)) {
    // sum = black.multiply(Y.add(Z)).add(whitePrice);
    // } else {
    // sum = white.multiply(X.add(Z)).add(blackPrice);
    // }
    // return sum;
    // }
}
