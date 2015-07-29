#ifndef INTERFACE_H
#define INTERFACE_H

#include <jni.h>
#include "opengl_es.h"

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_learnopengels_viewutils_GameLibJNIWrapper_on_1surface_1created(
		JNIEnv * env, jclass cls) {
	gles_init();
}

JNIEXPORT void JNICALL Java_com_learnopengels_viewutils_GameLibJNIWrapper_on_1surface_1changed(
		JNIEnv * env, jclass cls, jint width, jint height) {
	gles_change(width, height);
}

JNIEXPORT void JNICALL Java_com_learnopengels_viewutils_GameLibJNIWrapper_on_1draw_1frame(
		JNIEnv * env, jclass cls) {
	gles_draw();
}
JNIEXPORT void JNICALL Java_com_learnopengels_viewutils_GameLibJNIWrapper_on_1draw_1frame2(
		JNIEnv * env, jclass cls) {
	gles_draw2();
}
#ifdef __cplusplus
}
#endif

#endif
