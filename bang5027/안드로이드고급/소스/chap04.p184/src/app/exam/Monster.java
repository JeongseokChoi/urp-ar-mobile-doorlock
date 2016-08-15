package app.exam;

import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Monster {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect rect;
	
	public Monster(GameView gameView, Rect rect) {
		this.gameView = gameView;
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.monster_01_01)
		};
		this.rect = rect;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(
				bitmaps[0], 
				rect.left + gameView.background.rect.left, 
				rect.top + gameView.background.rect.top, 
				null);
	}
}












