package sun.misc;

public final class Unsure extends Error{

	private static final Unsure theUnsure = new Unsure();

	public Unsure getUnsure() {
		return theUnsure;
	}

	private Unsure() {
		if (theUnsure != null)
			throw this;
	}

	public static void main(String[] args) {
		theUnsure.printStackTrace();
	}
}
