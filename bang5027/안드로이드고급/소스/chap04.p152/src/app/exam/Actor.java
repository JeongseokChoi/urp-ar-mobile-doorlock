package app.exam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Actor {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect rect;
	
	public Actor(GameView gameView) {
		this.gameView = gameView;
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.actor_01_09)
		};
		rect = new Rect(100, 100, 100+bitmaps[0].getWidth(), 100+bitmaps[0].getHeight());
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmaps[0], rect.left, rect.top, null);
	}
}



