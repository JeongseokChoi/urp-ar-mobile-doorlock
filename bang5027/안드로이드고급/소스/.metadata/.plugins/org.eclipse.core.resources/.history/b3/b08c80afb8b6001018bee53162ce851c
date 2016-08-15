package app.exam;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		
		TextView textView = (TextView) findViewById(R.id.textView);		
		
		List<Contents> list = getContentsList();
		for(int i=0; i<list.size(); i++) {
			Contents contents = list.get(i);
			textView.append(contents.name + "\n");
			textView.append(contents.latitude + "\n");
			textView.append(contents.longitude + "\n");
			textView.append("\n");
		}
	}
	
	public List<Contents> getContentsList() {
		List<Contents> list = new ArrayList<Contents>();
		try {
			URL url = new URL("http://175.125.160.98:8080/chap03.web/contents_xml.jsp");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				XmlPullParser parser = factory.newPullParser();
				parser.setInput(is, "euc-kr");
				
				Contents contents = null;
				boolean isLatitude = false;
				boolean isLongitude = false;
				int eventType = parser.getEventType();
				while(eventType != XmlPullParser.END_DOCUMENT) {
					if(eventType == XmlPullParser.START_TAG) {
						if(parser.getName().equals("contents")) {
							contents = new Contents();
							contents.name = parser.getAttributeValue(null, "name");
						} else if(parser.getName().equals("latitude")) {
							isLatitude = true;
						} else if(parser.getName().equals("longitude")) {
							isLongitude = true;
						}
					} else if(eventType == XmlPullParser.TEXT) {
						if(isLatitude) {
							contents.latitude = Double.parseDouble(parser.getText());
							isLatitude = false;
						} else if(isLongitude) {
							contents.longitude = Double.parseDouble(parser.getText());
							isLongitude = false;
						}
					} else if(eventType == XmlPullParser.END_TAG) {
						if(parser.getName().equals("contents")) {
							list.add(contents);
						}
					}
					eventType = parser.next();
				}
				
				is.close();
			}
			conn.disconnect();
		} catch (Exception e) {
			Log.d("test", e.toString());
			e.printStackTrace();
		}
		return list;
	}		
}