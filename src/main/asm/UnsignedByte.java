package one.basic;

//а вот в котлине можно было бы это всё красивее сделать!!!
public final class UnsignedByte extends Number implements DataType, Comparable<Number>{
	public static UnsignedByte of(int value) {
		return valueOf(value);
	}
	public static UnsignedByte of(byte[] bytes) {
		if (bytes.length!=BYTES)
			throw new NumberFormatException();
		return valueOf(bytes[0]);
	}

	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 255;


	public static class UnsignedByteCache {
		private UnsignedByteCache(){}

		static final UnsignedByte[] cache = new UnsignedByte[255 + 1];

		static {
			for(int i = 0; i < cache.length; i++)
				cache[i] = new UnsignedByte(i);
		}
	}
	public static UnsignedByte valueOf(int value) {
		return UnsignedByteCache.cache[(value%256) & 255];
	}
	public static UnsignedByte valueOf(UnsignedByte ub) {
		return UnsignedByteCache.cache[ub.get()];
	}
	public static UnsignedByte valueOf(Number num) {
		if (num instanceof Byte) return valueOfByte(num.byteValue());
		if (num instanceof Short) return valueOf(num.shortValue());
		return valueOf(num.intValue());
	}
	public static UnsignedByte valueOfByte(byte value) {
		return UnsignedByteCache.cache[Byte.toUnsignedInt(value)];
	}
	public static UnsignedByte parseUnsignedByte(String s, int radix)
		throws NumberFormatException {
		int i = Integer.parseInt(s, radix);
		if (i < MIN_VALUE || i > MAX_VALUE)
			throw new NumberFormatException("Value out of range. Value:\"" + s + "\" Radix:" + radix);
		return valueOf(i);
	}
	public static UnsignedByte parseUnsignedByte(String s) throws NumberFormatException {
		return parseUnsignedByte(s, 10);
	}
	public static UnsignedByte valueOf(String s, int radix)
		throws NumberFormatException {
		return valueOf(parseUnsignedByte(s, radix));
	}
	public static UnsignedByte valueOf(String s) throws NumberFormatException {
		return valueOf(s, 10);
	}
	public static UnsignedByte decode(String nm) throws NumberFormatException {
		int i = Integer.decode(nm);
		if (i < MIN_VALUE || i > MAX_VALUE)
			throw new NumberFormatException(
				"Value " + i + " out of range from input " + nm);
		return valueOf(i);
	}
	private final byte value;
	public int get() {
		return intValue();
	}
	private UnsignedByte(int value) {
		/*if (value > MAX_VALUE || value < MIN_VALUE)
			throw new NumberFormatException("Value must be in the range 0-255");*/
		this.value = (byte)value;
	}
	public UnsignedByte() {
		this.value = 0;
	}
	@Override
	public byte byteValue() {
		return value;
	}
	@Override
	public short shortValue() {
		return (short) intValue();
	}
	@Override
	public int intValue() {
		return Byte.toUnsignedInt(value);
	}
	@Override
	public long longValue() {
		return Byte.toUnsignedLong(value);
	}
	@Override
	public float floatValue() {
		return intValue();
	}
	@Override
	public double doubleValue() {
		return longValue();
	}
	@Override
	public String toString() {
		return String.valueOf(this.get());
	}

	@Override
	public DataType copy() {
		return valueOfByte(value);
	}


	@Override
	public UnsignedByte newByByteArray(byte[] bytes) {
		return of(bytes);
	}


	@Override
	public int hashCode() {
		return intValue();
	}

	@Override
	public byte[] getData() {
		return new byte[]{value};
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnsignedByte) {
			return value == ((UnsignedByte)obj).byteValue();
		}
		return false;
	}
	@Override
	public int compareTo(Number anotherUnsignedByte) {
		return compare(this, valueOf(anotherUnsignedByte));
	}
	public static int compare(UnsignedByte x, UnsignedByte y) {
		return x.minus(y).intValue();
	}

	public static final int SIZE = 8;

	public static final int BYTES = SIZE / UnsignedByte.SIZE;

	private static final long serialVersionUID = -7183698231559129828L;

	public static String toBinaryString(UnsignedByte i) {
		return Integer.toBinaryString(i.get());
	}
	public static UnsignedByte divide(UnsignedByte dividend, UnsignedByte divisor) {
		return dividend.divide(divisor);
	}
	public static UnsignedByte remainder(UnsignedByte dividend, UnsignedByte divisor) {
		return valueOf(Byte.toUnsignedInt(dividend.byteValue()) % Byte.toUnsignedInt(divisor.byteValue()));
	}

	public static UnsignedByte sum(UnsignedByte a, UnsignedByte b) {
		return a.plus(b);
	}
	public static UnsignedByte max(UnsignedByte a, UnsignedByte b) {
		return UnsignedByte.valueOf(Math.max(a.get(), b.get()));
	}
	public static UnsignedByte min(UnsignedByte a, UnsignedByte b) {
		return UnsignedByte.valueOf(Math.min(a.get(), b.get()));
	}

	//Basic math operations

	public UnsignedByte plus(UnsignedByte another) {
		return UnsignedByte.valueOf(this.get()+another.get());
	}
	public UnsignedByte minus(UnsignedByte another) {
		return UnsignedByte.valueOf(this.get()-another.get());
	}
	public UnsignedByte divide(UnsignedByte divisor) {
		return valueOf((int)(Integer.toUnsignedLong(this.get()) / Integer.toUnsignedLong(divisor.get())));
	}
	public UnsignedByte multiply(UnsignedByte multiplier) {
		return valueOf((int)(Integer.toUnsignedLong(this.get()) * Integer.toUnsignedLong(multiplier.get())));
	}
	public UnsignedByte and(UnsignedByte another) {
		return valueOf(this.get() & another.get());
	}
	public UnsignedByte or(UnsignedByte another) {
		return valueOf(this.get() | another.get());
	}
	public UnsignedByte xor(UnsignedByte another) {
		return valueOf(this.get() ^ another.get());
	}
	public UnsignedByte shl(UnsignedByte another) {
		return valueOf(this.get() << another.get());
	}
	public UnsignedByte shr(UnsignedByte another) {
		return valueOf(this.get() >>> another.get());
	}
}