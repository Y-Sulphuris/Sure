package one.jnuit.misc;

import javax.annotation.Generated;

public final class Unsafe0 implements UnsafeImpl{

	//@SuppressWarnings("Only for tests")

	private final sun.misc.Unsafe sunUnsafe = UnsafeImpl.getSunUnsafe();


	private sun.misc.Unsafe delegate() throws ClassNotFoundException {
		if (sunUnsafe==null)
			throw new ClassNotFoundException();
		return sunUnsafe;
	}
	private static final Error ERROR = new Error();
	private static final Unsafe0 theUnsafe = new Unsafe0();
	public static Unsafe0 getUnsafe() {
		/*if (getCallerClass().getClassLoader()!=null && !getCallerClass().getPackage().getName().equals("one.jmaster.misc"))
			throw new SecurityException("unsafe");*/
		return theUnsafe;
	}

	@Generated("")
	private Unsafe0() {
		if (theUnsafe!=null) throwException0(ERROR);
	}


	@Override
	public long allocateMemory(long size) {
		try {
			return delegate().allocateMemory(size);
		} catch (ClassNotFoundException e) {
			return allocateMemory0(size);
		}
	}
	private native long allocateMemory0(long size);

	@Override
	public void freeMemory(long address) {
		try {
			delegate().freeMemory(address);
		} catch (ClassNotFoundException e) {
			freeMemory0(address);
		}
	}
	private native long freeMemory0(long address);


	/*
	@Deprecated
	public native Class<?> defineClass (String name, byte[] b, int off, int len,
					   ClassLoader loader,
					   ProtectionDomain protectionDomain);
	*/


	@Override
	public void throwException(Throwable ee) {
		try {
			delegate().throwException(ee);
		} catch (ClassNotFoundException e) {
			throwException0(ee);
		}
	}
	public native void throwException0(Throwable ee);

	public static Class<?> getCallerClass() {
		try {
			return Class.forName(new Throwable().getStackTrace()[2].getClassName());
		} catch (ClassNotFoundException e) {
			throw ERROR;
		}
	}

	/**
	 * @see Unsafe0#putChar0(long, char)
	 * */
	@Override
	public char getChar(long address) {
		try {
			return delegate().getChar(address);
		}catch (ClassNotFoundException e){
			return getChar0(address);
		}
	}
	private native char getChar0(long address);


	/**
	 * @see Unsafe0#putChar0(long, char)
	 * @param address where the symbol will be putted
	 * @param x character to be putted
	 */
	@Override
	public void putChar(long address, char x) {
		try {
			delegate().putChar(address, x);
		}catch (ClassNotFoundException e){
			putChar0(address,x);
		}
	}
	private native void putChar0(long address, char x);

	@Override
	public byte getByte(long address) {
		try {
			return delegate().getByte(address);
		} catch (ClassNotFoundException e) {
			return getByte0(address);
		}
	}
	private native byte getByte0(long address);
	@Override
	public void putByte(long address, byte x) {
		try {
			delegate().putByte(address, x);
		} catch (ClassNotFoundException e) {
			putByte0(address, x);
		}
	}
	private native void putByte0(long address, byte x);

	@Override
	public short getShort(long address) {
		try {
			return delegate().getShort(address);
		} catch (ClassNotFoundException e) {
			return getShort0(address);
		}
	}
	private native short getShort0(long address);
	@Override
	public void putShort(long address, short x) {
		try {
			delegate().putShort(address, x);
		} catch (ClassNotFoundException e) {
			putShort0(address, x);
		}
	}
	private native void putShort0(long address, short x);

	@Override
	public int getInt(long address) {
		try {
			return delegate().getInt(address);
		} catch (ClassNotFoundException e) {
			return getInt0(address);
		}
	}
	private native int getInt0(long address);


	@Override
	public void putInt(long address, int x) {
		try {
			delegate().putInt(address, x);
		} catch (ClassNotFoundException e) {
			putInt0(address, x);
		}
	}
	private native void putInt0(long address, int x);



	@Override
	public long getLong(long address) {
		try {
			return delegate().getLong(address);
		} catch (ClassNotFoundException e) {
			return getLong0(address);
		}
	}
	private native long getLong0(long address);
	@Override
	public void putLong(long address, long x) {
		try {
			delegate().putLong(address, x);
		} catch (ClassNotFoundException e) {
			putLong0(address, x);
		}
	}
	private native void putLong0(long address, long x);


	@Override
	public float getFloat(long address) {
		try {
			return delegate().getFloat(address);
		} catch (ClassNotFoundException e) {
			return getFloat0(address);
		}
	}
	private native float getFloat0(long address);




	@Override
	public void putFloat(long address, float x) {
		try {
			delegate().putFloat(address, x);
		} catch (ClassNotFoundException e) {
			putFloat0(address, x);
		}
	}
	private native void putFloat0(long address, float x);




	@Override
	public double getDouble(long address) {
		try {
			return delegate().getDouble(address);
		} catch (ClassNotFoundException e) {
			return getDouble0(address);
		}
	}
	private native double getDouble0(long address);




	@Override
	public void putDouble(long address, double x) {
		try {
			delegate().putDouble(address, x);
		} catch (ClassNotFoundException e) {
			putDouble0(address, x);
		}
	}
	private native void putDouble0(long address, double x);



	@Override
	public Object allocateInstance(Class<?> cls) {
		try {
			return delegate().allocateInstance(cls);
		} catch (InstantiationException | ClassNotFoundException e) {
			return allocateInstance0(cls);
		}
	}
	private native Object allocateInstance0(Class<?> cls);
	//private final Object obj = null;
	//public byte[] objectHeader(Object o) {
	//	final long offset;
	//	try {
	//		offset = objectFieldOffset(this.getClass().getDeclaredField("obj"));
	//	} catch (NoSuchFieldException e) {
	//		throwException(e);
	//		return null;
	//	}
	//	putObject(this, offset,o);
	//	byte[] b = new byte[12];
	//	for (int i = 0; i < b.length; i++) {
	//		b[i] = getByte(this,offset + i);
	//	}
	//	return b;
	//}
	public void printHeader(Object o) {
		System.out.println((o==null?"null":o.getClass().getName())+" {");
		final long offset;
		try {
			offset = objectFieldOffset(this.getClass().getDeclaredField("obj"));
		} catch (NoSuchFieldException e) {
			throwException(e);
			return;
		}
		putObject(this, offset,o);
		System.out.print("\tclassword: [");
		for (int i = 0; i < 4; i++) {
			System.out.print(""+getByte(this,offset + i) + (i==3?"]":", "));
		}
		System.out.println();
		System.out.print("\tmarkword: [");
		for (int i = 4; i < 12; i++) {
			System.out.print(""+getByte(this,offset + i) + (i==11?"]":", "));
		}
		System.out.println();
		System.out.println("}");
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
	@Override
	public native String toString();
	@Override
	public int hashCode() {
		return 0;
	}
}