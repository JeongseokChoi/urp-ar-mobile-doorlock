package app.exam;

import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.SoundPool;

public class Monster {
	private GameView gameView;
	private static Bitmap[] bitmaps;
	public Rect rect;
	private boolean dying;
	private Timer timer;
	private int index;
	private SoundPool soundPool;
	private int explosionSound;
	
	public Monster(GameView gameView, Rect rect) {
		this.gameView = gameView;
		
		bitmaps = new Bitmap[13];
		bitmaps[0] = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.monster_01_01);
		for(int i=1, id=0x7f02001c; i<=12; i++, id++) {
			bitmaps[i] = BitmapFactory.decodeResource(gameView.getResources(), id);
		}
		
		this.rect = rect;
		timer = new Timer();
		
		soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		explosionSound = soundPool.load(gameView.getContext(), R.raw.explosion, 1);
	}
	
	public void draw(Canvas canvas) {
		if(index < 8) {
			canvas.drawBitmap(
					bitmaps[0], 
					rect.left + gameView.background.rect.left, 
					rect.top + gameView.background.rect.top, 
					null);
		}
		
		if(index != 0) {
			canvas.drawBitmap(
					bitmaps[index], 
					(rect.left + gameView.background.rect.left) - (bitmaps[1].getWidth()/2-rect.width()/2), 
					(rect.top + gameView.background.rect.top) - (bitmaps[1].getHeight()/2-rect.height()/2), 
					null);
		}
	}
	
	public void die() {
		if(dying == false) {
			dying = true;
			timer.schedule(timerTask, 0, 300);
			soundPool.play(explosionSound, 1, 1, 0, 0, 1);
		}
	}
	
	private TimerTask timerTask = new TimerTask() {
		public void run() {
			index++;
			if(index == (bitmaps.length-1)) {
				timer.cancel();
				timer.purge();
				gameView.monsterPool.monsters.remove(Monster.this);
			}
		};
	};
}












