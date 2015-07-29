//package com.learnopengls.view;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//import android.opengl.GLSurfaceView;
//import android.util.AttributeSet;
//import android.view.Surface;
//import android.view.SurfaceHolder;
//
//public class MyGLSurfaceview extends GLSurfaceView {
//
//	public MyGLSurfaceview(Context context) {
//		this(context, null);
//	}
//
//	public MyGLSurfaceview(Context context, AttributeSet attrs) {
//		this(context, attrs, 0);
//	}
//
//	public MyGLSurfaceview(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs);
//	}
//
//	public SurfaceHolder getHolder() {
//		return (SurfaceHolder) mSurfaceHolder;
//	}
//
//	private SurfaceHolder mSurfaceHolder = new SurfaceHolder() {
//
//		@Override
//		public boolean isCreating() {
//			return false;
//		}
//
//		@Override
//		public void addCallback(Callback callback) {
//		}
//
//		@Override
//		public void removeCallback(Callback callback) {
//		}
//
//		@Override
//		public void setFixedSize(int width, int height) {
//		}
//
//		@Override
//		public void setSizeFromLayout() {
//		}
//
//		@Override
//		public void setFormat(int format) {
//		}
//
//		@Override
//		public void setType(int type) {
//		}
//
//		@Override
//		public void setKeepScreenOn(boolean screenOn) {
//		}
//
//		@Override
//		public Canvas lockCanvas() {
//			return null;
//		}
//
//		@Override
//		public Canvas lockCanvas(Rect dirty) {
//			return null;
//		}
//
//		@Override
//		public void unlockCanvasAndPost(Canvas canvas) {
//		}
//
//		@Override
//		public Surface getSurface() {
//			return null;
//		}
//
//		@Override
//		public Rect getSurfaceFrame() {
//			return null;
//		}
//	};
//
// }
