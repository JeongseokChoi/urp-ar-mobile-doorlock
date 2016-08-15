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
		
		//MapView ����
		MapView mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(false);
		
		//���� ��ǥ
		double myLatitude =  37.566547;
		double myLongitude = 126.978189;
		geoPoint = new GeoPoint((int)(myLatitude*1E6), (int)(myLongitude*1E6));
		
		//MapView�� �߾� ��ǥ
		MapController mapController = mapView.getController();
		mapController.setZoom(16);			
		mapController.setCenter(geoPoint);	
		
		//�������� �߰�
		List<Overlay> overlays = mapView.getOverlays();	
		overlays.add(new DrawOverlay());	
	}
	
	private class DrawOverlay extends Overlay {
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			//���� ��ǥ�� �ȼ� ��ǥ�� ��ȯ
			Projection projection = mapView.getProjection();
			Point point = new Point();
			projection.toPixels(geoPoint, point);
			
			if(shadow == false) {
				//���������� ���� ������ �����
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball);	
				canvas.drawBitmap(bitmap, point.x, point.y, null);
			} else {
				//���������� �׸��� ������ �����
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball_shadow);	
				canvas.drawBitmap(bitmap, point.x, point.y, null);
			}
		}
	}

}
