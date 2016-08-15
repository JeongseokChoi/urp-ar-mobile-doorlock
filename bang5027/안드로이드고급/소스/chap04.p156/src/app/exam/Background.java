package app.exam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Background {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect rect;
	
	public Background(GameView gameView) {
		this.gameView = gameView;
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.map_01)
		};
		rect = new Rect(0, 0, bitmaps[0].getWidth(), bitmaps[0].getHeight());
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmaps[0], rect.left, rect.top, null);
	}
}



