public class Calculator {
    private static Calculator INSTANCE;
    private double similarity = 0;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Calculator();
        }
        return INSTANCE;
    }

	public double calculate(int[] vectorOne, int[] vectorTwo) {
		double numerator = 0;
        double denominatorA = 0;
        double denominatorB = 0;

        for (int i = 0; i < vectorOne.length; i++) {
            numerator += vectorOne[i] * vectorTwo[i];
            denominatorA += vectorOne[i] * vectorOne[i];
            denominatorB += vectorTwo[i] * vectorTwo[i];
        }
        similarity = numerator / (Math.sqrt(denominatorA) * Math.sqrt(denominatorB));
		return similarity;
	}

}