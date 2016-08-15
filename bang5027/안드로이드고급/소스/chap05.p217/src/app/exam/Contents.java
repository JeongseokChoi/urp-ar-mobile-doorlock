package app.exam;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Contents implements Serializable {
	public String name;
	public String address;
	public String tel;
	public String homepage;
	public String desc;
	public Bitmap icon;
	public double latitude;
	public double longitude;
	
	public int distance;
	public int azimuth;
	public Rect rect;
}
