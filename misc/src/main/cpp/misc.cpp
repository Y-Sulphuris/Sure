#include <jni.h>
#include <cstdio>
#include <iostream>
#include <cstring>
//#include <utilities/globalDefinitions.hpp>
//#include <memory/allocation.hpp>


static inline void throw_new(JNIEnv *pEnv, const char *ename);


static inline void throw_new(JNIEnv *env, const char *ename) {
	jclass cls = env->FindClass(ename);
	if (env->ExceptionCheck()) {

		env->ExceptionClear();

		char buf[100];
		strcpy(buf, "java/lang/");
		strcat(buf, ename);
		cls = env->FindClass(buf);
		if (env->ExceptionCheck()) {
			env->ExceptionClear();
			printf("Unsafe: cannot throw %s because FindClass has failed\n", ename);
			return;
		}
	}

	env->ThrowNew(cls, NULL);
}

extern "C"{






/*
 * Unsafe0
 * *
JNIEXPORT jobject JNICALL
Java_one_jnuit_misc_Unsafe0_allocateInstance0(JNIEnv *env, jobject obj,jclass cls) {
	return env->AllocObject(cls);
}
JNIEXPORT jlong JNICALL
Java_one_jnuit_misc_Unsafe0_allocateMemory0(JNIEnv *env, jobject obj, jlong size) {
	char* pointer = new char[size];
	return (jlong) pointer;
}
JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_freeMemory0(JNIEnv *env, jobject obj, jlong address) {
	char* pointer = (char*) address;
	delete[] pointer;
}
JNIEXPORT jlong JNICALL
Java_one_jnuit_misc_Unsafe0_getMemorySize(JNIEnv *env, jobject obj, jlong address) {
	char* pointer = (char*) address;
	return (_msize(pointer)/sizeof(*pointer));
	//delete[] pointer;
}

JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_throwException0(JNIEnv *env, jobject obj, jthrowable thr) {
	env->Throw(thr);
}


JNIEXPORT jbyte JNICALL
Java_one_jnuit_misc_Unsafe0_getByte0(JNIEnv *env, jobject obj, jlong address) {
	jbyte* pointer = (jbyte*) address;
	return *pointer;
}
JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_putByte0(JNIEnv *env, jobject obj, jlong address, jbyte x) {
	jbyte* pointer = (jbyte*) address;
	*pointer = x;
}
JNIEXPORT jshort JNICALL
Java_one_jnuit_misc_Unsafe0_getShort0(JNIEnv *env, jobject obj, jlong address) {
	jshort* pointer = (jshort*) address;
	return *pointer;
}
JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_putShort0(JNIEnv *env, jobject obj, jlong address, jshort x) {
	jshort* pointer = (jshort*) address;
	*pointer = x;
}
JNIEXPORT jint JNICALL
Java_one_jnuit_misc_Unsafe0_getInt0(JNIEnv *env, jobject obj, jlong address) {
	jint* pointer = (jint*) address;
	return *pointer;
}
JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_putInt0(JNIEnv *env, jobject obj, jlong address, jint x) {
	jint* pointer = (jint*) address;
	*pointer = x;
}
JNIEXPORT jlong JNICALL
Java_one_jnuit_misc_Unsafe0_getLong0(JNIEnv *env, jobject obj, jlong address) {
	jlong* pointer = (jlong*) address;
	return *pointer;
}
JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_putLong0(JNIEnv *env, jobject obj, jlong address, jlong x) {
	jlong* pointer = (jlong*) address;
	*pointer = x;
}

JNIEXPORT jchar JNICALL
Java_one_jnuit_misc_Unsafe0_getChar0(JNIEnv *env, jobject obj, jlong address) {
	jchar* pointer = (jchar*) address;
	return *pointer;
}
JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_putChar0(JNIEnv *env, jobject obj, jlong address, jchar x) {
	jchar* pointer = (jchar*) address;
	*pointer = x;
}

JNIEXPORT jfloat JNICALL
Java_one_jnuit_misc_Unsafe0_getFloat0(JNIEnv *env, jobject obj, jlong address) {
	jfloat* pointer = (jfloat*) address;
	return *pointer;
}
JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_putFloa0t(JNIEnv *env, jobject obj, jlong address, jfloat x) {
	jfloat* pointer = (jfloat*) address;
	*pointer = x;
}
JNIEXPORT jdouble JNICALL
Java_one_jnuit_misc_Unsafe0_getDouble0(JNIEnv *env, jobject obj, jlong address) {
	jdouble* pointer = (jdouble*) address;
	return *pointer;
}
JNIEXPORT void JNICALL
Java_one_jnuit_misc_Unsafe0_putDouble0(JNIEnv *env, jobject obj, jlong address, jdouble x) {
	jdouble* pointer = (jdouble*) address;
	*pointer = x;
}





/*
 * JNIEnvNative
 *
JNIEXPORT jlong JNICALL
Java_sun_misc_jni_JNIEnv_getJNIEnvAddress(JNIEnv *env, jobject obj) {
	return (jlong)env;
}
JNIEXPORT jlong JNICALL
Java_sun_misc_jni_JNIEnv_getObjectAddress(JNIEnv *env, jobject obj, jobject current) {
	return (jlong)obj;
}
JNIEXPORT jobject JNICALL
Java_sun_misc_jni_JNIEnv_objectByAddress(JNIEnv *env, jobject obj, jlong address) {
	return (jobject)address;
}
JNIEXPORT jboolean JNICALL
Java_sun_misc_jni_JNIEnv_exceptionCheck
(JNIEnv *env, jobject obj) {
	return env->ExceptionCheck();
}
JNIEXPORT jint JNICALL
Java_sun_misc_jni_JNIEnv_nThrow
(JNIEnv *env, jobject obj, jthrowable trw) {
	return env->Throw(trw);
}
JNIEXPORT jclass JNICALL
Java_sun_misc_jni_JNIEnv_defineClass
(JNIEnv *env, jobject obj, jstring name, jobject loader, jbyteArray data, jint length) {

	jbyte *body;
	const char *utfName = env->GetStringUTFChars(name, 0);

	//char buf[128];
	if (data == nullptr) {
		throw_new(env, "NullPointerException");
		return 0;
	}
	if (length < 0) {
		throw_new(env, "ArrayIndexOutOfBoundsException");
		return 0;
	}
	if (body == 0) {
		throw_new(env, "OutOfMemoryError");
		return 0;
	}

	env->GetByteArrayRegion(data, 0, length, body);

	jclass result = env->DefineClass(utfName,loader,body,length);


	//освобождение памяти
	env->ReleaseStringUTFChars(name, utfName);
	env->ReleaseByteArrayElements(data,body,0);


	return result;
}

JNIEXPORT void JNICALL
Java_sun_misc_jni_JNIEnv_fatalError(JNIEnv *env, jobject obj, jstring msg) {
	env->FatalError(env->GetStringUTFChars(msg, 0));
}
JNIEXPORT jobject JNICALL
Java_sun_misc_jni_JNIEnv_allocObject(JNIEnv *env, jobject obj, jclass clazz) {
	return env->AllocObject(clazz);
}
JNIEXPORT jint JNICALL
Java_sun_misc_jni_JNIEnv_unregisterNatives(JNIEnv *env, jobject obj, jclass clazz) {
	return env->UnregisterNatives(clazz);
}
JNIEXPORT jint JNICALL
Java_sun_misc_jni_JNIEnv_getVersion(JNIEnv *env, jobject obj) {
	return env->GetVersion();
}
*/


JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_getJNIEnvAddress(JNIEnv *env, jobject obj) {
	return (jlong)env;
}
}

