package app.exam;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

public class MainActivity extends MapActivity {
	private MapView mapView;
	private LocationManager locationManager;	
	
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
		mapView.setSatellite(false);
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
	}
	
	private LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			locationManager.removeUpdates(locationListener);
			double latitude =  location.getLatitude();
			double longitude = location.getLongitude();
			GeoPoint geoPoint = new GeoPoint((int)(latitude*1E6), (int)(longitude*1E6));
			
			MapController mapController = mapView.getController();
			mapController.setZoom(16);
			mapController.setCenter(geoPoint);
			
			List<Overlay> overlays = mapView.getOverlays();
			//MyLocationOverlay overlay = new MyLocationOverlay(MyLocationOverlayActivity.this, mapView);
			MyLocationOverlay2 overlay = new MyLocationOverlay2(MainActivity.this, mapView);
			overlay.enableCompass();
			overlay.enableMyLocation();
			overlays.add(overlay);
		}
		public void onProviderDisabled(String provider) {}
		public void onProviderEnabled(String provider) {}
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	};
	
	private class MyLocationOverlay2 extends MyLocationOverlay {
		public MyLocationOverlay2(Context context, MapView mapView) {
			super(context, mapView);
		}
	
		@Override
		protected boolean dispatchTap() {
			Toast toast = Toast.makeText(MainActivity.this, "³» À§Ä¡", Toast.LENGTH_SHORT);
			toast.show();
			return true;
		}
	}
}

