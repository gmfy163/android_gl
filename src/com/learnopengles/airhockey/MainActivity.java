package com.learnopengles.airhockey;

import com.learnopengels.viewutils.RendererWrapper;
import com.learnopengels.viewutils.RendererWrapper2;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private GLSurfaceView glSurfaceView1;
	private GLSurfaceView glSurfaceView2;

	private LinearLayout linearLayout1;
	private LinearLayout linearLayout2;
	private Button button1;
	private Button button2;

	private boolean rendererSet;
	private boolean supportsEs2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		InitView();

		InitGLBaseData();
		glSurfaceView1 = new GLSurfaceView(this);
		glSurfaceView2 = new GLSurfaceView(this);
		glDraw(glSurfaceView1, linearLayout1);
		glDraw2(glSurfaceView2, linearLayout2);
		InitData();
	}

	private void InitView() {
		linearLayout1 = (LinearLayout) findViewById(R.id.layout);
		linearLayout2 = (LinearLayout) findViewById(R.id.layout2);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);

	}

	private void InitData() {
		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				glDraw(glSurfaceView1, linearLayout1);
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				glDraw(glSurfaceView2, linearLayout2);
			}
		});
	}

	private void InitGLBaseData() {

		ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		ConfigurationInfo configurationInfo = activityManager
				.getDeviceConfigurationInfo();
		supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000
				|| isProbablyEmulator();

	}

	private void glDraw(GLSurfaceView glSurfaceView, LinearLayout linearLayout) {
		if (supportsEs2) {

			if (isProbablyEmulator()) {
				// Avoids crashes on startup with some emulator images.
				glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
			}

			glSurfaceView.setEGLContextClientVersion(2);
			glSurfaceView.setRenderer(new RendererWrapper(0));
			rendererSet = true;

			linearLayout.addView(glSurfaceView);
		} else {
			// Should never be seen in production, since the manifest filters
			// unsupported devices.
			Toast.makeText(this, "This device does not support OpenGL ES 2.0.",
					Toast.LENGTH_LONG).show();
			return;
		}
	}

	private void glDraw2(GLSurfaceView glSurfaceView, LinearLayout linearLayout) {
		if (supportsEs2) {

			if (isProbablyEmulator()) {
				// Avoids crashes on startup with some emulator images.
				glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
			}

			glSurfaceView.setEGLContextClientVersion(2);
			glSurfaceView.setRenderer(new RendererWrapper2(1));
			rendererSet = true;

			linearLayout.addView(glSurfaceView);
		} else {
			// Should never be seen in production, since the manifest filters
			// unsupported devices.
			Toast.makeText(this, "This device does not support OpenGL ES 2.0.",
					Toast.LENGTH_LONG).show();
			return;
		}
	}

	private boolean isProbablyEmulator() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
				&& (Build.FINGERPRINT.startsWith("generic")
						|| Build.FINGERPRINT.startsWith("unknown")
						|| Build.MODEL.contains("google_sdk")
						|| Build.MODEL.contains("Emulator") || Build.MODEL
							.contains("Android SDK built for x86"));
	}

	@Override
	protected void onPause() {
		super.onPause();

		if (rendererSet) {
			glSurfaceView1.onPause();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (rendererSet) {
			glSurfaceView1.onResume();
		}
	}
}