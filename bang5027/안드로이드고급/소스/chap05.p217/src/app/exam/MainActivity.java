package app.exam;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends Activity {
    private ContentsView contentsView;
    private SensorManager sensorManager;
    private int azimuth;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        contentsView = (ContentsView) findViewById(R.id.contentsView);
        
        double deviceLatitude = 37.495509;
        double deviceLongitude = 127.025468;
        String xml = null;
        contentsView.addContents(deviceLatitude, deviceLongitude, xml);
        
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI);
    }
    
    private SensorEventListener listener = new SensorEventListener() {
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			float[] values = event.values;
			float azimuth = values[0];		
			contentsView.changeContentsRect((int)azimuth);
		}    	
    };
    
    protected void onDestroy() {
    	super.onDestroy();
    	sensorManager.unregisterListener(listener);
    };
}







