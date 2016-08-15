package ar.app.exam03;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
	//�ʵ�
	private SurfaceHolder surfaceHolder; 
	public Camera camera;
	//������
	public CameraView(Context context, AttributeSet attrs) {
		super(context, attrs);
		surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
	//����ȭ���� �����Ǿ��� �� ȣ��
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			camera = Camera.open();
			camera.setPreviewDisplay(surfaceHolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//����ȭ���� ũ�Ⱑ ����Ǿ��� �� ȣ��
	public void surfaceChanged(SurfaceHolder holder, int format, int width,	int height) {
		camera.startPreview();
	}
    //����ȭ���� �ı��ɶ� ȣ��
	public void surfaceDestroyed(SurfaceHolder holder) {
		camera.stopPreview();
		camera.release();
	}
}
