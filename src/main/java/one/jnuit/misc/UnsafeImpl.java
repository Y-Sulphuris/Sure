package one.jnuit.misc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;

public interface UnsafeImpl {

	public final static UnsafeImpl ALLOCATED_UNSAFE = new UnsafeImpl() {};
	public final static UnsafeImpl ALLOCATE_TEU = _var2.allocateTEU();
	


	static Unsafe getSunUnsafe() {
		return _var2.THE_ONE;
	}

	/**
	 * Fetches a value from a given Java variable.
	 * More specifically, fetches a field or array element within the given
	 * object <code>o</code> at the given offset, or (if <code>o</code> is
	 * null) from the memory address whose numerical value is the given
	 * offset.
	 * <p>
	 * The results are undefined unless one of the following cases is true:
	 * <ul>
	 * <li>The offset was obtained from {@link #objectFieldOffset} on
	 * the {@link java.lang.reflect.Field} of some Java field and the object
	 * referred to by <code>o</code> is of a class compatible with that
	 * field's class.
	 *
	 * <li>The offset and object reference <code>o</code> (either null or
	 * non-null) were both obtained via {@link #staticFieldOffset}
	 * and {@link #staticFieldBase} (respectively) from the
	 * reflective {@link Field} representation of some Java field.
	 *
	 * <li>The object referred to by <code>o</code> is an array, and the offset
	 * is an integer of the form <code>B+N*S</code>, where <code>N</code> is
	 * a valid index into the array, and <code>B</code> and <code>S</code> are
	 * the values obtained by {@link #arrayBaseOffset} and {@link
	 * #arrayIndexScale} (respectively) from the array's class.  The value
	 * referred to is the <code>N</code><em>th</em> element of the array.
	 *
	 * </ul>
	 * <p>
	 * If one of the above cases is true, the call references a specific Java
	 * variable (field or array element).  However, the results are undefined
	 * if that variable is not in fact of the type returned by this method.
	 * <p>
	 * This method refers to a variable by means of two parameters, and so
	 * it provides (in effect) a <em>double-register</em> addressing mode
	 * for Java variables.  When the object reference is null, this method
	 * uses its offset as an absolute address.  This is similar in operation
	 * to methods such as {@link #getInt(long)}, which provide (in effect) a
	 * <em>single-register</em> addressing mode for non-Java variables.
	 * However, because Java variables may have a different layout in memory
	 * from non-Java variables, programmers should not assume that these
	 * two addressing modes are ever equivalent.  Also, programmers should
	 * remember that offsets from the double-register addressing mode cannot
	 * be portably confused with longs used in the single-register addressing
	 * mode.
	 *
	 * @param o Java heap object in which the variable resides, if any, else
	 *        null
	 * @param offset indication of where the variable resides in a Java heap
	 *        object, if any, else a memory address locating the variable
	 *        statically
	 * @return the value fetched from the indicated Java variable
	 * @throws RuntimeException No defined exceptions are thrown, not even
	 *         {@link NullPointerException}
	 */
	default int getInt(Object o, long offset) {
		return getSunUnsafe().getInt(o, offset);
	}
	/**
	 * Stores a value into a given Java variable.
	 * <p>
	 * The first two parameters are interpreted exactly as with
	 * {@link #getInt(Object, long)} to refer to a specific
	 * Java variable (field or array element).  The given value
	 * is stored into that variable.
	 * <p>
	 * The variable must be of the same type as the method
	 * parameter <code>x</code>.
	 *
	 * @param o Java heap object in which the variable resides, if any, else
	 *        null
	 * @param offset indication of where the variable resides in a Java heap
	 *        object, if any, else a memory address locating the variable
	 *        statically
	 * @param x the value to store into the indicated Java variable
	 * @throws RuntimeException No defined exceptions are thrown, not even
	 *         {@link NullPointerException}
	 */
	default void putInt(Object o, long offset, int x) {
		getSunUnsafe().putInt(o, offset, x);
	}
	/**
	 * Fetches a reference value from a given Java variable.
	 * @see #getInt(Object, long)
	 */
	default Object getObject(Object o, long offset) {
		return getSunUnsafe().getObject(o, offset);
	}
	/**
	 * Stores a reference value into a given Java variable.
	 * <p>
	 * Unless the reference <code>x</code> being stored is either null
	 * or matches the field type, the results are undefined.
	 * If the reference <code>o</code> is non-null, car marks or
	 * other store barriers for that object (if the VM requires them)
	 * are updated.
	 * @see #putInt(Object, int, int)
	 */
	default void putObject(Object o, long offset, Object x) {
		getSunUnsafe().putObject(o, offset, x);
	}
	default boolean getBoolean(Object o, long offset) {
		return getSunUnsafe().getBoolean(o, offset);
	}

