package app.exam;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView txtInfo;
	private LocationManager locationManager;
	private PendingIntent pendingIntent;
	private double homeLatitude;
	private double homeLongitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		txtInfo = (TextView) findViewById(R.id.txtInfo);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);		
		Intent intent = new Intent("location.app.proximityAlertReceiver");
		pendingIntent = PendingIntent.getBroadcast(
				this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);		
				
		homeLatitude = 37.503099;
		homeLongitude = 127.052997;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		txtInfo.append("[근접경보 실행중]\n");
		
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("location.app.proximityAlertReceiver");
		registerReceiver(proximityAlertReceiver, intentFilter);		
		
		locationManager.addProximityAlert(
				homeLatitude, homeLongitude, 100, -1, pendingIntent);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		txtInfo.append("[근접경보 중지됨]\n");
		unregisterReceiver(proximityAlertReceiver);
		locationManager.removeProximityAlert(pendingIntent);
	}
	
	private BroadcastReceiver proximityAlertReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			boolean proximity = intent.getBooleanExtra(
					LocationManager.KEY_PROXIMITY_ENTERING, false);
			if(proximity) {
				txtInfo.append("100m 이내로 근접했습니다.\n");
			} else {
				txtInfo.append("100m 이상을 벗어났습니다.\n");
			}
		}
	};

}