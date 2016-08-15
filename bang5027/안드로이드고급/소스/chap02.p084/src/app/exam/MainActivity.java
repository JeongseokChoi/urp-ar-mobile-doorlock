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
	private TextView txtAzimuth, txtPitch, txtRoll;	
	private SensorManager sensorManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		txtAzimuth = (TextView) findViewById(R.id.txtAzimuth);
		txtPitch = (TextView) findViewById(R.id.txtPitch);
		txtRoll = (TextView) findViewById(R.id.txtRoll);	
		
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(
				sensorEventListener, 
				sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), 
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
			txtAzimuth.setText("Azimuth: " + (int) event.values[0]);             
			txtPitch.setText("Pitch: " + (int) event.values[1]);             
			txtRoll.setText("Roll: " + (int) event.values[2]);
		}
	};
}