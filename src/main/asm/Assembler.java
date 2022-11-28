package one.asm;

import one.jnuit.JUnsafe;
import one.jnuit.NativeMemory;

public abstract class Assembler {
	private final NativeMemory memory = JUnsafe.allocateMemory(memorySize());
	{
		memory.clean();
	}
	protected abstract void run();
	protected abstract long memorySize();
	@Override
	protected void finalize() throws Throwable {
		memory.free();
	}

	//Register classes
	private static class ByteRegister {
		private byte value = 0;
	}
	private static class WordRegister {
		private short value = 0;
	}
	private static class DWordRegister {
		private int value = 0;
	}

	//Registers
	protected static final ByteRegister
		al = new ByteRegister(),
		cl = new ByteRegister(),
		dl = new ByteRegister(),
		bl = new ByteRegister(),
		ah = new ByteRegister(),
		ch = new ByteRegister(),
		dh = new ByteRegister(),
		bh = new ByteRegister();
	protected static final WordRegister
		ax = new WordRegister(),
		cx = new WordRegister(),
		dx = new WordRegister(),
		bx = new WordRegister(),
		sp = new WordRegister(),
		bp = new WordRegister(),
		si = new WordRegister(),
		di = new WordRegister();
	protected static final DWordRegister
		eax = new DWordRegister(),
		ecx = new DWordRegister(),
		edx = new DWordRegister(),
		ebx = new DWordRegister(),
		asp = new DWordRegister(),
		ebp = new DWordRegister(),
		esi = new DWordRegister(),
		edi = new DWordRegister();


	//ASM commands

	//mov
	//to register
	protected synchronized static void mov(ByteRegister register, byte x) {
		Assembler.al.value=x;
	}
	protected synchronized static void mov(WordRegister register, short x) {
		register.value=x;
	}
	protected synchronized static void mov(DWordRegister register, int x) {
		register.value=x;
	}


}

class TestAsm extends Assembler {

	@Override
	protected void run() {
		mov(al,(byte) 0);
	}

	@Override
	protected long memorySize() {
		return NativeMemory.KILOBYTE*4;
	}

}