package app.exam;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class MainActivity extends MapActivity {
	private GeoPoint myGeoPoint, friendGeoPoint;
	private int distance;
	private Paint paint;

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	};	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//MapView 설정
		MapView mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(false);
		
		//내 지도 좌표
		double myLatitude =  37.566547;
		double myLongitude = 126.978189;
		myGeoPoint = new GeoPoint((int)(myLatitude*1E6), (int)(myLongitude*1E6));
		
		//친구 지도 좌표
		double friendLatitude =  37.572951;
		double friendLongitude = 126.979358;
		friendGeoPoint = new GeoPoint((int)(friendLatitude*1E6), (int)(friendLongitude*1E6));
		
		//거리 계산
		float[] flaotDistance = new float[1];
		Location.distanceBetween(myLatitude, myLongitude, 
				friendLatitude, friendLongitude, flaotDistance);
		distance = (int) flaotDistance[0];
		
		//MapView의 중앙 좌표
		MapController mapController = mapView.getController();
		mapController.setZoom(16);			
		mapController.setCenter(myGeoPoint);	
		
		//오버레이 추가
		List<Overlay> overlays = mapView.getOverlays();	
		overlays.add(new MyOverlay());	
		overlays.add(new FriendOverlay());	
		overlays.add(new DistanceOverlay());
		
		//Paint 설정
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		paint.setTextSize(15);
		paint.setFakeBoldText(true);
	}
	
	private class MyOverlay extends Overlay {
		private Rect rect;
		
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			if(shadow == false) {
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo1);
				
				Projection projection = mapView.getProjection();
				Point point = new Point();
				projection.toPixels(myGeoPoint, point);
				
				rect = new Rect(point.x, point.y, 
						point.x + bitmap.getWidth(), point.y + bitmap.getHeight());

				canvas.drawCircle(point.x, point.y, 5, paint);		
				canvas.drawBitmap(bitmap, point.x, point.y, null);
			}
		}
		
		@Override
		public boolean onTap(GeoPoint p, MapView mapView) {
			Projection projection = mapView.getProjection();
			Point point = new Point();
			projection.toPixels(p, point);
			
			if(rect.contains(point.x, point.y)) {				
				Toast toast = Toast.makeText(MainActivity.this, "내 위치", Toast.LENGTH_SHORT);
				toast.show();
				return true;
			} else {
				return false;
			}
		}

	}
	
	private class FriendOverlay extends Overlay {
		private Rect rect;
		
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			if(shadow == false) {
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo2);
				
				Projection projection = mapView.getProjection();
				Point point = new Point();
				projection.toPixels(friendGeoPoint, point);

				rect = new Rect(point.x, point.y, 
						point.x + bitmap.getWidth(), point.y + bitmap.getHeight());
				
				canvas.drawCircle(point.x, point.y, 5, paint);		
				canvas.drawBitmap(bitmap, point.x, point.y, null);
			}
		}
		
		@Override
		public boolean onTap(GeoPoint p, MapView mapView) {
			Projection projection = mapView.getProjection();
			Point point = new Point();
			projection.toPixels(p, point);
			
			if(rect.contains(point.x, point.y)) {				
				Toast toast = Toast.makeText(MainActivity.this, "친구 위치", Toast.LENGTH_SHORT);
				toast.show();
				return true;
			} else {
				return false;
			}
		}

	}
	
	private class DistanceOverlay extends Overlay {
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			if(shadow == false) {
				Projection projection = mapView.getProjection();
				Point myPixelPoint = new Point();
				projection.toPixels(myGeoPoint, myPixelPoint);
				Point friendPixelPoint = new Point();
				projection.toPixels(friendGeoPoint, friendPixelPoint);
				
				canvas.drawLine(myPixelPoint.x, myPixelPoint.y, friendPixelPoint.x, friendPixelPoint.y, paint);				
				canvas.drawText(distance+"m", (myPixelPoint.x+friendPixelPoint.x)/2, (myPixelPoint.y+friendPixelPoint.y)/2, paint);
			}
		}
	}

}
