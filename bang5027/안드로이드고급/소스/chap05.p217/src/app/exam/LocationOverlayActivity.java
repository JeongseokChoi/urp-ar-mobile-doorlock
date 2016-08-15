package app.exam;

import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class LocationOverlayActivity extends MapActivity {
	private GeoPoint geoPoint;
	private MapView mapView;
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.mapview);
		
		mapView = (MapView) findViewById(R.id.mapView);
		mapView.setSatellite(false);
		mapView.setBuiltInZoomControls(true);
		
		Intent intent = getIntent();
		int latitudeE6 = (int)(intent.getDoubleExtra("latitude", 0) * 1E6);
		int longitudeE6 = (int)(intent.getDoubleExtra("longitude", 0) * 1E6);
		geoPoint = new GeoPoint(latitudeE6, longitudeE6);
		
		MapController mapController = mapView.getController();
		mapController.setZoom(16);
		mapController.setCenter(geoPoint);
		
		List<Overlay> list = mapView.getOverlays();
		DrawOverlay overlay = new DrawOverlay();
		list.add(overlay);
	}
	
	private class DrawOverlay extends Overlay {
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			if(shadow == false) {
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.location);
				
				Projection projection = mapView.getProjection();
				Point point = new Point();
				projection.toPixels(geoPoint, point);
				
				canvas.drawBitmap(bitmap, point.x, point.y, null);
			}
		}
	}
}