	default void    putBoolean(Object o, long offset, boolean x) {
		getSunUnsafe().putBoolean(o, offset, x);
	}
	/** @see #getInt(Object, long) */
	default byte    getByte(Object o, long offset) {
		return getSunUnsafe().getByte(o, offset);
	}
	/** @see #putInt(Object, int, int) */
	default void    putByte(Object o, long offset, byte x) {
		getSunUnsafe().putByte(o, offset, x);
	}
	/** @see #getInt(Object, long) */
	default short   getShort(Object o, long offset) {
		return getSunUnsafe().getShort(o, offset);
	}
	/** @see #putInt(Object, int, int) */
	default void    putShort(Object o, long offset, short x) {
		getSunUnsafe().putShort(o, offset, x);
	}
	/** @see #getInt(Object, long) */
	default char    getChar(Object o, long offset) {
		return getSunUnsafe().getChar(o, offset);
	}
	/** @see #putInt(Object, int, int) */
	default void    putChar(Object o, long offset, char x) {
		getSunUnsafe().putChar(o, offset,x);
	}
	/** @see #getInt(Object, long) */
	default long    getLong(Object o, long offset) {
		return getSunUnsafe().getLong(o, offset);
	}
	/** @see #putInt(Object, int, int) */
	default void    putLong(Object o, long offset, long x) {
		getSunUnsafe().putLong(o, offset,x);
	}
	/** @see #getInt(Object, long) */
	default float   getFloat(Object o, long offset) {
		return getSunUnsafe().getFloat(o, offset);
	}
	/** @see #putInt(Object, int, int) */
	default void    putFloat(Object o, long offset, float x) {
		getSunUnsafe().putFloat(o, offset,x);
	}
	/** @see #getInt(Object, long) */
	default double  getDouble(Object o, long offset) {
		return getSunUnsafe().getDouble(o, offset);
	}
	/** @see #putInt(Object, int, int) */
	default void    putDouble(Object o, long offset, double x) {
		getSunUnsafe().putDouble(o, offset, x);
	}

	/**
	 * This method, like all others with 32-bit offsets, was native
	 * in a previous release but is now a wrapper which simply casts
	 * the offset to a long value.  It provides backward compatibility
	 * with bytecodes compiled against 1.4.
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default int getInt(Object o, int offset) {
		return getInt(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putInt(Object o, int offset, int x) {
		putInt(o, (long)offset, x);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default Object getObject(Object o, int offset) {
		return getObject(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putObject(Object o, int offset, Object x) {
		putObject(o, (long)offset, x);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default boolean getBoolean(Object o, int offset) {
		return getBoolean(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putBoolean(Object o, int offset, boolean x) {
		putBoolean(o, (long)offset, x);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default byte getByte(Object o, int offset) {
		return getByte(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putByte(Object o, int offset, byte x) {
		putByte(o, (long)offset, x);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default short getShort(Object o, int offset) {
		return getShort(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putShort(Object o, int offset, short x) {
		putShort(o, (long)offset, x);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default char getChar(Object o, int offset) {
		return getChar(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putChar(Object o, int offset, char x) {
		putChar(o, (long)offset, x);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default long getLong(Object o, int offset) {
		return getLong(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putLong(Object o, int offset, long x) {
		putLong(o, (long)offset, x);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default float getFloat(Object o, int offset) {
		return getFloat(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putFloat(Object o, int offset, float x) {
		putFloat(o, (long)offset, x);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default double getDouble(Object o, int offset) {
		return getDouble(o, (long)offset);
	}

	/**
	 * @deprecated As of 1.4.1, cast the 32-bit offset argument to a long.
	 * See {@link #staticFieldOffset}.
	 */
	@Deprecated
	default void putDouble(Object o, int offset, double x) {
		putDouble(o, (long)offset, x);
	}

	// These work on values in the C heap.

	/**
	 * Fetches a value from a given memory address.  If the address is zero, or
	 * does not point into a block obtained from {@link #allocateMemory}, the
	 * results are undefined.
	 *
	 * @see #allocateMemory
	 */
	default byte    getByte(long address) {
		return getSunUnsafe().getByte(address);
	}

	/**
	 * Stores a value into a given memory address.  If the address is zero, or
	 * does not point into a block obtained from {@link #allocateMemory}, the
	 * results are undefined.
	 *
	 * @see #getByte(long)
	 */
	default void    putByte(long address, byte x) {
		getSunUnsafe().putLong(address, x);
	}

