package ar.app.exam05;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import ar.app.R;

public class ContentsView extends View {
	//필드
	public List<Contents> list;
	private Paint textPaint;
	private int deviceAzimuth;
	//생성자
	public ContentsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		textPaint = new Paint();
		textPaint.setColor(Color.argb(255, 255, 255, 255));
		textPaint.setAntiAlias(true);
		textPaint.setTextSize(10);
		textPaint.setFakeBoldText(true);
	}
	//컨텐츠 드로잉
	@Override
	protected void onDraw(Canvas canvas) {
		if(deviceAzimuth == 0) {
			changeContentsRect(0);
		}
		Contents contents = null;
		for(int i=0; i<list.size(); i++) {
			contents = list.get(i);
			canvas.drawBitmap(contents.icon, contents.rect.left, contents.rect.top, null);
			canvas.drawText(contents.name, contents.rect.left, contents.rect.bottom+10, textPaint);
		}
	}
	//컨텐츠 추가
	public void addContents(double deviceLatitude, double deviceLongitude, String xml) {
		list = new ArrayList<Contents>();
		
		Contents contents = null;	
		
		contents = new Contents();		
		contents.name = "버거킹 강남점";
		contents.icon = BitmapFactory.decodeResource(getResources(), R.drawable.burgerking_icon);
		contents.latitude = 37.496009;
		contents.longitude = 127.025468;
		contents.azimuth = getAzimuth(contents.longitude-deviceLongitude, contents.latitude-deviceLatitude);
		float[] results = new float[1];
		Location.distanceBetween(deviceLatitude, deviceLongitude, contents.latitude, contents.longitude, results);
		contents.distance = (int) results[0];
		contents.rect = new Rect(0,0,0,0);
		list.add(contents);
		
		contents = new Contents();		
		contents.name = "피자헛 강남점";
		contents.icon = BitmapFactory.decodeResource(getResources(), R.drawable.pizzahut_icon);
		contents.latitude = 37.495509;
		contents.longitude = 127.027468;
		contents.azimuth = getAzimuth(contents.longitude-deviceLongitude, contents.latitude-deviceLatitude);
		results = new float[1];
		Location.distanceBetween(deviceLatitude, deviceLongitude, contents.latitude, contents.longitude, results);
		contents.distance = (int) results[0];
		contents.rect = new Rect(0,0,0,0);		
		list.add(contents);
		
		contents = new Contents();
		contents.name = "맥도날드 강남점";
		contents.icon = BitmapFactory.decodeResource(getResources(), R.drawable.mcdonald_icon);
		contents.latitude = 37.495000;
		contents.longitude = 127.026468;
		contents.azimuth = getAzimuth(contents.longitude-deviceLongitude, contents.latitude-deviceLatitude);
		results = new float[1];
		Location.distanceBetween(deviceLatitude, deviceLongitude, contents.latitude, contents.longitude, results);
		contents.distance = (int) results[0];
		contents.rect = new Rect(0,0,0,0);		
		list.add(contents);
		
		contents = new Contents();	
		contents.name = "강남 약국";
		contents.icon = BitmapFactory.decodeResource(getResources(), R.drawable.drugstore_icon);
		contents.latitude = 37.495509;
		contents.longitude = 127.024468;
		contents.azimuth = getAzimuth(contents.longitude-deviceLongitude, contents.latitude-deviceLatitude);
		results = new float[1];
		Location.distanceBetween(deviceLatitude, deviceLongitude, contents.latitude, contents.longitude, results);
		contents.distance = (int) results[0];
		contents.rect = new Rect(0,0,0,0);		
		list.add(contents);
	}
	//컨텐츠의 방위각 계산
	public int getAzimuth(double x, double y) {
		int azimuth;		
		int angle = (int) (Math.atan2(y, x)*180/Math.PI);		
		if(angle>=0) {
			if(angle<=90) {
				azimuth = 90 - angle;
			} else {
				azimuth = (360 - angle) + 90;
			}
		} else {
			azimuth = 90 + Math.abs(angle);
		}
		return azimuth;
	}	
	//장비의 방위각에 따라 컨텐츠의 위치 변경
	public void changeContentsRect(int deviceAzimuth) {
		this.deviceAzimuth = deviceAzimuth;
		Contents contents = null;
		for(int i=0; i<list.size(); i++) {
			contents = list.get(i);
			int x = (int) (contents.distance * Math.sin((contents.azimuth-deviceAzimuth)*Math.PI/180));
			int y = (int) (contents.distance * Math.cos((contents.azimuth-deviceAzimuth)*Math.PI/180));				
			contents.rect.left = getWidth()/2+(x - contents.icon.getWidth()/2);
			contents.rect.top = getHeight()/2-(y + contents.icon.getHeight()/2);
			contents.rect.right = contents.rect.left + contents.icon.getWidth();
			contents.rect.bottom = contents.rect.top + contents.icon.getHeight();
		}
		invalidate();
	}
}

