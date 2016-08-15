package app.exam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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
			URL url = new URL("http://175.125.160.98:8080/chap03.web/contents_json.jsp");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				Reader reader = new InputStreamReader(is, "euc-kr");
				BufferedReader br = new BufferedReader(reader);
				
				String strJson = "";
				String read = null;
				while((read = br.readLine()) != null) {
					strJson += read;
				}
			
				br.close(); reader.close(); is.close();
				
				JSONArray jsonArray = new JSONArray(strJson);
				for(int i=0; i<jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					Contents contents = new Contents();
					contents.name = jsonObject.getString("name");
					contents.latitude = jsonObject.getDouble("latitude");
					contents.longitude = jsonObject.getDouble("longitude");
					list.add(contents);
				}
				br.close();
				reader.close();
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