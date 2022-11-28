package start;

import one.misc.Unsafe0;

public class Tests3 {
	static {
		//File f = new File("misc/build/lib/main/debug");
		//JNuit.setNativeFolder(f);
	}

	//public static NativeMemory memory = JUMemoryUtils.allocateMemory(NativeMemory.MEGABYTE);

	public static void main(String... args) {

		long mem = Unsafe0.getUnsafe().allocateMemory(8);



		Unsafe0 unsafe0 = Unsafe0.getUnsafe();


		/**///////////////////////////**/
		/**/long start = System.nanoTime();/**/
		/**///////////////////////////**/
		{


			System.out.println(unsafe0.allocateInstance(Object.class));


		}
		///////////////////////////////////////////////**/
		/**/long finish = System.nanoTime();						/**/
		/**/long elapsed = finish - start;												/**/
		/**/System.out.println("Прошло времени, микросекунды: " + elapsed/1000f);/**/
		///////////////////////////////////////////////**/
		long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		System.out.println(String.format("%.2f",usedBytes / 1048576f)+" mb использовано");
	}
}
