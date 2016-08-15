package app.exam;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView txtInfo;
	private LocationManager locationManager;
	private PendingIntent pendingIntent;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		txtInfo = (TextView) findViewById(R.id.txtInfo);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//BroadcastReceiver 등록
		IntentFilter filter = new IntentFilter();
		filter.addAction("chap01.p020.broadcastreceiver");
		registerReceiver(broadcastReceiver, filter);
		//PendingIntent 등록
		Intent intent = new Intent("chap01.p020.broadcastreceiver");
		pendingIntent = PendingIntent.getBroadcast(
				this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 1000, 0, pendingIntent);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		//BroadcastReceiver 제거
		unregisterReceiver(broadcastReceiver);
		//PendingIntent 제거
		locationManager.removeUpdates(pendingIntent);	
	}
	
	private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			Location location = (Location) intent.getParcelableExtra(
					LocationManager.KEY_LOCATION_CHANGED);
			if(location != null) {
				txtInfo.append("위도: " + location.getLatitude() + "\n");
				txtInfo.append("경도: " + location.getLongitude() + "\n\n");
			}
		}
	};	

}