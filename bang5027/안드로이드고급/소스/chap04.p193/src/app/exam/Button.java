package app.exam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Button {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect rect;
	private int index;
	
	public Button(GameView gameView) {
		this.gameView = gameView;
		bitmaps = new Bitmap[] {
				BitmapFactory.decodeResource(gameView.getResources(), R.drawable.button_01_01),
				BitmapFactory.decodeResource(gameView.getResources(), R.drawable.button_01_02)
		};
		rect = new Rect(getPx(3), getPx(250), getPx(3)+bitmaps[0].getWidth(), getPx(250)+bitmaps[0].getHeight());
	}
	
	private int getPx(float dp) {
		float dencity = gameView.getResources().getDisplayMetrics().density;
		float px = dp * dencity;
		int result = (int) px;
		return result;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmaps[index], rect.left, rect.top, null);
	}
	
	public boolean select(float x, float y) {
		if(rect.contains((int)x, (int)y)) {
			index = 1;
			return true;
		}
		return false;
	}
	
	public void unselect() {
		index = 0;
	}
}













