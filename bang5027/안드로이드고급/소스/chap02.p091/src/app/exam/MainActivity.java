package app.exam;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends Activity {
	private AzimuthView azimuthView;
	private RollView rollView;
	private PitchView pitchView;
	private SensorManager sensorManager;
	private float[] accelerometerValues, magneticValues;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);

    	pitchView = (PitchView) findViewById(R.id.pitchView);
        rollView = (RollView) findViewById(R.id.rollView);
        azimuthView = (AzimuthView) findViewById(R.id.azimuthView);
        
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(
				sensorEventListener, 
				sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 
				SensorManager.SENSOR_DELAY_UI);
		sensorManager.registerListener(
				sensorEventListener, 
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
				SensorManager.SENSOR_DELAY_UI);
    }
   
    @Override
    protected void onStop() {
    	super.onStop();
    	sensorManager.unregisterListener(sensorEventListener);
    }	
	
	private SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
		@Override
		public void onSensorChanged(SensorEvent event) {	
			switch (event.sensor.getType()) {             
				case Sensor.TYPE_ACCELEROMETER:
					accelerometerValues = event.values.clone();
					break;
				case Sensor.TYPE_MAGNETIC_FIELD:
					magneticValues = event.values.clone();
					break;
			}			
			if (magneticValues != null && accelerometerValues != null) {           
				float[] R = new float[16];             
				float[] I = new float[16];              
				SensorManager.getRotationMatrix(R, I, accelerometerValues, magneticValues);              
				float[] values = new float[3];             
				SensorManager.getOrientation(R, values); 	
				
				pitchView.pitch = (int) radian2Degree(values[1]);		
				pitchView.invalidate();
				
				rollView.roll = (int) radian2Degree(values[2]);
				rollView.invalidate();
				
				azimuthView.azimuth = (int) radian2Degree(values[0]);
				azimuthView.invalidate();				
			}
		}
	};
	
	private float radian2Degree(float radian) {
        return radian * 180 / (float)Math.PI;
	}	
}