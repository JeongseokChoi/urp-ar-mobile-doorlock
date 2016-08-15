package app.exam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {	
private LocationManager locationManager;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView txtInfo = (TextView) findViewById(R.id.txtInfo);
		txtInfo.setText("위치 제공자로부터 데이터를 기다립니다...");
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 0, 0, locationListener);
	}
	
	private LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			locationManager.removeUpdates(locationListener);
			double latitude =  location.getLatitude();
			double longitude = location.getLongitude();
			
			Uri uri = Uri.parse("geo:" + latitude + "," + longitude + "?z=16");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);
		}
		public void onProviderDisabled(String provider) {}
		public void onProviderEnabled(String provider) {}
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	};
}