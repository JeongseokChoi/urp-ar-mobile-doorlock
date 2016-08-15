package ar.app.exam05;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import ar.app.R;

public class Exam05Activity extends Activity {
	//필드
	private ContentsView contentsView;
	private SensorManager sensorManager;
	private int azimuth;	
	
	//생성시 실행
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exam05);
		contentsView = (ContentsView) findViewById(R.id.contentsView);
    }	
    
	//포그라운드시 실행
	@Override
	protected void onResume() {
		super.onResume();
		//장비의 현재 위치를 임의로 줌:GPS를 이용하는 코드로 변경할 것
		contentsView.addContents(37.495509, 127.025468, null);
    	
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(
				sensorEventListener, 
				sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), 
				SensorManager.SENSOR_DELAY_UI);	
	}
	//일시정지시 실행
	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(sensorEventListener);
	}	
	//센서 이벤트 처리
	private SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
		@Override
		public void onSensorChanged(SensorEvent event) {
			azimuth = (int) event.values[0];
			contentsView.changeContentsRect(azimuth);
		}
	};
}
