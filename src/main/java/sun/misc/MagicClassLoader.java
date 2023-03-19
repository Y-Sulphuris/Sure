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
			getSystemClassLoader().printByteCode(NotObject.class, System.out);
			getSystemClassLoader().printByteCode(Object.class, System.out);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public synchronized byte[] getByteCode(String name) throws IOException, NoSuchFieldException, IllegalAccessException {
		//String path = name.replace('.', '/').concat(".class");
		String classFile = "/" + name.replace('.', '/') + ".class";
		try {
			URL url = MagicClassLoader.class.getResource(classFile);
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

	public byte[] getByteCode(Class<?> clazz) {
		try {
			return getByteCode(clazz.getName());
		} catch (IOException | IllegalAccessException | NoSuchFieldException e) {
			throw new SecurityException(e);
		}
	}
	public void printByteCode(Class<?> clazz, PrintStream out) {
		byte[] code = getByteCode(clazz);
		out.print(clazz.getSimpleName()+": ");
		out.print(code.length);
		printData(code, out);
	}
	public void printFileData(File classFile, PrintStream out) {
		try {
			FileInputStream is = new FileInputStream(classFile);
			byte[] code = IOUtils.readAllBytes(is);
			out.print(classFile.getName()+": ");
			out.print(code.length);
			printData(code, out);
			is.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printData(byte[] data, PrintStream out) {
		out.print('{');
		for (int i = 0; i < data.length; i++) {
			out.print(data[i] + (i != data.length-1?", ":""));
		}
		out.println("}");
	}

}