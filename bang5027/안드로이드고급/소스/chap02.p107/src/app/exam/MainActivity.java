package app.exam;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView txtProximity;	
	private SensorManager sensorManager;
	private MediaPlayer mediaPlayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		txtProximity = (TextView) findViewById(R.id.txtProximity);	
		
		mediaPlayer = MediaPlayer.create(this, R.raw.ahhh);
		mediaPlayer.setVolume(10, 10);
		
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(
				sensorEventListener, 
				sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), 
				SensorManager.SENSOR_DELAY_UI);	
	}
	
	@Override
	protected void onDestroy() {
		super.onPause();
		sensorManager.unregisterListener(sensorEventListener);
	}	
	
	private SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
		@Override
		public void onSensorChanged(SensorEvent event) {
			float value = event.values[0];
			if(value == 0) {
				txtProximity.setText("Ahhh~");
				mediaPlayer.setLooping(true);
				mediaPlayer.start();
			} else if(value == 1) {
				txtProximity.setText("근접하면 소리지르겠삼.");
				mediaPlayer.setLooping(false);
			}
		}
	};
}