	/** @see #getByte(long) */
	default short getShort(long address) {
		return getSunUnsafe().getShort(address);
	}
	/** @see #putByte(long, byte) */
	default void    putShort(long address, short x) {
		getSunUnsafe().putShort(address, x);
	}
	/** @see #getByte(long) */
	default char    getChar(long address) {
		return getSunUnsafe().getChar(address);
	}
	/** @see #putByte(long, byte) */
	default void    putChar(long address, char x) {
		getSunUnsafe().putChar(address, x);
	}
	/** @see #getByte(long) */
	default int     getInt(long address) {
		return getSunUnsafe().getInt(address);
	}
	/** @see #putByte(long, byte) */
	default void    putInt(long address, int x) {
		getSunUnsafe().putInt(address, x);
	}
	/** @see #getByte(long) */
	default long    getLong(long address) {
		return getSunUnsafe().getLong(address);
	}
	/** @see #putByte(long, byte) */
	default void    putLong(long address, long x) {
		getSunUnsafe().putLong(address, x);
	}
	/** @see #getByte(long) */
	default float   getFloat(long address) {
		return getSunUnsafe().getFloat(address);
	}
	/** @see #putByte(long, byte) */
	default void    putFloat(long address, float x) {
		getSunUnsafe().putFloat(address, x);
	}
	/** @see #getByte(long) */
	default double  getDouble(long address) {
		return getSunUnsafe().getDouble(address);
	}
	/** @see #putByte(long, byte) */
	default void    putDouble(long address, double x) {
		getSunUnsafe().putDouble(address,x);
	}

	/**
	 * Fetches a native pointer from a given memory address.  If the address is
	 * zero, or does not point into a block obtained from {@link
	 * #allocateMemory}, the results are undefined.
	 *
	 * <p> If the native pointer is less than 64 bits wide, it is extended as
	 * an unsigned number to a Java long.  The pointer may be indexed by any
	 * given byte offset, simply by adding that offset (as a simple integer) to
	 * the long representing the pointer.  The number of bytes actually read
	 * from the target address maybe determined by consulting {@link
	 * #addressSize}.
	 *
	 * @see #allocateMemory
	 */
	default long getAddress(long address) {
		return getSunUnsafe().getAddress(address);
	}

	/**
	 * Stores a native pointer into a given memory address.  If the address is
	 * zero, or does not point into a block obtained from {@link
	 * #allocateMemory}, the results are undefined.
	 *
	 * <p> The number of bytes actually written at the target address maybe
	 * determined by consulting {@link #addressSize}.
	 *
	 * @see #getAddress(long)
	 */
	default void putAddress(long address, long x) {
		getSunUnsafe().putAddress(address,x);
	}

	/// wrappers for malloc, realloc, free:

	/**
	 * Allocates a new block of native memory, of the given size in bytes.  The
	 * contents of the memory are uninitialized; they will generally be
	 * garbage.  The resulting native pointer will never be zero, and will be
	 * aligned for all value types.  Dispose of this memory by calling {@link
	 * #freeMemory}, or resize it with {@link #reallocateMemory}.
	 *
	 * @throws IllegalArgumentException if the size is negative or too large
	 *         for the native size_t type
	 *
	 * @throws OutOfMemoryError if the allocation is refused by the system
	 *
	 * @see #getByte(long)
	 * @see #putByte(long, byte)
	 */
	default long allocateMemory(long bytes) {
		return getSunUnsafe().allocateMemory(bytes);
	}

	/**
	 * Resizes a new block of native memory, to the given size in bytes.  The
	 * contents of the new block past the size of the old block are
	 * uninitialized; they will generally be garbage.  The resulting native
	 * pointer will be zero if and only if the requested size is zero.  The
	 * resulting native pointer will be aligned for all value types.  Dispose
	 * of this memory by calling {@link #freeMemory}, or resize it with {@link
	 * #reallocateMemory}.  The address passed to this method may be null, in
	 * which case an allocation will be performed.
	 *
	 * @throws IllegalArgumentException if the size is negative or too large
	 *         for the native size_t type
	 *
	 * @throws OutOfMemoryError if the allocation is refused by the system
	 *
	 * @see #allocateMemory
	 */
	default long reallocateMemory(long address, long bytes) {
		return getSunUnsafe().reallocateMemory(address,bytes);
	}

	/**
	 * Sets all bytes in a given block of memory to a fixed value
	 * (usually zero).
	 *
	 * <p>This method determines a block's base address by means of two parameters,
	 * and so it provides (in effect) a <em>double-register</em> addressing mode,
	 * as discussed in {@link #getInt(Object,long)}.  When the object reference is null,
	 * the offset supplies an absolute base address.
	 *
	 * <p>The stores are in coherent (atomic) units of a size determined
	 * by the address and length parameters.  If the effective address and
	 * length are all even modulo 8, the stores take place in 'long' units.
	 * If the effective address and length are (resp.) even modulo 4 or 2,
	 * the stores take place in units of 'int' or 'short'.
	 *
	 * @since 1.7
	 */
	default void setMemory(Object o, long offset, long bytes, byte value) {
		getSunUnsafe().setMemory(o, offset, bytes, value);
	}

	/**
	 * Sets all bytes in a given block of memory to a fixed value
	 * (usually zero).  This provides a <em>single-register</em> addressing mode,
	 * as discussed in {@link #getInt(Object,long)}.
	 *
	 * <p>Equivalent to <code>setMemory(null, address, bytes, value)</code>.
	 */
	default void setMemory(long address, long bytes, byte value) {
		setMemory(null, address, bytes, value);
	}

