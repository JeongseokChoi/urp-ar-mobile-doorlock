package app.exam;

import java.util.List;

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

public class MainActivity extends MapActivity {
private GeoPoint geoPoint;
	
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
		
		//지도 좌표
		double myLatitude =  37.566547;
		double myLongitude = 126.978189;
		geoPoint = new GeoPoint((int)(myLatitude*1E6), (int)(myLongitude*1E6));
		
		//MapView의 중앙 좌표
		MapController mapController = mapView.getController();
		mapController.setZoom(16);			
		mapController.setCenter(geoPoint);	
		
		//오버레이 추가
		List<Overlay> overlays = mapView.getOverlays();	
		overlays.add(new DrawOverlay());	
	}
	
	private class DrawOverlay extends Overlay {
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			//지도 좌표를 픽셀 좌표로 변환
			Projection projection = mapView.getProjection();
			Point point = new Point();
			projection.toPixels(geoPoint, point);
			
			if(shadow == false) {
				//오버레이의 실제 내용을 드로잉
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball);	
				canvas.drawBitmap(bitmap, point.x, point.y, null);
			} else {
				//오버레이의 그림자 내용을 드로잉
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball_shadow);	
				canvas.drawBitmap(bitmap, point.x, point.y, null);
			}
		}
	}

}
