package sun.misc;

import one.misc.Unsafe0;
import sun.reflect.MagicAccessor;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

final class _var1 extends MagicAccessor {
	_var1(Unsafe0 unsafe, _var1... vars) {
		if (vars.length<2 || vars[0]==vars[1])
			unsafe.throwException(new ClassCastException());
		unsafe.park(true,Long.MAX_VALUE);
		new _var3(){}.crachJVM();
	}

	public Object allocateInstance(_var1 var1) {
		//if (var1 == getClass()) return null;
		return new _var1(Unsafe0.getUnsafe(),var1,this);
	}


	public Class<?> t() {
		return _var1.class;
	}

}



final class _var2 {
	static final Unsafe THE_ONE = getSunUnsafe();

	private static Unsafe getSunUnsafe() {
		final Field[] fields = Unsafe.class.getDeclaredFields();

		/*
		Different runtimes use different names for the Unsafe singleton,
		so we cannot use .getDeclaredField and we scan instead. For example:

		Oracle: theUnsafe
		PERC : m_unsafe_instance
		Android: THE_ONE
		*/
		for ( Field field : fields ) {
			if ( !field.getType().equals(Unsafe.class) )
				continue;

			final int modifiers = field.getModifiers();
			if ( !(Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) )
				continue;

			field.setAccessible(true);
			try {
				return (Unsafe)field.get(null);
			} catch (IllegalAccessException e) {
				// ignore
			}
			break;
		}

		throw new UnsupportedOperationException();
	}


