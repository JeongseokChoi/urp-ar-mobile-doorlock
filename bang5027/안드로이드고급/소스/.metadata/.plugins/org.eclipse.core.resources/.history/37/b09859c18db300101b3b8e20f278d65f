package app.exam;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MainActivity extends MapActivity {	
	private MapView mapView;
	private LocationManager locationManager;	
	private boolean firstLocation;
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mapView = (MapView) findViewById(R.id.mapView);	
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(true);

		firstLocation = true;
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 0, 0, locationListener);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(locationListener);
	}
	
	private LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			double latitude =  location.getLatitude() * 1E6;
			double longitude = location.getLongitude() * 1E6;
			GeoPoint geoPoint = new GeoPoint((int)latitude, (int)longitude);
			
			MapController mapController = mapView.getController();
			mapController.setZoom(16);
			
			if(firstLocation) {
				mapController.setCenter(geoPoint);
				firstLocation = false;
			} else {
				mapController.animateTo(geoPoint);
			}
		}
		public void onProviderDisabled(String provider) {}
		public void onProviderEnabled(String provider) {}
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	};

}