	/**
	 * Sets all bytes in a given block of memory to a copy of another
	 * block.
	 *
	 * <p>This method determines each block's base address by means of two parameters,
	 * and so it provides (in effect) a <em>double-register</em> addressing mode,
	 * as discussed in {@link #getInt(Object,long)}.  When the object reference is null,
	 * the offset supplies an absolute base address.
	 *
	 * <p>The transfers are in coherent (atomic) units of a size determined
	 * by the address and length parameters.  If the effective addresses and
	 * length are all even modulo 8, the transfer takes place in 'long' units.
	 * If the effective addresses and length are (resp.) even modulo 4 or 2,
	 * the transfer takes place in units of 'int' or 'short'.
	 *
	 * @since 1.7
	 */
	default void copyMemory(Object srcBase, long srcOffset,
				      Object destBase, long destOffset,
				      long bytes) {
		getSunUnsafe().copyMemory(srcBase, srcOffset, destBase, destOffset, bytes);
	}
	/**
	 * Sets all bytes in a given block of memory to a copy of another
	 * block.  This provides a <em>single-register</em> addressing mode,
	 * as discussed in {@link #getInt(Object,long)}.
	 *
	 * Equivalent to <code>copyMemory(null, srcAddress, null, destAddress, bytes)</code>.
	 */
	default void copyMemory(long srcAddress, long destAddress, long bytes) {
		copyMemory(null, srcAddress, null, destAddress, bytes);
	}

	/**
	 * Disposes of a block of native memory, as obtained from {@link
	 * #allocateMemory} or {@link #reallocateMemory}.  The address passed to
	 * this method may be null, in which case no action is taken.
	 *
	 * @see #allocateMemory
	 */
	default void freeMemory(long address) {
		getSunUnsafe().freeMemory(address);
	}

	/// random queries

	/**
	 * This constant differs from all results that will ever be returned from
	 * {@link #staticFieldOffset}, {@link #objectFieldOffset},
	 * or {@link #arrayBaseOffset}.
	 */
	public static final int INVALID_FIELD_OFFSET   = -1;

	/**
	 * Returns the offset of a field, truncated to 32 bits.
	 * This method is implemented as follows:
	 * <blockquote><pre>
	 * default int fieldOffset(Field f) {
	 *     if (Modifier.isStatic(f.getModifiers()))
	 *         return (int) staticFieldOffset(f);
	 *     else
	 *         return (int) objectFieldOffset(f);
	 * }
	 * </pre></blockquote>
	 * @deprecated As of 1.4.1, use {@link #staticFieldOffset} for static
	 * fields and {@link #objectFieldOffset} for non-static fields.
	 */
	@Deprecated
	default int fieldOffset(Field f) {
		if (Modifier.isStatic(f.getModifiers()))
			return (int) staticFieldOffset(f);
		else
			return (int) objectFieldOffset(f);
	}

