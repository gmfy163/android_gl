package com.learnopengels.viewutils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;

public class RendererWrapper2 implements Renderer {

	int j = 0;
	int i = 0;

	public RendererWrapper2(int i) {
		this.i = i;

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		GameLibJNIWrapper.on_surface_created();
		System.out.println("create+++++++++++++++++");
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		GameLibJNIWrapper.on_surface_changed(width, height);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// Log.d("time:",
		// new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS")
		// .format(new Date()) + "@@@" + j++);
		// if (i == 0) {
		GameLibJNIWrapper.on_draw_frame2();
		System.out.println("ondraw" + i + "i");
		// }
	}
}