int main() {
	return 0;
}
/*

static jclass Unsafe_DefineClass_impl(JNIEnv *env, jstring name, jbyteArray data, int offset, int length, jobject loader, jobject pd) {
	{
		// Code lifted from JDK 1.3 ClassLoader.c

		jbyte *body;
		char *utfName;
		jclass result = 0;
		char buf[128];


		if (data == NULL) {
			throw_new(env, "NullPointerException");
			return 0;
		}

		/* Work around 4153825. malloc crashes on Solaris when passed a
		 * negative size.
		 *
		if (length < 0) {
			throw_new(env, "ArrayIndexOutOfBoundsException");
			return 0;
		}


		if (body == 0) {
			throw_new(env, "OutOfMemoryError");
			return 0;
		}

		env->GetByteArrayRegion(data, offset, length, body);

		if (env->ExceptionOccurred())
			goto free_body;

		if (name != NULL) {
			uint len = env->GetStringUTFLength(name);
			int unicode_len = env->GetStringLength(name);
			if (len >= sizeof(buf)) {
				utfName = NEW_C_HEAP_ARRAY(char, len + 1, mtInternal);
				if (utfName == NULL) {
					throw_new(env, "OutOfMemoryError");
					goto free_body;
				}
			} else {
				utfName = buf;
			}
			env->GetStringUTFRegion(name, 0, unicode_len, utfName);
			//VerifyFixClassname(utfName);
			for (uint i = 0; i < len; i++) {
				if (utfName[i] == '.')   utfName[i] = '/';
			}
		} else {
			utfName = NULL;
		}

		result = JVM_DefineClass(env, utfName, loader, body, length, pd);

		if (utfName && utfName != buf)
			FREE_C_HEAP_ARRAY(char, utfName, mtInternal);

		free_body:
		FREE_C_HEAP_ARRAY(jbyte, body, mtInternal);
		return result;
	}
}



static jclass  Unsafe_DefineClass(JNIEnv *env, jobject unsafe, jstring name, jbyteArray data, int offset, int length, jobject loader, jobject pd){
	//ThreadToNativeFromVM ttnfv(thread);
	return Unsafe_DefineClass_impl(env, name, data, offset, length, loader, pd);
}

static jclass Unsafe_DefineClass0(JNIEnv *env, jobject unsafe, jstring name, jbyteArray data, int offset, int length)
{
	//ThreadToNativeFromVM ttnfv(thread);

	int depthFromDefineClass0 = 1;
	jclass  caller = JVM_GetCallerClass(env, depthFromDefineClass0);
	jobject loader = (caller == NULL) ? NULL : JVM_GetClassLoader(env, caller);
	jobject pd     = (caller == NULL) ? NULL : JVM_GetProtectionDomain(env, caller);

	return Unsafe_DefineClass_impl(env, name, data, offset, length, loader, pd);
}
*/