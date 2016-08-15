package app.exam;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		
		imageView = (ImageView) findViewById(R.id.imageView);		
		
		thread.start();		
	}
	
	private Thread thread = new Thread() {
		@Override
		public void run() {
			try {
				URL url = new URL("http://175.125.160.98:8080/chap03.web/image.png");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					InputStream is = conn.getInputStream();
					Bitmap bitmap = BitmapFactory.decodeStream(is);
					Message msg = Message.obtain();
					msg.obj = bitmap;
					handler.sendMessage(msg);
					is.close();
				}
				conn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	};
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Bitmap bitmap = (Bitmap) msg.obj;
			imageView.setImageBitmap(bitmap);
		}
	};
}