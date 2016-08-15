package app.exam;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends Activity {
	private SensorManager sensorManager;
	private LadybugView ladybugView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ladybugView = (LadybugView) findViewById(R.id.ladybugView);

		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(
				sensorEventListener, 
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_UI);	
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(sensorEventListener);
	}	
	
	private SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
		@Override
		public void onSensorChanged(SensorEvent event) {
			float accX = event.values[0];  
			float accY = event.values[1];
			
			ladybugView.accX = accX;
			ladybugView.accY = accY;
			ladybugView.invalidate();
		}
	};

}