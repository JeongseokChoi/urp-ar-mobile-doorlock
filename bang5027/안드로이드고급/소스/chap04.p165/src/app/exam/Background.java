package app.exam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Background {
	private GameView gameView;
	private Bitmap[] bitmaps;
	public Rect rect;
	
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
	
	public void move(int direction) {
		if(direction == Arrow.RIGHT) {
			if(rect.left<0) {
				rect.left += 8;
				rect.right += 8;
			}
		} else if(direction == Arrow.LEFT) {
			if(rect.left > -(rect.width()-gameView.getWidth())) {
				rect.left -= 8;
				rect.right -= 8;
			}
		} else if(direction == Arrow.DOWN) {
			if(rect.top < 0) {
				rect.top += 8;
				rect.bottom += 8;
			}
		} else if(direction == Arrow.UP) {
			if(rect.top > -(rect.height() - gameView.getHeight())) {
				rect.top -= 8;
				rect.bottom -= 8;
			}
		}
	}
}










