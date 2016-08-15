package app.exam;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		
		ImageView imageView = (ImageView) findViewById(R.id.imageView);		
		
		Bitmap bitmap = getImageDownload();
		imageView.setImageBitmap(bitmap);		
	}
	
	public Bitmap getImageDownload() {
		Bitmap bitmap = null;
		try {
			URL url = new URL("http://175.125.160.98:8080/chap03.web/image.png");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				bitmap = BitmapFactory.decodeStream(is);
				is.close();
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}
}