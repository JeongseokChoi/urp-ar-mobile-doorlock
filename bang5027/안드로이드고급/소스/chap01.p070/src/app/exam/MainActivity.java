package app.exam;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MainActivity extends MapActivity {
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		MapView mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(false);
		
		double seoulCenterLatitude =  37.538176;
		double seoulCenterLongitude = 127.027454;
		GeoPoint geoPoint = new GeoPoint(
				(int)(seoulCenterLatitude*1E6), 
				(int)(seoulCenterLongitude*1E6));
		
		MapController mapController = mapView.getController();
		mapController.setZoom(12);
		mapController.setCenter(geoPoint);
		
		List<Overlay> overlays = mapView.getOverlays();		
		Resources resources = getResources();
		Drawable drawable = resources.getDrawable(R.drawable.location2);
		MarkerOverlay markerOverlay = new MarkerOverlay(drawable);
		overlays.add(markerOverlay);
	}
	
	private class MarkerOverlay extends ItemizedOverlay<OverlayItem> {
		private List<OverlayItem> overlayItems;
		
		public MarkerOverlay(Drawable defaultMarker) {
			super(defaultMarker);
			boundCenterBottom(defaultMarker);
			
			String[][] locations = {
				{ "37.576367", "126.984330", "02-722-8301" },
				{ "37.537902", "127.124567", "02-471-8296" },
				{ "37.558481", "126.975438", "02-771-8306" },
				{ "37.540658", "127.070725", "02-499-8305" },
				{ "37.564118", "126.984469", "02-3789-8318" },
				{ "37.507620", "127.062691", "02-558-8320" },
				{ "37.491395", "126.923356", "02-123-1234" },
				{ "37.481116", "127.013492", "02-234-6789" },
				{ "37.581507", "127.002326", "02-765-8315" },
				{ "37.583467", "127.001137", "02-744-8316" }
			};
			
			overlayItems = new ArrayList<OverlayItem>();
			for(int i=0; i<locations.length; i++) {
				GeoPoint geoPoint = new GeoPoint(
					(int)(Double.parseDouble(locations[i][0])*1E6),
					(int)(Double.parseDouble(locations[i][1])*1E6)
				);	
				OverlayItem overlayItem = new OverlayItem(geoPoint, "½ºÅ¸¹÷½º", locations[i][2]);
				overlayItems.add(overlayItem);
			}
			
			populate();
		}

		@Override
		protected OverlayItem createItem(int i) {
			return overlayItems.get(i);
		}
		
		@Override
		public int size() {
			return overlayItems.size();
		}
	}
}

