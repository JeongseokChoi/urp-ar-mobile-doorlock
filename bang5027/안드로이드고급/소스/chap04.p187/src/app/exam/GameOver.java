package app.exam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class GameOver {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect rect;
	
	public GameOver(GameView gameView) {
		this.gameView = gameView;
		bitmaps = new Bitmap[] {
				BitmapFactory.decodeResource(gameView.getResources(), R.drawable.gameover_01)
		};
		rect = new Rect(
				gameView.getWidth()/2-bitmaps[0].getWidth()/2,
				gameView.getHeight()/2-bitmaps[0].getHeight()/2,
				gameView.getWidth()/2-bitmaps[0].getWidth()/2 + bitmaps[0].getWidth(),
				gameView.getHeight()/2-bitmaps[0].getHeight()/2 + bitmaps[0].getHeight()
		);
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmaps[0], rect.left, rect.top, null);
	}
}
