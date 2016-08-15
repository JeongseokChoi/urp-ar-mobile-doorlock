package app.exam;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView txtDisplay = (TextView) findViewById(R.id.txtDisplay);
        
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor : list) {
        	txtDisplay.append("센서제품: " + sensor.getName() + ":\n");
        	txtDisplay.append("센서타입: " + sensor.getType() + "\n\n");
        }
    }
}