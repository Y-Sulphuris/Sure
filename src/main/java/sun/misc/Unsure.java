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

	public native long getJNIEnvAddress();

	public static void main(String[] args) {
		System.out.println(theUnsure.getJNIEnvAddress());
	}


	@Override
	public String toString() {
		return "theUnsure";
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Unsure;
	}

}