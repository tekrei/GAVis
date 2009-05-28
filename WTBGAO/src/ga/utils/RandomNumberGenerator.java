package ga.utils;

public class RandomNumberGenerator {

	private static RandomNumberGenerator instance = null;

	private MersenneTwisterFast generator = null;

	// private MersenneTwisterFast mersenneTwister = null;

	private RandomNumberGenerator() {
		generator = new MersenneTwisterFast();
	}

	public static RandomNumberGenerator getInstance() {
		if (instance == null) {
			instance = new RandomNumberGenerator();
		}
		return instance;
	}

	public float nextFloat() {
		return generator.nextFloat();
	}

	public float nextFloat(float ustSinir) {
		return generator.nextFloat() * ustSinir;
	}

	/**
	 * 
	 * @param deger
	 * @return
	 */
	public int nextInt(int deger) {
		return generator.nextInt(deger);
	}
}
