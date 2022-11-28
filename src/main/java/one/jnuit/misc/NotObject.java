package one.jnuit.misc;

/**
 * Class with no superclass.
 * <p>
 *         Does not have standard methods from {@link java.lang.Object}.
 * </p>
 * Use {@link  UnsafeClassLoader#loadClass(String)} to load this class before using it:
 * <blockquote><pre>
 * class MyClass {
 *   static {
 *           UnsafeClassLoader.getSystemClassLoader().loadClass("one.jmaster.misc.NotObject")
 *   }
 *   public static void main(String... args) {
 *           NotObject myNotObject = new NotObject();
 *   }
 * }
 * </pre></blockquote>
 */
public class NotObject {
	//No superclass in compiled code, do not edit this
}
