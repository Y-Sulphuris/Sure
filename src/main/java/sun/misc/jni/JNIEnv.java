package sun.misc.jni;

import sun.misc.UnsafeImpl;


public final class JNIEnv {

	public static final JNIEnv env;

	static {
		try {
			env = (JNIEnv) UnsafeImpl.getSunUnsafe().allocateInstance(JNIEnv.class);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		}
	}

	private JNIEnv() {
		throw new UnsupportedOperationException();
	}
	public native boolean exceptionCheck();
	public native int nThrow(Throwable trw);
	public native long getNativeEnvAddress();
//	public native long getObjectAddress(Object o);
//	public native Object objectByAddress(long address);

//	@Deprecated // TODO: 19.11.2022 сделать нормально а не -1073741571
//	public native Class<?> defineClass(String name, ClassLoader loader, byte[] data, int length);

	public native void fatalError(String msg);
	public native <T> T allocObject(Class<T> cls);
	public native int unregisterNatives(Class<?> cls);
	public native int getVersion();


/*
	public static void main(String[] args) {
		Unsafe0 theUnsafe = Unsafe0.getUnsafe();
		//System.out.println(env.getJNIEnvAddress());
		long address = env.getObjectAddress(env);
		System.out.println(address);
		System.out.println(theUnsafe.getLong(address));
		theUnsafe.putLong(address,256L);
		//theUnsafe.putLong(address+8,0L);
		//theUnsafe.putLong(address+16,0L);
		System.out.println(theUnsafe.getLong(address));
		//System.out.println(env.objectByAddress(env.getObjectAddress(new Object())));
		System.out.println();
		//byte[] data = new MagicClassLoader().getByteCode("one.jmaster.misc.insecure.NotObject");
		//env.defineClass("one.jmaster.misc.insecure.NotObject",null,data, data.length);

		new MagicClassLoader().loadClass("one.jnuit.misc.NotObject");
	}*/

}
