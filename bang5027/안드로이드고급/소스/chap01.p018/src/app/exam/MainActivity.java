package app.exam;

import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {	
	private TextView txtInfo;
	private LocationManager locationManager;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		txtInfo = (TextView) findViewById(R.id.txtInfo);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
	}
	
	//세팅화면으로 전환할 때 removeUpdates가 되면 안되기 때문에 주석
	/*
	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(locationListener);
	}
	*/
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		locationManager.removeUpdates(locationListener);
	}
	
	private LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			txtInfo.append("위도: " + location.getLatitude() + "\n");
			txtInfo.append("경도: " + location.getLongitude() + "\n\n");
		}
		public void onProviderDisabled(String provider) {
			Log.v("test", "onProviderDisabled");
		}
		public void onProviderEnabled(String provider) {
			Log.v("test", "onProviderEnabled");
		}
		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.v("test", "[onStatusChanged]");
			
			Log.v("test", "[status]");
			switch(status) {
				case LocationProvider.AVAILABLE:
					Log.v("test", "AVAILABLE"); break;
				case LocationProvider.TEMPORARILY_UNAVAILABLE:
					Log.v("test", "TEMPORARILY_UNAVAILABLE"); break;
				case LocationProvider.OUT_OF_SERVICE:
					Log.v("test", "OUT_OF_SERVICE"); break;
			}
			
			Log.v("test", "[extras]");
			Set<String> keys = extras.keySet();
			for(String key : keys) {
				String value = extras.get(key).toString();
				Log.v("test", "key:" + key + ", value:" + value);
			}
		}
	};	
}
