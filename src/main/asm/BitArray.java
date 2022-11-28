package one.basic;

public final class BitArray implements DataType{
	private final byte[] bytes;
	public int length() {
		return bytes.length*8;
	}
	public BitArray(int sizeInBytes) {
		bytes = new byte[sizeInBytes];
	}
	public BitArray(byte[] bytes) {
		this.bytes = bytes;
	}

	public boolean[] toBooleanArray() {
		boolean[] b = new boolean[bytes.length*8];
		for (int i = 0; i < b.length; i++) {
			b[i]=this.get(i);
		}
		return b;
	}
	public byte[] toByteArray() {
		return bytes;
	}
	public UnsignedByteArray toUByteArray() {
		return UnsignedByteArray.valueOfBytes(bytes);
	}


	public boolean get(long index) {
		return getAsNum(index)==1;
	}
	public int getAsNum(long index) {
		return getFlagAsNum(bytes,index);
	}

	public void set(long index, boolean bit) {
		setFlag(bytes,index,bit);
	}

	//устанавливает бит на 1, если аргумент равен 1, в ином случае на 0
	public void set(long index, int bit) {
		set(index,bit==1);
	}

	@Override
	public byte[] getData() {
		return bytes;
	}

	@Override
	public DataType newByByteArray(byte[] bytes) {
		return new BitArray(bytes);
	}

	/**
	 * @see BitArray#toBinaryString(byte...)
	 */
	@Override
	public String toString() {
		return toBinaryString(bytes);
	}

	@Override
	public DataType copy() {
		return newByByteArray(bytes);
	}

	private static void checkIndex(long index, int length) {
		if (index>=length)
			throw new ArrayIndexOutOfBoundsException(index + " >= " + length);
	}


	/**
	 * Getting the flag using direct bit order
	 * @param b the byte to get the flag from
	 * @param index a bit number from high
	 * @return true, if the flag is set
	 */
	public static boolean getFlag(byte b, int index) {
		return getFlag(new byte[]{b},index);
	}
	public static boolean getFlag(byte[] bytes, long index) {
		return getFlagAsNum(bytes,index)==1;
	}
	public static int getFlagAsNum(byte[] bytes, long index) {
		checkIndex(index, bytes.length*8);
		int posByte = Math.toIntExact(index / 8);
		long posBit = index%8;
		byte valByte = bytes[posByte];
		int valInt = valByte>>(8-(posBit+1)) & 0x0001;
		return (byte)valInt;
	}


	/**
	 * Setting a flag using direct bit order
	 * @param b original byte
	 * @param index a bit number from high
	 * @param flag new bit value
	 * @return resulting byte
	 */
	public static byte setFlag(byte b, long index, boolean flag) {
		return setFlag(new byte[]{b},index,flag)[0];
	}
	public static byte[] setFlag(byte[] bytes, long index, boolean flag) {
		checkIndex(index, bytes.length*8);
		if (flag) {
			bytes[Math.toIntExact(index / 8)] |= 1 << (7-index%8);
		} else {
			bytes[Math.toIntExact(index / 8)] &= ~(1 << (7-index%8));
		}
		return bytes;
	}

	/**
	 * Setting a flag using reverse bit order (counting from the end, that is, 0 is the least significant bit)
	 * @param b original byte
	 * @param index a bit number from low
	 * @param flag new bit value
	 * @return resulting byte
	 */
	public static byte setFlagR(byte b, int index, boolean flag) {
		return setFlagR(new byte[]{b},index,flag)[0];
	}
	//установка флага используя обратный порядок битов
	public static byte[] setFlagR(byte[] bytes, int index, boolean flag) {
		checkIndex(index, bytes.length*8);
		if (flag) {
			bytes[index/8] |= 1 << (index%8);
		} else {
			bytes[index/8] &= ~(1 << (index%8));
		}
		return bytes;
	}

	/**
	 * Convert byte array to binary string format
	 * @param bytes byte array to convert
	 * @see BitArray#toString()
	 */
	public static String toBinaryString(byte... bytes) {
		StringBuilder str1 = new StringBuilder();
		for (int index = 0; index < bytes.length; index++) {
			char[] chars1 = Integer.toBinaryString(bytes[index]).toCharArray();
			char[] chars2 = new char[8];
			for (int i = 1; i <= 8; i++) {
				try {
					chars2[8-i] = chars1[chars1.length-i];
				} catch (ArrayIndexOutOfBoundsException e) {
					chars2[8-i] = '0';
				}
			}
			str1.append(new String(chars2).intern());
			if (index!=bytes.length-1)str1.append("_");
		}
		return str1.toString();
	}
}
