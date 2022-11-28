package start;

import one.jnuit.misc.Unsafe0;

import java.io.File;
import java.lang.reflect.Field;

public class Tests2 {


	static {
		File f = new File("misc/build/lib/main/debug");
	}
	public static long startTime;
	public static final int repeat = 235498623;
	public static final Unsafe0 theUnsafe;
	static {
		Field f = null;
		try {
			f = Unsafe0.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			theUnsafe = (Unsafe0) f.get(null);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}


	public static void main(String[] args) {
		System.out.println(repeat+" reps");
		start();


		long a = theUnsafe.allocateMemory(16);
		//byte[] d = new byte[16];

		for (int i = 0;i<repeat;i++) {
			theUnsafe.putByte(a+(i%16),(byte)i);
			//d[i%16] = (byte)i;
		}
		theUnsafe.freeMemory(a);

		exit();
	}
	public static void exit() {
		long time = System.currentTimeMillis()-startTime;
		System.out.println("\nFinished in "+time+"ms");
		System.out.println("("+String.format("%.5f",((double)time/(double)repeat))+"ms for one operation)");
		System.out.println("\n ========== ");
	}
	public static void start() {
		System.out.println("\n ========== \n");
		startTime = System.currentTimeMillis();
	}
}