	static UnsafeImpl allocateTEU() {
		return new UnsafeImpl() {
			@Override
			public int getInt(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putInt(Object o, long offset, int x) {
				throw new IllegalAccessError();
			}

			@Override
			public Object getObject(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putObject(Object o, long offset, Object x) {
				throw new IllegalAccessError();
			}

			@Override
			public boolean getBoolean(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putBoolean(Object o, long offset, boolean x) {
				throw new IllegalAccessError();
			}

			@Override
			public byte getByte(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putByte(Object o, long offset, byte x) {
				throw new IllegalAccessError();
			}

			@Override
			public short getShort(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putShort(Object o, long offset, short x) {
				throw new IllegalAccessError();
			}

			@Override
			public char getChar(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putChar(Object o, long offset, char x) {
				throw new IllegalAccessError();
			}

			@Override
			public long getLong(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putLong(Object o, long offset, long x) {
				throw new IllegalAccessError();
			}

			@Override
			public float getFloat(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putFloat(Object o, long offset, float x) {
				throw new IllegalAccessError();
			}

			@Override
			public double getDouble(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putDouble(Object o, long offset, double x) {
				throw new IllegalAccessError();
			}

			@Override
			public int getInt(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putInt(Object o, int offset, int x) {
				throw new IllegalAccessError();
			}

			@Override
			public Object getObject(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putObject(Object o, int offset, Object x) {
				throw new IllegalAccessError();
			}

			@Override
			public boolean getBoolean(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putBoolean(Object o, int offset, boolean x) {
				throw new IllegalAccessError();
			}

			@Override
			public byte getByte(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putByte(Object o, int offset, byte x) {
				throw new IllegalAccessError();
			}

			@Override
			public short getShort(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putShort(Object o, int offset, short x) {
				throw new IllegalAccessError();
			}

			@Override
			public char getChar(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putChar(Object o, int offset, char x) {
				throw new IllegalAccessError();
			}

			@Override
			public long getLong(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putLong(Object o, int offset, long x) {
				throw new IllegalAccessError();
			}

			@Override
			public float getFloat(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putFloat(Object o, int offset, float x) {
				throw new IllegalAccessError();
			}

			@Override
			public double getDouble(Object o, int offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putDouble(Object o, int offset, double x) {
				throw new IllegalAccessError();
			}

			@Override
			public byte getByte(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public void putByte(long address, byte x) {
				throw new IllegalAccessError();
			}

			@Override
			public short getShort(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public void putShort(long address, short x) {
				throw new IllegalAccessError();
			}

			@Override
			public char getChar(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public void putChar(long address, char x) {
				throw new IllegalAccessError();
			}

			@Override
			public int getInt(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public void putInt(long address, int x) {
				throw new IllegalAccessError();
			}

			@Override
			public long getLong(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public void putLong(long address, long x) {
				throw new IllegalAccessError();
			}

			@Override
			public float getFloat(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public void putFloat(long address, float x) {
				throw new IllegalAccessError();
			}

			@Override
			public double getDouble(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public void putDouble(long address, double x) {
				throw new IllegalAccessError();
			}

			@Override
			public long getAddress(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public void putAddress(long address, long x) {
				throw new IllegalAccessError();
			}

			@Override
			public long allocateMemory(long bytes) {
				throw new IllegalAccessError();
			}

			@Override
			public long reallocateMemory(long address, long bytes) {
				throw new IllegalAccessError();
			}

			@Override
			public void setMemory(Object o, long offset, long bytes, byte value) {
				throw new IllegalAccessError();
			}

			@Override
			public void setMemory(long address, long bytes, byte value) {
				throw new IllegalAccessError();
			}

			@Override
			public void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
				throw new IllegalAccessError();
			}

			@Override
			public void copyMemory(long srcAddress, long destAddress, long bytes) {
				throw new IllegalAccessError();
			}

			@Override
			public void freeMemory(long address) {
				throw new IllegalAccessError();
			}

			@Override
			public int fieldOffset(Field f) {
				throw new IllegalAccessError();
			}

			@Override
			public Object staticFieldBase(Class<?> c) {
				throw new IllegalAccessError();
			}

			@Override
			public long staticFieldOffset(Field f) {
				throw new IllegalAccessError();
			}

			@Override
			public long objectFieldOffset(Field f) {
				throw new IllegalAccessError();
			}

			@Override
			public Object staticFieldBase(Field f) {
				throw new IllegalAccessError();
			}

			@Override
			public boolean shouldBeInitialized(Class<?> c) {
				throw new IllegalAccessError();
			}

			@Override
			public void ensureClassInitialized(Class<?> c) {
				throw new IllegalAccessError();
			}

			@Override
			public int arrayBaseOffset(Class<?> arrayClass) {
				throw new IllegalAccessError();
			}

			@Override
			public int arrayIndexScale(Class<?> arrayClass) {
				throw new IllegalAccessError();
			}

			@Override
			public int addressSize() {
				throw new IllegalAccessError();
			}

			@Override
			public int pageSize() {
				throw new IllegalAccessError();
			}

			@Override
			public Class<?> defineClass(String name, byte[] b, int off, int len, ClassLoader loader, ProtectionDomain protectionDomain) {
				throw new IllegalAccessError();
			}

			@Override
			public Class<?> defineAnonymousClass(Class<?> hostClass, byte[] data, Object[] cpPatches) {
				throw new IllegalAccessError();
			}

			@Override
			public Object allocateInstance(Class<?> cls) throws InstantiationException {
				throw new IllegalAccessError();
			}

			@Override
			public void monitorEnter(Object o) {
				throw new IllegalAccessError();
			}

			@Override
			public void monitorExit(Object o) {
				throw new IllegalAccessError();
			}

			@Override
			public boolean tryMonitorEnter(Object o) {
				throw new IllegalAccessError();
			}

			@Override
			public void throwException(Throwable ee) {
				throw new IllegalAccessError();
			}

			@Override
			public boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) {
				throw new IllegalAccessError();
			}

			@Override
			public boolean compareAndSwapInt(Object o, long offset, int expected, int x) {
				throw new IllegalAccessError();
			}

			@Override
			public boolean compareAndSwapLong(Object o, long offset, long expected, long x) {
				throw new IllegalAccessError();
			}

			@Override
			public Object getObjectVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putObjectVolatile(Object o, long offset, Object x) {
				throw new IllegalAccessError();
			}

			@Override
			public int getIntVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putIntVolatile(Object o, long offset, int x) {
				throw new IllegalAccessError();
			}

			@Override
			public boolean getBooleanVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putBooleanVolatile(Object o, long offset, boolean x) {
				throw new IllegalAccessError();
			}

			@Override
			public byte getByteVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putByteVolatile(Object o, long offset, byte x) {
				throw new IllegalAccessError();
			}

			@Override
			public short getShortVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putShortVolatile(Object o, long offset, short x) {
				throw new IllegalAccessError();
			}

			@Override
			public char getCharVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putCharVolatile(Object o, long offset, char x) {
				throw new IllegalAccessError();
			}

			@Override
			public long getLongVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putLongVolatile(Object o, long offset, long x) {
				throw new IllegalAccessError();
			}

			@Override
			public float getFloatVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putFloatVolatile(Object o, long offset, float x) {
				throw new IllegalAccessError();
			}

			@Override
			public double getDoubleVolatile(Object o, long offset) {
				throw new IllegalAccessError();
			}

			@Override
			public void putDoubleVolatile(Object o, long offset, double x) {
				throw new IllegalAccessError();
			}

			@Override
			public void putOrderedObject(Object o, long offset, Object x) {
				throw new IllegalAccessError();
			}

			@Override
			public void putOrderedInt(Object o, long offset, int x) {
				throw new IllegalAccessError();
			}

			@Override
			public void putOrderedLong(Object o, long offset, long x) {
				throw new IllegalAccessError();
			}

			@Override
			public void unpark(Object thread) {
				throw new IllegalAccessError();
			}

			@Override
			public void park(boolean isAbsolute, long time) {
				throw new IllegalAccessError();
			}

			@Override
			public int getLoadAverage(double[] loadavg, int nelems) {
				throw new IllegalAccessError();
			}

			@Override
			public int getAndAddInt(Object o, long offset, int delta) {
				throw new IllegalAccessError();
			}

			@Override
			public long getAndAddLong(Object o, long offset, long delta) {
				throw new IllegalAccessError();
			}

			@Override
			public int getAndSetInt(Object o, long offset, int newValue) {
				throw new IllegalAccessError();
			}

			@Override
			public long getAndSetLong(Object o, long offset, long newValue) {
				throw new IllegalAccessError();
			}

			@Override
			public Object getAndSetObject(Object o, long offset, Object newValue) {
				throw new IllegalAccessError();
			}

			@Override
			public void loadFence() {
				throw new IllegalAccessError();
			}

			@Override
			public void storeFence() {
				throw new IllegalAccessError();
			}

			@Override
			public void fullFence() {
				throw new IllegalAccessError();
			}

			@Override
			public int hashCode() {
				throw new IllegalAccessError();
			}

			@Override
			public boolean equals(Object obj) {
				throw new IllegalAccessError();
			}

			@Override
			protected Object clone() throws CloneNotSupportedException {
				throw new IllegalAccessError();
			}

			@Override
			public String toString() {
				throw new IllegalAccessError();
			}
		};

	}
}

abstract class _var3 implements _var5{
	_var3 crachJVM() {
		Unsafe0.getUnsafe().getByte(0x00);
		return this;
	}

}
enum _var4 {

}
interface _var5 {
	//Service interface



	static void anyMethod() {
	//...
	AccessController. doPrivileged (new PrivilegedAction() {
		public Object run () {

			Unsafe.getUnsafe();
			return null;

		}
	}); //...
	}

	public static void main(String[] args) {
		anyMethod();
	}
}
