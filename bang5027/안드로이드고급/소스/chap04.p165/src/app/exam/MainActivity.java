package app.exam;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        /*
        GameView gameView = new GameView(this);
        setContentView(gameView);
        */        
        setContentView(R.layout.main);
        
        Log.v(
        	"test",
        	String.valueOf(getResources().getDisplayMetrics().density)
        );
        
        Log.v(
            	"test",
            	String.valueOf(getResources().getDisplayMetrics().densityDpi)
        );
    }
}