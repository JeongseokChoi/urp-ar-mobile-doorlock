package app.exam;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView txtAccX, txtAccY, txtAccZ;
	private SensorManager sensorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		txtAccX = (TextView) findViewById(R.id.txtAccX);
		txtAccY = (TextView) findViewById(R.id.txtAccY);
		txtAccZ = (TextView) findViewById(R.id.txtAccZ);
		
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
			float accZ = event.values[2];
			
			txtAccX.setText("X축 가속도: " + accX + " m/s2");
			txtAccY.setText("Y축 가속도: " + accY + " m/s2");
			txtAccZ.setText("Z축 가속도: " + accZ + " m/s2");
		}
	};
}