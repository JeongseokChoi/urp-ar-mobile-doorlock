package ar.app.exam04;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import ar.app.R;

public class Exam04Activity extends Activity {
	//필드
	private ContentsView contentsView;
	//생성시 실행
    @Override
	protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.exam04);
    	contentsView = (ContentsView) findViewById(R.id.contentsView);
    }	
    
    //포그라운드시 실행
    @Override
    protected void onResume() {
    	super.onResume();
    	//장비의 현재 위치를 임의로 줌:GPS를 이용하는 코드로 변경할 것
    	contentsView.addContents(37.495509, 127.025468, null);
    }
    //일시정지시 실행
	@Override
	protected void onPause() {
		super.onPause();
	}	
}
