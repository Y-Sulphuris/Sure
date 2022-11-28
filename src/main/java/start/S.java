package start;

public final class S {
	private S(){}
	static {
		System.load(System.getProperty("Sure.native.path"));
	}
	public static void doNothing() {}
}
