package app.exam;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder holder;
	private Camera camera;
	
	public CameraView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CameraView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CameraView(Context context) {
		super(context);
		init();
	}

	private void init() {
		holder = getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			camera = Camera.open();
			camera.setPreviewDisplay(holder);
			camera.setDisplayOrientation(90);			
			camera.startPreview();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		camera.stopPreview();
		camera.release();
	}
}
