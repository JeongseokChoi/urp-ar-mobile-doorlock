package ar.app.exam03;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
	//필드
	private SurfaceHolder surfaceHolder; 
	public Camera camera;
	//생성자
	public CameraView(Context context, AttributeSet attrs) {
		super(context, attrs);
		surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
	//가상화면이 생성되었을 때 호출
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			camera = Camera.open();
			camera.setPreviewDisplay(surfaceHolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//가상화면의 크기가 변경되었을 때 호출
	public void surfaceChanged(SurfaceHolder holder, int format, int width,	int height) {
		camera.startPreview();
	}
    //가상화면이 파괴될때 호출
	public void surfaceDestroyed(SurfaceHolder holder) {
		camera.stopPreview();
		camera.release();
	}
}
