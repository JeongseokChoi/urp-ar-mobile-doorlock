package ar.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ar.app.exam01.Exam01Activity;
import ar.app.exam02.Exam02Activity;
import ar.app.exam03.Exam03Activity;
import ar.app.exam04.Exam04Activity;
import ar.app.exam05.Exam05Activity;
import ar.app.exam06.Exam06Activity;

public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        findViewById(R.id.btnExam01).setOnClickListener(this);
        findViewById(R.id.btnExam02).setOnClickListener(this);
        findViewById(R.id.btnExam03).setOnClickListener(this);
        findViewById(R.id.btnExam04).setOnClickListener(this);
        findViewById(R.id.btnExam05).setOnClickListener(this);
        findViewById(R.id.btnExam06).setOnClickListener(this);
    }
    
    public void onClick(View v) {
    	Intent intent = null;
    	switch(v.getId()) {
	    	case R.id.btnExam01:
	    		intent = new Intent(this, Exam01Activity.class);
	    		break;
	    	case R.id.btnExam02:
	    		intent = new Intent(this, Exam02Activity.class);
	    		break;
	    	case R.id.btnExam03:
	    		intent = new Intent(this, Exam03Activity.class);
	    		break;
	    	case R.id.btnExam04:
	    		intent = new Intent(this, Exam04Activity.class);
	    		break;
	    	case R.id.btnExam05:
	    		intent = new Intent(this, Exam05Activity.class);
	    		break;
	    	case R.id.btnExam06:
	    		intent = new Intent(this, Exam06Activity.class);
	    		break;	
    	}
    	startActivity(intent);
    }
}