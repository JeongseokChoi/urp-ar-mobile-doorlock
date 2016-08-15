package app.exam;

import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Fire {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect rect;
	private int index;
	private Timer timer;
	
	public Fire(GameView gameView) {
		this.gameView = gameView;
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.fire_01_01),
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.fire_01_02),
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.fire_01_03)
		};
		
		rect = new Rect(getPx(320), getPx(192), getPx(320)+bitmaps[0].getWidth(), getPx(192)+bitmaps[0].getHeight());
		
		timer = new Timer();
		timer.schedule(timerTask, 0, 200);
	}
	
	private int getPx(float dp) {
		float dencity = gameView.getResources().getDisplayMetrics().density;
		float px = dp * dencity;
		int result = (int) px;
		return result;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmaps[index], rect.left, rect.top, null);
		if(gameView.gameover) { 
			destroy();
		}
	}
	
	private TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			index++;
			if(index == bitmaps.length) {
				index = 0;
			}
		}
	};
	
	private void destroy() {
		timer.cancel();
		timer.purge();
	}
}












