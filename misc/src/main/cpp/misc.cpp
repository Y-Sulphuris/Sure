#include <jni.h>
#include <cstdio>
#include <iostream>
#include <cstring>
//#include <utilities/globalDefinitions.hpp>
//#include <memory/allocation.hpp>


//static inline void throw_new(JNIEnv *pEnv, const char *ename);


#define unsure_method(type, methodName) JNIEXPORT type JNICALL Java_sun_misc_Unsure_##methodName


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
			printf("Unsure: cannot throw %s because FindClass has failed\n", ename);
			return;
		}
	}

	env->ThrowNew(cls, nullptr);
}

/*
class {
public:
	double cycl(double d) {
		long long l = *(long long*)&d;
		std::cout << l << std::endl;
		l += 100;
		std::cout << l << std::endl;
		
		return *((double*) &l);
	}
} cycler;
*/

extern "C"{


JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_getJNIEnvAddress(JNIEnv *env, jobject obj) {
	return (jlong)env;
}





JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newByteArray(JNIEnv *env, jobject obj, jlong size) {
	jbyte* array = new jbyte[size];
	return (jlong)array;
}
JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newByte(JNIEnv *env, jobject obj, jbyte value) {
	jbyte* byte = new jbyte(value);
	return (jlong)byte;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_setByte(JNIEnv *env, jobject obj, jlong array, jlong index, jbyte x) {
	((jbyte*)array)[index] = x;
}
JNIEXPORT jbyte JNICALL
Java_sun_misc_Unsure_getByte(JNIEnv *env, jobject obj, jlong array, jlong index) {
	return ((jbyte*)array)[index];
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteByteArray(JNIEnv *env, jobject obj, jlong array) {
	delete[] (jbyte*)array;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteByte(JNIEnv *env, jobject obj, jlong pointer) {
    delete (jbyte*)pointer;
}


JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newShortArray(JNIEnv *env, jobject obj, jlong size) {
	jshort* array = new jshort[size];
	return (jlong)array;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_setShort(JNIEnv *env, jobject obj, jlong array, jlong index, jshort x) {
	((jshort*)array)[index] = x;
}
JNIEXPORT jshort JNICALL
Java_sun_misc_Unsure_getShort(JNIEnv *env, jobject obj, jlong array, jlong index) {
	return ((jshort*)array)[index];
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteShortArray(JNIEnv *env, jobject obj, jlong array) {
	delete[] (jshort*)array;
}



JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newIntArray(JNIEnv *env, jobject obj, jlong size) {
	jint* array = new jint[size];
	return (jlong)array;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_setInt(JNIEnv *env, jobject obj, jlong array, jlong index, jint x) {
	((jint*)array)[index] = x;
}
JNIEXPORT jint JNICALL
Java_sun_misc_Unsure_getInt(JNIEnv *env, jobject obj, jlong array, jlong index) {
	return ((jint*)array)[index];
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteIntArray(JNIEnv *env, jobject obj, jlong array) {
	delete[] (jint*)array;
}




JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newLongArray(JNIEnv *env, jobject obj, jlong size) {
	jlong* array = new jlong[size];
	return (jlong)array;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_setLong(JNIEnv *env, jobject obj, jlong array, jlong index, jlong x) {
	((jlong*)array)[index] = x;
}
JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_getLong(JNIEnv *env, jobject obj, jlong array, jlong index) {
	return ((jlong*)array)[index];
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteLongArray(JNIEnv *env, jobject obj, jlong array) {
	delete[] (jlong*)array;
}



JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newFloatArray(JNIEnv *env, jobject obj, jlong size) {
	jfloat* array = new jfloat[size];
	return (jlong)array;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_setFloat(JNIEnv *env, jobject obj, jlong array, jlong index, jfloat x) {
	((jfloat*)array)[index] = x;
}
JNIEXPORT jfloat JNICALL
Java_sun_misc_Unsure_getFloat(JNIEnv *env, jobject obj, jlong array, jlong index) {
	return ((jfloat*)array)[index];
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteFloatArray(JNIEnv *env, jobject obj, jlong array) {
	delete[] (jfloat*)array;
}



JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newDoubleArray(JNIEnv *env, jobject obj, jlong size) {
	jdouble* array = new jdouble[size];
	return (jlong)array;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_setDouble(JNIEnv *env, jobject obj, jlong array, jlong index, jdouble x) {
	((jdouble*)array)[index] = x;
}
JNIEXPORT jdouble JNICALL
Java_sun_misc_Unsure_getDouble(JNIEnv *env, jobject obj, jlong array, jlong index) {
	return ((jdouble*)array)[index];
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteDoubleArray(JNIEnv *env, jobject obj, jlong array) {
	delete[] (jdouble*)array;
}



JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newBooleanArray(JNIEnv *env, jobject obj, jlong size) {
	jboolean* array = new jboolean[size];
	return (jlong)array;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_setBoolean(JNIEnv *env, jobject obj, jlong array, jlong index, jboolean x) {
	((jboolean*)array)[index] = x;
}
JNIEXPORT jboolean JNICALL
Java_sun_misc_Unsure_getBoolean(JNIEnv *env, jobject obj, jlong array, jlong index) {
	return ((jboolean*)array)[index];
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteBooleanArray(JNIEnv *env, jobject obj, jlong array) {
	delete[] (jboolean*)array;
}



JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newCharArray(JNIEnv *env, jobject obj, jlong size) {
	jchar* array = new jchar[size];
	return (jlong)array;
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_setChar(JNIEnv *env, jobject obj, jlong array, jlong index, jchar x) {
	((jchar*)array)[index] = x;
}
JNIEXPORT jchar JNICALL
Java_sun_misc_Unsure_getChar(JNIEnv *env, jobject obj, jlong array, jlong index) {
	return ((jchar*)array)[index];
}
JNIEXPORT void JNICALL
Java_sun_misc_Unsure_deleteCharArray(JNIEnv *env, jobject obj, jlong array) {
	delete[] (jchar*)array;
}





JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_malloc(JNIEnv *env, jobject obj, jlong size) {
	void* p = malloc(size);
	if (p == nullptr) {
		throw_new(env, "OutOfMemoryError");
		return 0;
	}
	return (jlong)p;
}

JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_calloc(JNIEnv *env, jobject obj, jlong num, jlong size) {
	void* p = calloc(num, size);
	if (p == nullptr) {
		throw_new(env, "OutOfMemoryError");
		return 0;
	}
	return (jlong)p;
}

JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_realloc(JNIEnv *env, jobject obj, jlong pointer, jlong size) {
	void* p = realloc((void*)pointer, size);
	if (p == nullptr) {
		throw_new(env, "OutOfMemoryError");
		return 0;
	}
	return (jlong)p;
}

JNIEXPORT void JNICALL
Java_sun_misc_Unsure_free(JNIEnv *env, jobject obj, jlong pointer) {
	free((void*)pointer);
}

JNIEXPORT void JNICALL
Java_sun_misc_Unsure_segmentation_1fault(JNIEnv *env, jobject obj) {
	char* p = nullptr;
	*p = 1;
}
JNIEXPORT jint JNICALL
Java_sun_misc_Unsure_headerSize(JNIEnv *env, jobject obj) {
    env.
	return 12;//todo
}



void* p32 = malloc(4);
void* p64 = malloc(8);


unsure_method(jlong,castToPointer)(JNIEnv* env, jobject ownerClass, jobject object, jbyte addressSize) {
	jlong address = NULL;
	memcpy(&address, object, addressSize);
	return address;
}


unsure_method(jobject,castToObject)(JNIEnv *env, jobject ownerClass, jlong address, jbyte addressSize) {
	void *p = NULL;
	if (addressSize == 4) {
		memcpy(p32, &address, 4);
		p = p32;
	}
	else if (addressSize == 8) {
		memcpy(p64, &address, 8);
		p = p64;
	}
	return (jobject)p;
}
/*
struct twoInts {
	jint v1, v2;
	twoInts(jint i1, jint i2) {
		v1 = i1;
		v2 = i2;
	}
	jlong toLong() {
		return *((jlong*)this);
	}
};
struct twoShorts {
	jshort v1, v2;
	twoShorts(jshort s1, jshort s2) {
		v1 = s1;
		v2 = s2;
	}
	jint toInt() {
		return *((jint*)this);
	}
};
struct twoBytes {
	jbyte v1, v2;
	twoBytes(jbyte b1, jbyte b2) {
		v1 = b1;
		v2 = b2;
	}
	jshort toShort() {
		return *((jshort*)this);
	}
};

jint getInt0(jlong value) {
	jint* p = (jint*)&value;
	return *p;
}
jint getInt1(jlong value) {
	jint* p = (jint*)&value;
	return *(p+1);
}
jshort getShort0(jint value) {
	jshort* p = (jshort*)&value;
	return *p;
}
jshort getShort1(jint value) {
	jshort* p = (jshort*)&value;
	return *(p+1);
}
jbyte getByte0(jshort value) {
	jbyte* p = (jbyte*)&value;
	return *p;
}
jbyte getByte1(jshort value) {
	jbyte* p = (jbyte*)&value;
	return *(p+1);
}

JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newStruct2i(JNIEnv *env, jobject obj, jint v1, jint v2) {
	twoInts ints = {v1,v2};
	return *((jlong*)&ints);
}
JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newStruct2s1i(JNIEnv *env, jobject obj, jshort s1, jshort s2, jint i2) {
	twoInts ints = {twoShorts(s1,s2).toInt(),i2};
	return ints.toLong();
}
JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newStruct1i2s(JNIEnv *env, jobject obj, jint i1, jshort s3, jshort s4) {
	twoInts ints = {i1, twoShorts(s3, s4).toInt()};
	return ints.toLong();
}
JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newStruct4s(JNIEnv *env, jobject obj, jshort s1, jshort s2, jshort s3, jshort s4) {
	twoInts ints = {twoShorts(s1,s2).toInt(),twoShorts(s3,s4).toInt()};
	return ints.toLong();
}
JNIEXPORT jlong JNICALL
Java_sun_misc_Unsure_newStruct8b(JNIEnv *env, jobject obj, jbyte b1, jbyte b2, jbyte b3, jbyte b4, jbyte b5, jbyte b6, jbyte b7, jbyte b8) {
	twoInts ints = {
			twoShorts(twoBytes(b1,b2).toShort(),twoBytes(b3,b4).toShort()).toInt(),
			twoShorts(twoBytes(b5,b6).toShort(),twoBytes(b7,b8).toShort()).toInt()};
	return ints.toLong();
}


JNIEXPORT jint JNICALL
Java_sun_misc_Unsure_newStruct2s(JNIEnv *env, jobject obj, jshort v1, jshort v2) {
	return twoShorts(v1,v2).toInt();
}
JNIEXPORT jint JNICALL
Java_sun_misc_Unsure_newStruct2b1s(JNIEnv *env, jobject obj, jbyte b1, jbyte b2, jshort s2) {
	return twoShorts(twoBytes(b1,b2).toShort(),s2).toInt();
}
JNIEXPORT jint JNICALL
Java_sun_misc_Unsure_newStruct1s2b(JNIEnv *env, jobject obj, jshort s1, jbyte b3, jbyte b4) {
	return twoShorts(s1,twoBytes(b3,b4).toShort()).toInt();
}
JNIEXPORT jint JNICALL
Java_sun_misc_Unsure_newStruct4b(JNIEnv *env, jobject obj, jbyte b1, jbyte b2, jbyte b3, jbyte b4) {
	return twoShorts(twoBytes(b1,b2).toShort(),twoBytes(b3,b4).toShort()).toInt();
}

JNIEXPORT jshort JNICALL
Java_sun_misc_Unsure_newStruct2b(JNIEnv *env, jobject obj, jbyte v1, jbyte v2) {
	return twoBytes(v1,v2).toShort();
}
*/






/*JNIEXPORT jbyte JNICALL
Java_sun_misc_Unsure_booleanToByte(JNIEnv *env, jobject obj, jboolean x) {
	return *((jbyte*)&x);
}
JNIEXPORT jboolean JNICALL
Java_sun_misc_Unsure_byteToBoolean(JNIEnv *env, jobject obj, jbyte x) {
	return *((jboolean*)&x);
}*/



}


/*
int main() {

	//std::cout << cycler.cycl(100.0) << std::endl;


	return 0;
}*/

