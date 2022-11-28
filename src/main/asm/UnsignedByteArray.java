package one.basic;


public final class UnsignedByteArray implements DataTypeArray<UnsignedByte>{
	//данные массива хранятся в обычных байтах, потому что да
	//(они весят меньше, ничё не знаю, мне не дали создать свой примитивный тип)
	private final byte[] data;

	/*
	ваще чё всё так скучно, надо комментировать код
	какого фига даже среда разработки лучше меня знает русский и пытается меня поправлять
	 */
	public static UnsignedByteArray of(UnsignedByte... unsignedBytes) {
		//преобразование кучи беззнаковых байтов в кучу знаковых

		byte[] bytes = new byte[unsignedBytes.length];

		for (int i = 0; i< bytes.length; i++) {
			bytes[i] = unsignedBytes[i].byteValue();
		}

		return new UnsignedByteArray(bytes);
	}
	public static UnsignedByteArray valueOfBytes(byte[] bytes) {
		return new UnsignedByteArray(bytes);
	}

	private UnsignedByteArray(byte[] bytes) {
		this.data = bytes;
	}

	@Override
	public byte[] getData() {
		return data;
	}

	@Override
	public UnsignedByteArray newByByteArray(byte[] bytes) {
		return new UnsignedByteArray(bytes);
	}

	@Override
	public UnsignedByteArray copy() {
		return new UnsignedByteArray(data);
	}

	@Override
	public int size() {
		return data.length;
	}

	@Override
	public UnsignedByte get(int index) {
		return UnsignedByte.valueOfByte(data[index]);
	}

	@Override
	public void set(int index, UnsignedByte x) {
		data[index] = x.byteValue();
	}
}
