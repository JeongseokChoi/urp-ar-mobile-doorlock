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
	
	public Arrow(GameView gameView) {
		this.gameView = gameView;
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_01), 
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_02), //©Л
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_03), //аб
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_04), //го
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.arrow_01_05) //╩С
		};
		rect = new Rect(384, 224, 384+bitmaps[0].getWidth(), 224+bitmaps[0].getHeight());
		arrows = new Rect[] {
				new Rect(448, 256, 480, 288), //©Л
				new Rect(384, 256, 416, 288), //аб
				new Rect(416, 288, 448, 320), //го
				new Rect(416, 224, 448, 256)  //╩С
		};
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










