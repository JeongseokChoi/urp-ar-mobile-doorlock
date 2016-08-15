package app.exam;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		TextView textView = (TextView) findViewById(R.id.textView);
		
		ConnectivityManager cm = 
			(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		
		NetworkInfo[] networkInfos = cm.getAllNetworkInfo();
		
		for(int i=0; i<networkInfos.length; i++) {
			NetworkInfo networkInfo = networkInfos[i];
			textView.append("typeName: " + networkInfo.getTypeName() + "\n");
			textView.append("available: " + networkInfo.isAvailable() + "\n");
			textView.append("connted: " + networkInfo.isConnected() + "\n");
			textView.append("\n");
		}
	}
}