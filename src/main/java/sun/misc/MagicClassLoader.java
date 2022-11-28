package sun.misc;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

public final class MagicClassLoader extends ClassLoader{

	private static final MagicClassLoader systemLoader = new MagicClassLoader();
	public static MagicClassLoader getSystemClassLoader() { //Override
		return systemLoader;
	}
	@Deprecated
	@Override
	public Class<?> loadClass(String name, boolean resolute) {
		return loadClass(name);
	}
	@Override
	public Class<?> loadClass(String name) {
		try {
			byte[] bytecode = getByteCode(name);
			return loadClass(name,bytecode);
		} catch (Throwable e) {
			throw new SecurityException(e);
		}
	}
	private Class<?> loadClass(String name, byte[] bytecode) {
		return UnsafeImpl.ALLOCATED_UNSAFE.defineClass(name,bytecode,0,bytecode.length,null,null);
		//return JNIEnv.env.defineClass(name,null,bytecode, bytecode.length);
	}

	//
	//Это так не работает
	//
	//@Deprecated
	//public Class<?> putByteCode(Class<?> clazz, byte[] bytecode) {
	//	try {
	//		return loadClass(clazz.getName(),bytecode);
	//	} catch (Throwable e) {
	//		throw new SecurityException(e);
	//	}
	//}

	public static void main(String[] args) {
		try {
			//getSystemClassLoader().getByteCode("one.jnuit.misc.NotObject");
			getSystemClassLoader().printByteCode(Object.class, System.out);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public synchronized byte[] getByteCode(String name) throws IOException, NoSuchFieldException, IllegalAccessException {
		//String path = name.replace('.', '/').concat(".class");
		String classFile = "/" + name.replace('.', '/') + ".class";
		try {
			String classFile2 = "/" + MagicClassLoader.class.getName().replace('.', '/') + ".class";
			System.out.println(classFile2);

			System.out.println(Object.class.getName());
			System.out.println(name);
			//URL url = JNuit.class.getResource(classFile);
			//System.out.println(url);
			//return null;
			URL url = MagicClassLoader.class.getResource(classFile2);
			assert url != null;
			InputStream is = url.openStream();
			byte[] bytes = IOUtils.readAllBytes(is);
			is.close();
			return bytes;
		}catch (NullPointerException e) {
			System.out.println("?");
			Field f = URLClassLoader.class.getDeclaredField("ucp");
			f.setAccessible(true);
			URLClassPath ucp = (URLClassPath)f.get(ClassLoader.getSystemClassLoader());
			Resource res = ucp.getResource(classFile, false);
			return res.getBytes();
		}

	}

	public byte[] getClassByteCode(Class<?> clazz) {
		try {
			return getByteCode(clazz.getName());
		} catch (IOException | IllegalAccessException | NoSuchFieldException e) {
			throw new SecurityException(e);
		}
	}
	public synchronized void printByteCode(Class<?> clazz, PrintStream out) {
		byte[] code = getClassByteCode(clazz);
		out.print(code.length);
		out.print('{');
		int i = 1;
		for (byte b : code) {
			
			i++;
			out.print(b + i==code.length?',':"");
		}
		out.println("}");
	}

}