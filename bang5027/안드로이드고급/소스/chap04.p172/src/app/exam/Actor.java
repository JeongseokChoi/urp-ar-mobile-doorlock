package app.exam;

import java.util.Timer;
import java.util.TimerTask;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Actor {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect rect;
	private int direction;
	private int directionStartIndex;
	private int index;
	private Timer timer;
	private MoveTask moveTask;
	
	public Actor(GameView gameView) {
		this.gameView = gameView;
		Resources resources = gameView.getResources();
		bitmaps = new Bitmap[16];
		for(int i=0, id=0x7f020000; i<bitmaps.length; i++, id++) {
			bitmaps[i] = BitmapFactory.decodeResource(resources, id);
		};
		rect = new Rect(100, 100, 100+bitmaps[0].getWidth(), 100+bitmaps[0].getHeight());
		timer = new Timer();
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(
				bitmaps[index], 
				rect.left + gameView.background.rect.left, 
				rect.top + gameView.background.rect.top, 
				null);
	}
	
	public void move(int direction) {
		this.direction = direction;
		
		if(direction == Arrow.RIGHT) { directionStartIndex = 8; }
		else if(direction == Arrow.LEFT) { directionStartIndex = 4; }
		else if(direction == Arrow.DOWN) { directionStartIndex = 0; }
		else if(direction == Arrow.UP) { directionStartIndex = 12; }
		
		index = directionStartIndex;
		
		moveTask = new MoveTask();
		timer.schedule(moveTask, 0, 200);
	}
	
	private class MoveTask extends TimerTask {
		public void run() {
			index++;
			if(index > directionStartIndex+3) {
				index = directionStartIndex;
			}
			
			if(direction == Arrow.RIGHT) {
				if(rect.right < gameView.background.rect.width()) {
					
					if((rect.left+gameView.background.rect.left) >= (gameView.getWidth()/2-rect.width()/2)) {
						gameView.background.move(Arrow.LEFT);
					}
					
					rect.left += 8;
					rect.right += 8;
				}
			} else if(direction == Arrow.LEFT) {
				if(rect.left > 0) {
					
					if((rect.left+gameView.background.rect.left) <= (gameView.getWidth()/2-rect.width()/2)) {
						gameView.background.move(Arrow.RIGHT);
					}
					
					rect.left -= 8;
					rect.right -= 8;
				}
			} else if(direction == Arrow.DOWN) {
				if(rect.bottom < gameView.background.rect.height()) {
					
					if((rect.top + gameView.background.rect.top) >= (gameView.getHeight()/2-rect.height()/2)) {
						gameView.background.move(Arrow.UP);
					}
					
					rect.top += 8;
					rect.bottom += 8;
				}				
			} else if(direction == Arrow.UP) {
				if(rect.top > 0) {
					
					if((rect.top + gameView.background.rect.top) <= (gameView.getHeight()/2-rect.height()/2)) {
						gameView.background.move(Arrow.DOWN);
					}
					
					rect.top -= 8;
					rect.bottom -= 8;
				}
			} 
		};
	};
	
	public void stop() {
		if(moveTask != null) {
			moveTask.cancel();
		}
		timer.purge();
	}
}













