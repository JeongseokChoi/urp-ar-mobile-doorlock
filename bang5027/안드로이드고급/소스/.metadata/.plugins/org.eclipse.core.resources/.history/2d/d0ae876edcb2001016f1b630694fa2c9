package app.exam;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView txtInfo = (TextView) findViewById(R.id.txtInfo);
		
		LocationManager locationManager = 
			(LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(true);
		criteria.setCostAllowed(false);
		criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);
		
		String bestProviderName = locationManager.getBestProvider(criteria, true);
		
		txtInfo.append("가장 적합한 위치 제공자: " + bestProviderName);
	}
}
