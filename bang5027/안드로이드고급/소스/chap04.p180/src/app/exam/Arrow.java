package app.exam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Arrow {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect rect;
	private Rect[] arrows;
	private int index;
	public static int RIGHT = 1;
	public static int LEFT = 2;
	public static int DOWN = 3;
	public static int UP = 4;
	private float dencity;
	
	public Arrow(GameView gameView) {
		this.gameView = gameView;
		dencity = gameView.getResources().getDisplayMetrics().density;
		
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_01), 
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_02), //©Л
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_03), //аб
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_04), //го
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_05) //╩С
		};
		rect = new Rect(getPx(384), getPx(224), getPx(384)+bitmaps[0].getWidth(), getPx(224)+bitmaps[0].getHeight());
		arrows = new Rect[] {
				new Rect(getPx(448), getPx(256), getPx(480), getPx(288)), //©Л
				new Rect(getPx(384), getPx(256), getPx(416), getPx(288)), //аб
				new Rect(getPx(416), getPx(288), getPx(448), getPx(320)), //го
				new Rect(getPx(416), getPx(224), getPx(448), getPx(256))  //╩С
		};
		
	}
	
	private int getPx(float dp) {
		float px = dp * dencity;
		int result = (int) px;
		return result;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmaps[index], rect.left, rect.top, null);
	}
	
	public int select(float x, float y) {
		for(int i=0; i<4; i++) {
			if(arrows[i].contains((int)x, (int)y)) {
				index = i+1;
				return index;
			}
		}
		return 0;
	}
	
	public void unselect() {
		index = 0;
	}
}










