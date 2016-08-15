package app.exam;

import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Bullet {
	private GameView gameView;
	private Bitmap[] bitmaps;
	private Rect actorRect;
	private Rect rect;
	private int direction;
	private Timer timer;
	
	
	public Bullet(GameView gameView, Rect actorRect, int direction) {
		this.gameView = gameView;
		this.actorRect = actorRect;
		this.direction = direction;
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.bullet_01_01)
		};
		rect = new Rect(
				actorRect.left+actorRect.width()/2-5,
				actorRect.top + actorRect.height()/2-5,
				actorRect.left+actorRect.width()/2-5 + bitmaps[0].getWidth(),
				actorRect.top + actorRect.height()/2-5 + bitmaps[0].getHeight()
		);
		
		timer = new Timer();
		timer.schedule(timerTask, 0, 100);
	}
	
	private TimerTask timerTask = new TimerTask() {
		public void run() {
			hitCheck();
			
			if(direction == Arrow.RIGHT) {
				if((rect.right+gameView.background.rect.left) < gameView.getWidth()) {
					rect.left += 8;
					rect.right += 8;
				} else {
					destroy();
				}
			} else if(direction == Arrow.LEFT) {
				if((rect.left+gameView.background.rect.left)>0) {
					rect.left -= 8;
					rect.right -= 8;
				} else {
					destroy();
				}
			} else if(direction == Arrow.DOWN) {
				if((rect.bottom+gameView.background.rect.top)<gameView.getHeight()) {
					rect.top += 8;
					rect.bottom += 8;
				} else {
					destroy();
				}
			} else if(direction == Arrow.UP) {
				if((rect.top+gameView.background.rect.top)>0) {
					rect.top -= 8;
					rect.bottom -= 8;
				} else {
					destroy();
				}
			} 
		};
	};
	
	private void destroy() {
		timer.cancel();
		timer.purge();
		gameView.bulletPool.bullets.remove(this);
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmaps[0], 
				rect.left + gameView.background.rect.left, 
				rect.top + gameView.background.rect.top, 
				null);
	}
	
	private void hitCheck() {
		MonsterPool monsterPool = gameView.monsterPool;
		Monster monster = null;
		for(int i=0; i<monsterPool.monsters.size(); i++) {
			monster = monsterPool.monsters.get(i);
			if(rect.intersect(monster.rect)) {
				monster.die();
				destroy();
				break;
			}
		}
	}
}








