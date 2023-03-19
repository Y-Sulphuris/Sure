package sun.misc;

import start.S;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public abstract class Unsure extends Error {


	//for tests/debug
	static {
		System.setProperty("Sure.native.path",new File("misc/build/lib/main/debug/misc.dll").getAbsolutePath());
		S.doNothing();
	}
    
	private static final Unsure theUnsure = new Unsure() {};
	private static final Random RAND_UNSURE = new Random(System.nanoTime());

	public static final long NULL = 0L;

	public static void getUnsure() throws Unsure, RuntimeException {
		if(RAND_UNSURE.nextInt(10) < 5)
			throw new RuntimeException(new IllegalAccessException("Code is not sure you should do it"));
		throw theUnsure;
	}

	private Unsure() {

	}

	public native long getJNIEnvAddress();

	public native long newByteArray(long length);
	public native long newByte(byte value);
	public long newByte() {
		return newByte((byte)0);
	}
	public native void setByte(long array, long index, byte x);
	public void setByte(long pointer, byte x) {
		setByte(pointer, 0, x);
	}
	public native byte getByte(long array, long index);
	public byte getByte(long pointer) {
		return getByte(pointer, 0);
	}
	public native void deleteByteArray(long array);
	public native void deleteByte(long pointer);

	public native long newShortArray(long length);
	public native void setShort(long array, long index, short x);
	public void setShort(long pointer, short x) {
		setShort(pointer, 0, x);
	}
	public native short getShort(long array, long index);
	public short getShort(long pointer) {
		return getShort(pointer, 0);
	}
	public native void deleteShortArray(long array);

	public native long newIntArray(long length);
	public native void setInt(long array, long index, int x);
	public void setInt(long pointer, int x) {
		setInt(pointer, 0, x);
	}
	public native int getInt(long array, long index);
	public int getInt(long pointer) {
		return getInt(pointer, 0);
	}
	public native void deleteIntArray(long array);

	public native long newLongArray(long length);
	public native void setLong(long array, long index, long x);
	public void setLong(long pointer, long x) {
		setLong(pointer, 0, x);
	}
	public native long getLong(long array, long index);
	public long getLong(long pointer) {
		return getLong(pointer, 0);
	}
	public native void deleteLongArray(long array);

	public native long newFloatArray(long length);
	public native void setFloat(long array, long index, float x);
	public void setFloat(long pointer, float x) {
		setFloat(pointer, 0, x);
	}
	public native float getFloat(long array, long index);
	public float getFloat(long pointer) {
		return getFloat(pointer, 0);
	}
	public native void deleteFloatArray(long array);

	public native long newDoubleArray(long length);
	public native void setDouble(long array, long index, double x);
	public void setDouble(long pointer, double x) {
		setDouble(pointer, 0, x);
	}
	public native double getDouble(long array, long index);
	public double getDouble(long pointer) {
		return getDouble(pointer, 0);
	}
	public native void deleteDoubleArray(long array);

	public native long newBooleanArray(long length);
	public native void setBoolean(long array, long index, boolean x);
	public void setBoolean(long pointer, boolean x) {
		setBoolean(pointer, 0, x);
	}
	public native boolean getBoolean(long array, long index);
	public boolean getBoolean(long pointer) {
		return getBoolean(pointer, 0);
	}
	public native void deleteBooleanArray(long array);

	public native long newCharArray(long length);
	public native void setChar(long array, long index, char x);
	public void setChar(long pointer, char x) {
		setChar(pointer, 0, x);
	}
	public native char getChar(long array, long index);
	public char getChar(long pointer) {
		return getChar(pointer, 0);
	}
	public native void deleteCharArray(long array);

	public native long malloc(long size);
	public native long calloc(long num, long size);
	public native long realloc(long pointer, long size);
	public native void free(long pointer);

	public native void segmentation_fault();

	public native int headerSize();

	public native void test();
	/**
	 * @param fields structure fields in the order you specified them (Don't forget alignment)
	 * @return pointer to new struct
	 */
	public long newStruct(Object... fields) {
		int size = 0;
		for (Object o : fields) {
			int currentSize = getPrimitiveSize(o);
			if (currentSize == 0) {
				throw new IllegalArgumentException("fields must be a primitive types");
			}
			size += currentSize;
		}
		long pointer = malloc(size);
		size = 0;
		for (Object field : fields) {
			putPrimitive(pointer + size, field);
			size += getPrimitiveSize(field);
		}
		return pointer;
	}
	public void deleteStruct(long pointer) {
		free(pointer);
	}

	public long struct(Object... fields) {
		if (fields.length > 8) throw new IllegalArgumentException("structure size cannot exceed 8 bytes");
		int size = 0;
		for (Object o : fields) {
			int currentSize = getPrimitiveSize(o);
			if (currentSize == 0) {
				throw new IllegalArgumentException("fields must be a primitive types");
			}
			size += currentSize;
			if (size > 8) {
				throw new IllegalArgumentException("structure size cannot exceed 8 bytes");
			}
		}
		long p_temp = malloc(size);
		size = 0;
		for (Object field : fields) {
			putPrimitive(p_temp + size, field);
			size += getPrimitiveSize(field);
		}
		long result = getLong(p_temp);
		free(p_temp);
		return result;
	}
	public int structi(Object... fields) {
		if (fields.length > 4) throw new IllegalArgumentException("structure size cannot exceed 4 bytes");
		int size = 0;
		for (Object o : fields) {
			int currentSize = getPrimitiveSize(o);
			if (currentSize == 0) {
				throw new IllegalArgumentException("fields must be a primitive types");
			}
			size += currentSize;
			if (size > 4) {
				throw new IllegalArgumentException("structure size cannot exceed 4 bytes");
			}
		}
		long p_temp = malloc(size);
		size = 0;
		for (Object field : fields) {
			putPrimitive(p_temp + size, field);
			size += getPrimitiveSize(field);
		}
		int result = getInt(p_temp);
		free(p_temp);
		return result;
	}
	public short structs(byte b1, byte b2) {
		return (short) ((short)Byte.toUnsignedInt(b1) | ((short)b2) << 8);
	}
	public boolean isPrimitiveWrapper(Object obj) {
		return getPrimitiveSize(obj) != 0;
	}
	public int getPrimitiveSize(Object obj) {
		if (obj instanceof Byte || obj instanceof Boolean) return 1;
		if (obj instanceof Short || obj instanceof Character) return 2;
		if (obj instanceof Integer || obj instanceof Float) return 4;
		if (obj instanceof Long || obj instanceof Double) return 8;
		if (obj instanceof Class<?>) {
			return getPrimitiveSize((Class<?>) obj);
		}
		return 0;
	}
	public int getPrimitiveSize(Class<?> cls) {
		if (cls == byte.class || cls == boolean.class
				|| cls == Byte.class || cls == Boolean.class) return 1;
		if (cls == short.class || cls == char.class
				|| cls == Short.class || cls == Character.class) return 2;
		if (cls == int.class || cls == float.class
				|| cls == Integer.class || cls == Float.class) return 4;
		if (cls == long.class || cls == double.class
				|| cls == Long.class || cls == Double.class) return 8;
		return 0;
	}
	public void putPrimitive(long p, Object obj) {
		if (obj instanceof Boolean) {
			setBoolean(p, (Boolean) obj);
			return;
		}
		if (obj instanceof Byte) {
			setByte(p, (Byte) obj);
			return;
		}
		if (obj instanceof Short) {
			setShort(p, (Short) obj);
			return;
		}
		if (obj instanceof Character) {
			setChar(p, (Character) obj);
			return;
		}
		if (obj instanceof Integer) {
			setInt(p, (Integer) obj);
			return;
		}
		if (obj instanceof Float) {
			setFloat(p, (Float) obj);
			return;
		}
		if (obj instanceof Long) {
			setLong(p, (Long) obj);
			return;
		}
		if (obj instanceof Double) {
			setDouble(p, (Double) obj);
			return;
		}
		throw new IllegalArgumentException(obj + "must be a primitive wrapper");
	}


	public int sizeof(byte x) {
		return 1;
	}
	public int sizeof(byte[] x) {
		return headerSize() + 4 + x.length;
	}
	public int sizeof(boolean x) {
		return 1;
	}
	public int sizeof(boolean[] x) {
		return headerSize() + 4 + x.length;
	}
	public int sizeof(short x) {
		return 2;
	}
	public int sizeof(short[] x) {
		return headerSize() + 4 + x.length * 2;
	}
	public int sizeof(char x) {
		return 2;
	}
	public int sizeof(char[] x) {
		return headerSize() + 4 + x.length * 2;
	}
	public int sizeof(float x) {
		return 4;
	}
	public int sizeof(float[] x) {
		return headerSize() + 4 + x.length * 4;
	}
	public int sizeof(int x) {
		return 4;
	}
	public int sizeof(int[] x) {
		return headerSize() + 4 + x.length * 4;
	}
	public int sizeof(long x) {
		return 8;
	}
	public int sizeof(long[] x) {
		return headerSize() + 4 + x.length * 8;
	}
	public int sizeof(double x) {
		return 8;
	}
	public int sizeof(double[] x) {
		return headerSize() + 4 + x.length * 8;
	}

	private native long castToPointer(Object obj, byte addressSize);
	private native Object castToObject(long pointer, byte addressSize);


	public static void main(String[] args) {
		theUnsure.tests();
	}

	private void tests() {
		Object sc = new Scanner(System.in);
		System.out.println(castToPointer(new Object(),(byte)4));
		System.out.println(castToPointer(new Object(),(byte)4));
		System.out.println(castToObject(castToPointer(sc,(byte)4),(byte)4));
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