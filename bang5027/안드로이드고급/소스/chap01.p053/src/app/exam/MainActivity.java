package app.exam;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;

public class MainActivity extends MapActivity {
	private MapView mapView;
	
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

		double latitude =  37.511053 * 1E6;
		double longitude = 127.073774 * 1E6;
		GeoPoint geoPoint = new GeoPoint((int)latitude, (int)longitude);
		
		MapController mapController = mapView.getController();
		mapController.setZoom(16);
		mapController.setCenter(geoPoint);
		
		ImageView imageView1 = new ImageView(this);
		imageView1.setImageResource(R.drawable.location1);
		imageView1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN) {
					Toast toast = Toast.makeText(MainActivity.this, "내 위치", Toast.LENGTH_SHORT);
					toast.show();
				}
				return true;
			}			
		});

		MapView.LayoutParams params1 = new MapView.LayoutParams(
			LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
			geoPoint,
			MapView.LayoutParams.BOTTOM_CENTER
		);
		mapView.addView(imageView1, params1);
		
		ImageView imageView2 = new ImageView(this);
		imageView2.setImageResource(R.drawable.location2);
		imageView2.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN) {
					Toast toast = Toast.makeText(MainActivity.this, "친구 위치", Toast.LENGTH_SHORT);
					toast.show();
				}
				return true;
			}			
		});

		MapView.LayoutParams params2 = new MapView.LayoutParams(
			LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
			150,100,
			MapView.LayoutParams.BOTTOM_CENTER
		);
		mapView.addView(imageView2, params2);
	}
}
