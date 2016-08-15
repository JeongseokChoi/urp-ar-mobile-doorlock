package app.exam;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.location.Location;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ContentsView extends View {
	public List<Contents> list;
	private Paint textPaint;
	private int deviceAzimuth;
	
	public ContentsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		list = new ArrayList<Contents>();
		
		textPaint = new Paint();
		textPaint.setColor(Color.WHITE);
		textPaint.setAntiAlias(true);
		textPaint.setTextSize(getPx(10));
		textPaint.setFakeBoldText(true);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		if(deviceAzimuth == 0) {
			changeContentsRect(0);
		}
		
		Contents contents = null;
		for(int i=0; i<list.size(); i++) {
			contents = list.get(i);
			canvas.drawBitmap(contents.icon, contents.rect.left, contents.rect.top, null);
			canvas.drawText(contents.name, contents.rect.left, contents.rect.bottom+getPx(10), textPaint);
		}
	}
	
	private int getPx(int dp) {
		float dencity = getResources().getDisplayMetrics().density;
		int px = (int) (dp * dencity);
		return px;
	}
	
	public void addContents(double deviceLatitude, double deviceLongitude, String xml) {
		Contents contents = null;
		float[] results = new float[2];
		
		contents = new Contents();
		contents.name = "버거킹 강남점";
		contents.icon = BitmapFactory.decodeResource(getResources(), R.drawable.burgerking_icon);
		contents.latitude = 37.496009;
		contents.longitude = 127.025468;		
		Location.distanceBetween(deviceLatitude, deviceLongitude, contents.latitude, contents.longitude, results);		
		contents.distance = (int) results[0];
		contents.azimuth = (int) ((results[1]>=0)?results[1]:(360+results[1]));
		contents.rect = new Rect(0,0,0,0);
		list.add(contents);
		
		contents = new Contents();
		contents.name = "피자헛 강남점";
		contents.icon = BitmapFactory.decodeResource(getResources(), R.drawable.pizzahut_icon);
		contents.latitude = 37.495509;
		contents.longitude = 127.027468;		
		Location.distanceBetween(deviceLatitude, deviceLongitude, contents.latitude, contents.longitude, results);		
		contents.distance = (int) results[0];
		contents.azimuth = (int) ((results[1]>=0)?results[1]:(360+results[1]));
		contents.rect = new Rect(0,0,0,0);
		list.add(contents);
		
		contents = new Contents();
		contents.name = "맥도날드 강남점";
		contents.icon = BitmapFactory.decodeResource(getResources(), R.drawable.mcdonald_icon);
		contents.latitude = 37.495000;
		contents.longitude = 127.026468;		
		Location.distanceBetween(deviceLatitude, deviceLongitude, contents.latitude, contents.longitude, results);		
		contents.distance = (int) results[0];
		contents.azimuth = (int) ((results[1]>=0)?results[1]:(360+results[1]));
		contents.rect = new Rect(0,0,0,0);
		list.add(contents);
		
		contents = new Contents();
		contents.name = "강남 약국";
		contents.icon = BitmapFactory.decodeResource(getResources(), R.drawable.drugstore_icon);
		contents.latitude = 37.495509;
		contents.longitude = 127.024468;		
		Location.distanceBetween(deviceLatitude, deviceLongitude, contents.latitude, contents.longitude, results);		
		contents.distance = (int) results[0];
		contents.azimuth = (int) ((results[1]>=0)?results[1]:(360+results[1]));
		contents.rect = new Rect(0,0,0,0);
		list.add(contents);
	}

	public void changeContentsRect(int deviceAzimuth) {
		this.deviceAzimuth = deviceAzimuth;
		if(getWidth() != 0) {
			Contents contents = null;
			for(int i=0; i<list.size(); i++) {
				contents = list.get(i);
				int x = (int)(getPx(contents.distance) * Math.sin((contents.azimuth-deviceAzimuth)*Math.PI/180));
				int y = (int)(getPx(contents.distance) * Math.cos((contents.azimuth-deviceAzimuth)*Math.PI/180));
				contents.rect.left = getWidth()/2 + x - contents.icon.getWidth()/2;
				contents.rect.top = getHeight()/2 - y - contents.icon.getHeight()/2;
				contents.rect.right = contents.rect.left + contents.icon.getWidth();
				contents.rect.bottom = contents.rect.top + contents.icon.getHeight();
			}
			invalidate();
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			float x = event.getX();
			float y = event.getY();
			for(int i=0; i<list.size(); i++) {
				Contents contents = list.get(i);
				if(contents.rect.contains((int)x, (int)y)) {
					Intent intent = new Intent(getContext(), LocationOverlayActivity.class);
					intent.putExtra("latitude", contents.latitude);
					intent.putExtra("longitude", contents.longitude);
					getContext().startActivity(intent);
				} 
			}
		}
		return true;
	}
}








