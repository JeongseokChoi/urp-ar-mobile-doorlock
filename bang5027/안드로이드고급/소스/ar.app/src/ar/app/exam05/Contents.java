package ar.app.exam05;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Contents {
	//이름
	public String name;
	//주소
	public String address;
	//전화번호
	public String tel;	
	//홈페이지
	public String homepage;
	//설명
	public String desc;
	//아이콘
	public Bitmap icon;
	//위도 경도
	public double latitude;
	public double longitude;
	//장비와의 거리
	public int distance;
	//정북에 대한 방위각
	public int azimuth;
	//드로잉할 영역
	public Rect rect;
}