	/**
	 * Returns the base address for accessing some static field
	 * in the given class.  This method is implemented as follows:
	 * <blockquote><pre>
	 * default Object staticFieldBase(Class c) {
	 *     Field[] fields = c.getDeclaredFields();
	 *     for (int i = 0; i < fields.length; i++) {
	 *         if (Modifier.isStatic(fields[i].getModifiers())) {
	 *             return staticFieldBase(fields[i]);
	 *         }
	 *     }
	 *     return null;
	 * }
	 * </pre></blockquote>
	 * @deprecated As of 1.4.1, use {@link #staticFieldBase(Field)}
	 * to obtain the base pertaining to a specific {@link Field}.
	 * This method works only for JVMs which store all statics
	 * for a given class in one place.
	 */
	@Deprecated
	default Object staticFieldBase(Class<?> c) {
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (Modifier.isStatic(fields[i].getModifiers())) {
				return staticFieldBase(fields[i]);
			}
		}
		return null;
	}

	/**
	 * Report the location of a given field in the storage allocation of its
	 * class.  Do not expect to perform any sort of arithmetic on this offset;
	 * it is just a cookie which is passed to the unsafe heap memory accessors.
	 *
	 * <p>Any given field will always have the same offset and base, and no
	 * two distinct fields of the same class will ever have the same offset
	 * and base.
	 *
	 * <p>As of 1.4.1, offsets for fields are represented as long values,
	 * although the Sun JVM does not use the most significant 32 bits.
	 * However, JVM implementations which store static fields at absolute
	 * addresses can use long offsets and null base pointers to express
	 * the field locations in a form usable by {@link #getInt(Object,long)}.
	 * Therefore, code which will be ported to such JVMs on 64-bit platforms
	 * must preserve all bits of static field offsets.
	 * @see #getInt(Object, long)
	 */
	default long staticFieldOffset(Field f) {
		return getSunUnsafe().staticFieldOffset(f);
	}

	/**
	 * Report the location of a given static field, in conjunction with {@link
	 * #staticFieldBase}.
	 * <p>Do not expect to perform any sort of arithmetic on this offset;
	 * it is just a cookie which is passed to the unsafe heap memory accessors.
	 *
	 * <p>Any given field will always have the same offset, and no two distinct
	 * fields of the same class will ever have the same offset.
	 *
	 * <p>As of 1.4.1, offsets for fields are represented as long values,
	 * although the Sun JVM does not use the most significant 32 bits.
	 * It is hard to imagine a JVM technology which needs more than
	 * a few bits to encode an offset within a non-array object,
	 * However, for consistency with other methods in this class,
	 * this method reports its result as a long value.
	 * @see #getInt(Object, long)
	 */
	default long objectFieldOffset(Field f) {
		return getSunUnsafe().objectFieldOffset(f);
	}

	/**
	 * Report the location of a given static field, in conjunction with {@link
	 * #staticFieldOffset}.
	 * <p>Fetch the base "Object", if any, with which static fields of the
	 * given class can be accessed via methods like {@link #getInt(Object,
	 * long)}.  This value may be null.  This value may refer to an object
	 * which is a "cookie", not guaranteed to be a real Object, and it should
	 * not be used in any way except as argument to the get and put routines in
	 * this class.
	 */
	default Object staticFieldBase(Field f) {
		return getSunUnsafe().staticFieldBase(f);
	}

	/**
	 * Detect if the given class may need to be initialized. This is often
	 * needed in conjunction with obtaining the static field base of a
	 * class.
	 * @return false only if a call to {@code ensureClassInitialized} would have no effect
	 */
	default boolean shouldBeInitialized(Class<?> c) {
		return getSunUnsafe().shouldBeInitialized(c);
	}

	/**
	 * Ensure the given class has been initialized. This is often
	 * needed in conjunction with obtaining the static field base of a
	 * class.
	 */
	default void ensureClassInitialized(Class<?> c) {
		getSunUnsafe().ensureClassInitialized(c);
	}

	/**
	 * Report the offset of the first element in the storage allocation of a
	 * given array class.  If {@link #arrayIndexScale} returns a non-zero value
	 * for the same class, you may use that scale factor, together with this
	 * base offset, to form new offsets to access elements of arrays of the
	 * given class.
	 *
	 * @see #getInt(Object, long)
	 * @see #putInt(Object, long, int)
	 */
	default int arrayBaseOffset(Class<?> arrayClass) {
		return getSunUnsafe().arrayBaseOffset(arrayClass);
	}

	/** The value of {@code arrayBaseOffset(boolean[].class)} */
	public static final int ARRAY_BOOLEAN_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(boolean[].class);

	/** The value of {@code arrayBaseOffset(byte[].class)} */
	public static final int ARRAY_BYTE_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(byte[].class);

	/** The value of {@code arrayBaseOffset(short[].class)} */
	public static final int ARRAY_SHORT_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(short[].class);

	/** The value of {@code arrayBaseOffset(char[].class)} */
	public static final int ARRAY_CHAR_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(char[].class);

	/** The value of {@code arrayBaseOffset(int[].class)} */
	public static final int ARRAY_INT_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(int[].class);

	/** The value of {@code arrayBaseOffset(long[].class)} */
	public static final int ARRAY_LONG_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(long[].class);

	/** The value of {@code arrayBaseOffset(float[].class)} */
	public static final int ARRAY_FLOAT_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(float[].class);

	/** The value of {@code arrayBaseOffset(double[].class)} */
	public static final int ARRAY_DOUBLE_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(double[].class);

	/** The value of {@code arrayBaseOffset(Object[].class)} */
	public static final int ARRAY_OBJECT_BASE_OFFSET
		= getSunUnsafe().arrayBaseOffset(Object[].class);

	/**
	 * Report the scale factor for addressing elements in the storage
	 * allocation of a given array class.  However, arrays of "narrow" types
	 * will generally not work properly with accessors like {@link
	 * #getByte(Object, int)}, so the scale factor for such classes is reported
	 * as zero.
	 *
	 * @see #arrayBaseOffset
	 * @see #getInt(Object, long)
	 * @see #putInt(Object, long, int)
	 */
	default int arrayIndexScale(Class<?> arrayClass) {
		return getSunUnsafe().arrayIndexScale(arrayClass);
	}

	/** The value of {@code arrayIndexScale(boolean[].class)} */
	public static final int ARRAY_BOOLEAN_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(boolean[].class);

	/** The value of {@code arrayIndexScale(byte[].class)} */
	public static final int ARRAY_BYTE_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(byte[].class);

	/** The value of {@code arrayIndexScale(short[].class)} */
	public static final int ARRAY_SHORT_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(short[].class);

	/** The value of {@code arrayIndexScale(char[].class)} */
	public static final int ARRAY_CHAR_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(char[].class);

	/** The value of {@code arrayIndexScale(int[].class)} */
	public static final int ARRAY_INT_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(int[].class);

	/** The value of {@code arrayIndexScale(long[].class)} */
	public static final int ARRAY_LONG_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(long[].class);

	/** The value of {@code arrayIndexScale(float[].class)} */
	public static final int ARRAY_FLOAT_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(float[].class);

	/** The value of {@code arrayIndexScale(double[].class)} */
	public static final int ARRAY_DOUBLE_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(double[].class);

	/** The value of {@code arrayIndexScale(Object[].class)} */
	public static final int ARRAY_OBJECT_INDEX_SCALE
		= getSunUnsafe().arrayIndexScale(Object[].class);

	/**
	 * Report the size in bytes of a native pointer, as stored via {@link
	 * #putAddress}.  This value will be either 4 or 8.  Note that the sizes of
	 * other primitive types (as stored in native memory blocks) is determined
	 * fully by their information content.
	 */
	default int addressSize() {
		return getSunUnsafe().addressSize();
	}

	/** The value of {@code addressSize()} */
	public static final int ADDRESS_SIZE = getSunUnsafe().addressSize();

	/**
	 * Report the size in bytes of a native memory page (whatever that is).
	 * This value will always be a power of two.
	 */
	default int pageSize() {
		return getSunUnsafe().pageSize();
	}


	/// random trusted operations from JNIEnv:

	/**
	 * Tell the VM to define a class, without security checks.  By default, the
	 * class loader and protection domain come from the caller's class.
	 */
	default Class<?> defineClass(String name, byte[] b, int off, int len,
					   ClassLoader loader,
					   ProtectionDomain protectionDomain) {
		return getSunUnsafe().defineClass(name, b, off, len, loader, protectionDomain);
	}

	/**
	 * Define a class but do not make it known to the class loader or system dictionary.
	 * <p>
	 * For each CP entry, the corresponding CP patch must either be null or have
	 * the a format that matches its tag:
	 * <ul>
	 * <li>Integer, Long, Float, Double: the corresponding wrapper object type from java.lang
	 * <li>Utf8: a string (must have suitable syntax if used as signature or name)
	 * <li>Class: any java.lang.Class object
	 * <li>String: any object (not just a java.lang.String)
	 * <li>InterfaceMethodRef: (NYI) a method handle to invoke on that call site's arguments
	 * </ul>
	 * @params hostClass context for linkage, access control, protection domain, and class loader
	 * @params data      bytes of a class file
	 * @params cpPatches where non-null entries exist, they replace corresponding CP entries in data
	 */
	default Class<?> defineAnonymousClass(Class<?> hostClass, byte[] data, Object[] cpPatches) {
		return getSunUnsafe().defineAnonymousClass(hostClass, data, cpPatches);
	}


	/** Allocate an instance but do not run any constructor.
	 Initializes the class if it has not yet been. */
	default Object allocateInstance(Class<?> cls)
		throws InstantiationException {
		return getSunUnsafe().allocateInstance(cls);
	}

	/** Lock the object.  It must get unlocked via {@link #monitorExit}. */
	@Deprecated
	default void monitorEnter(Object o) {
		getSunUnsafe().monitorEnter(o);
	}

	/**
	 * Unlock the object.  It must have been locked via {@link
	 * #monitorEnter}.
	 */
	@Deprecated
	default void monitorExit(Object o) {
		getSunUnsafe().monitorExit(o);
	}

	/**
	 * Tries to lock the object.  Returns true or false to indicate
	 * whether the lock succeeded.  If it did, the object must be
	 * unlocked via {@link #monitorExit}.
	 */
	@Deprecated
	default boolean tryMonitorEnter(Object o) {
		return getSunUnsafe().tryMonitorEnter(o);
	}

	/** Throw the exception without telling the verifier. */
	default void throwException(Throwable ee) {
		getSunUnsafe().throwException(ee);
	}


	/**
	 * Atomically update Java variable to <tt>x</tt> if it is currently
	 * holding <tt>expected</tt>.
	 * @return <tt>true</tt> if successful
	 */
	default boolean compareAndSwapObject(Object o, long offset,
							 Object expected,
							 Object x) {
		return getSunUnsafe().compareAndSwapObject(o, offset, expected, x);
	}

	/**
	 * Atomically update Java variable to <tt>x</tt> if it is currently
	 * holding <tt>expected</tt>.
	 * @return <tt>true</tt> if successful
	 */
	default boolean compareAndSwapInt(Object o, long offset,
						      int expected,
						      int x) {
		return getSunUnsafe().compareAndSwapInt(o, offset, expected, x);
	}

	/**
	 * Atomically update Java variable to <tt>x</tt> if it is currently
	 * holding <tt>expected</tt>.
	 * @return <tt>true</tt> if successful
	 */
	default boolean compareAndSwapLong(Object o, long offset,
						       long expected,
						       long x) {
		return getSunUnsafe().compareAndSwapLong(o, offset, expected, x);
	}

	/**
	 * Fetches a reference value from a given Java variable, with volatile
	 * load semantics. Otherwise identical to {@link #getObject(Object, long)}
	 */
	default Object getObjectVolatile(Object o, long offset) {
		return getSunUnsafe().getObjectVolatile(o, offset);
	}

	/**
	 * Stores a reference value into a given Java variable, with
	 * volatile store semantics. Otherwise identical to {@link #putObject(Object, long, Object)}
	 */
	default void    putObjectVolatile(Object o, long offset, Object x) {
		getSunUnsafe().putObjectVolatile(o, offset, x);
	}

	/** Volatile version of {@link #getInt(Object, long)}  */
	default int     getIntVolatile(Object o, long offset) {
		return getSunUnsafe().getIntVolatile(o, offset);
	}

	/** Volatile version of {@link #putInt(Object, long, int)}  */
	default void    putIntVolatile(Object o, long offset, int x) {
		getSunUnsafe().putIntVolatile(o, offset, x);
	}

	/** Volatile version of {@link #getBoolean(Object, long)}  */
	default boolean getBooleanVolatile(Object o, long offset) {
		return getSunUnsafe().getBooleanVolatile(o,offset);
	}

	/** Volatile version of {@link #putBoolean(Object, long, boolean)}  */
	default void    putBooleanVolatile(Object o, long offset, boolean x) {
		getSunUnsafe().putBooleanVolatile(o, offset, x);
	}

	/** Volatile version of {@link #getByte(Object, long)}  */
	default byte    getByteVolatile(Object o, long offset) {
		return getSunUnsafe().getByteVolatile(o, offset);
	}

	/** Volatile version of {@link #putByte(Object, long, byte)}  */
	default void    putByteVolatile(Object o, long offset, byte x) {
		getSunUnsafe().putByteVolatile(o, offset, x);
	}

	/** Volatile version of {@link #getShort(Object, long)}  */
	default short   getShortVolatile(Object o, long offset) {
		return getSunUnsafe().getShortVolatile(o, offset);
	}

	/** Volatile version of {@link #putShort(Object, long, short)}  */
	default void    putShortVolatile(Object o, long offset, short x) {
		getSunUnsafe().putShortVolatile(o, offset, x);
	}

	/** Volatile version of {@link #getChar(Object, long)}  */
	default char    getCharVolatile(Object o, long offset) {
		return getSunUnsafe().getCharVolatile(o, offset);
	}

	/** Volatile version of {@link #putChar(Object, long, char)}  */
	default void    putCharVolatile(Object o, long offset, char x) {
		getSunUnsafe().putCharVolatile(o, offset, x);
	}

	/** Volatile version of {@link #getLong(Object, long)}  */
	default long    getLongVolatile(Object o, long offset) {
		return getSunUnsafe().getLongVolatile(o, offset);
	}

	/** Volatile version of {@link #putLong(Object, long, long)}  */
	default void    putLongVolatile(Object o, long offset, long x) {
		getSunUnsafe().putLongVolatile(o, offset, x);
	}

	/** Volatile version of {@link #getFloat(Object, long)}  */
	default float   getFloatVolatile(Object o, long offset) {
		return getSunUnsafe().getFloatVolatile(o, offset);
	}

	/** Volatile version of {@link #putFloat(Object, long, float)}  */
	default void    putFloatVolatile(Object o, long offset, float x) {
		getSunUnsafe().putFloatVolatile(o, offset, x);
	}

	/** Volatile version of {@link #getDouble(Object, long)}  */
	default double  getDoubleVolatile(Object o, long offset) {
		return getSunUnsafe().getDoubleVolatile(o, offset);
	}

	/** Volatile version of {@link #putDouble(Object, long, double)}  */
	default void    putDoubleVolatile(Object o, long offset, double x) {
		getSunUnsafe().putDoubleVolatile(o, offset, x);
	}

	/**
	 * Version of {@link #putObjectVolatile(Object, long, Object)}
	 * that does not guarantee immediate visibility of the store to
	 * other threads. This method is generally only useful if the
	 * underlying field is a Java volatile (or if an array cell, one
	 * that is otherwise only accessed using volatile accesses).
	 */
	default void    putOrderedObject(Object o, long offset, Object x) {
		getSunUnsafe().putOrderedObject(o, offset, x);
	}

	/** Ordered/Lazy version of {@link #putIntVolatile(Object, long, int)}  */
	default void    putOrderedInt(Object o, long offset, int x) {
		getSunUnsafe().putOrderedInt(o, offset, x);
	}

	/** Ordered/Lazy version of {@link #putLongVolatile(Object, long, long)} */
	default void    putOrderedLong(Object o, long offset, long x) {
		getSunUnsafe().putOrderedLong(o, offset, x);
	}

	/**
	 * Unblock the given thread blocked on <tt>park</tt>, or, if it is
	 * not blocked, cause the subsequent call to <tt>park</tt> not to
	 * block.  Note: this operation is "unsafe" solely because the
	 * caller must somehow ensure that the thread has not been
	 * destroyed. Nothing special is usually required to ensure this
	 * when called from Java (in which there will ordinarily be a live
	 * reference to the thread) but this is not nearly-automatically
	 * so when calling from native code.
	 * @param thread the thread to unpark.
	 *
	 */
	default void unpark(Object thread) {
		getSunUnsafe().unpark(thread);
	}

	/**
	 * Block current thread, returning when a balancing
	 * <tt>unpark</tt> occurs, or a balancing <tt>unpark</tt> has
	 * already occurred, or the thread is interrupted, or, if not
	 * absolute and time is not zero, the given time nanoseconds have
	 * elapsed, or if absolute, the given deadline in milliseconds
	 * since Epoch has passed, or spuriously (i.e., returning for no
	 * "reason"). Note: This operation is in the Unsafe class only
	 * because <tt>unpark</tt> is, so it would be strange to place it
	 * elsewhere.
	 */
	default void park(boolean isAbsolute, long time) {
		getSunUnsafe().park(isAbsolute,time);
	}

	/**
	 * Gets the load average in the system run queue assigned
	 * to the available processors averaged over various periods of time.
	 * This method retrieves the given <tt>nelem</tt> samples and
	 * assigns to the elements of the given <tt>loadavg</tt> array.
	 * The system imposes a maximum of 3 samples, representing
	 * averages over the last 1,  5,  and  15 minutes, respectively.
	 *
	 * @params loadavg an array of double of size nelems
	 * @params nelems the number of samples to be retrieved and
	 *         must be 1 to 3.
	 *
	 * @return the number of samples actually retrieved; or -1
	 *         if the load average is unobtainable.
	 */
	default int getLoadAverage(double[] loadavg, int nelems) {
		return getSunUnsafe().getLoadAverage(loadavg,nelems);
	}

	// The following contain CAS-based Java implementations used on
	// platforms not supporting native instructions

	/**
	 * Atomically adds the given value to the current value of a field
	 * or array element within the given object <code>o</code>
	 * at the given <code>offset</code>.
	 *
	 * @param o object/array to update the field/element in
	 * @param offset field/element offset
	 * @param delta the value to add
	 * @return the previous value
	 * @since 1.8
	 */
	default int getAndAddInt(Object o, long offset, int delta) {
		int v;
		do {
			v = getIntVolatile(o, offset);
		} while (!compareAndSwapInt(o, offset, v, v + delta));
		return v;
	}

	/**
	 * Atomically adds the given value to the current value of a field
	 * or array element within the given object <code>o</code>
	 * at the given <code>offset</code>.
	 *
	 * @param o object/array to update the field/element in
	 * @param offset field/element offset
	 * @param delta the value to add
	 * @return the previous value
	 * @since 1.8
	 */
	default long getAndAddLong(Object o, long offset, long delta) {
		long v;
		do {
			v = getLongVolatile(o, offset);
		} while (!compareAndSwapLong(o, offset, v, v + delta));
		return v;
	}

	/**
	 * Atomically exchanges the given value with the current value of
	 * a field or array element within the given object <code>o</code>
	 * at the given <code>offset</code>.
	 *
	 * @param o object/array to update the field/element in
	 * @param offset field/element offset
	 * @param newValue new value
	 * @return the previous value
	 * @since 1.8
	 */
	default int getAndSetInt(Object o, long offset, int newValue) {
		int v;
		do {
			v = getIntVolatile(o, offset);
		} while (!compareAndSwapInt(o, offset, v, newValue));
		return v;
	}

	/**
	 * Atomically exchanges the given value with the current value of
	 * a field or array element within the given object <code>o</code>
	 * at the given <code>offset</code>.
	 *
	 * @param o object/array to update the field/element in
	 * @param offset field/element offset
	 * @param newValue new value
	 * @return the previous value
	 * @since 1.8
	 */
	default long getAndSetLong(Object o, long offset, long newValue) {
		long v;
		do {
			v = getLongVolatile(o, offset);
		} while (!compareAndSwapLong(o, offset, v, newValue));
		return v;
	}

	/**
	 * Atomically exchanges the given reference value with the current
	 * reference value of a field or array element within the given
	 * object <code>o</code> at the given <code>offset</code>.
	 *
	 * @param o object/array to update the field/element in
	 * @param offset field/element offset
	 * @param newValue new value
	 * @return the previous value
	 * @since 1.8
	 */
	default Object getAndSetObject(Object o, long offset, Object newValue) {
		Object v;
		do {
			v = getObjectVolatile(o, offset);
		} while (!compareAndSwapObject(o, offset, v, newValue));
		return v;
	}


	/**
	 * Ensures lack of reordering of loads before the fence
	 * with loads or stores after the fence.
	 * @since 1.8
	 */
	default void loadFence() {
		getSunUnsafe().loadFence();
	}

	/**
	 * Ensures lack of reordering of stores before the fence
	 * with loads or stores after the fence.
	 * @since 1.8
	 */
	default void storeFence() {
		getSunUnsafe().storeFence();
	}

	/**
	 * Ensures lack of reordering of loads or stores before the fence
	 * with loads or stores after the fence.
	 * @since 1.8
	 */
	default void fullFence() {
		getSunUnsafe().fullFence();
	}

}
