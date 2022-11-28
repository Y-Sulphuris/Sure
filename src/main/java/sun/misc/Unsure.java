package sun.misc;

import start.S;

import java.io.File;

public final class Unsure extends Error{


	static {
		System.setProperty("Sure.native.path",new File("misc/build/lib/main/debug/misc.dll").getAbsolutePath());
		S.doNothing();
	}
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
