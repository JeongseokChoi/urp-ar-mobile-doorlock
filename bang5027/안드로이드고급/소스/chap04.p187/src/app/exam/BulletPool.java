package app.exam;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

public class BulletPool {
	private GameView gameView;
	public List<Bullet> bullets;
	
	public BulletPool(GameView gameView) {
		this.gameView = gameView;
		bullets = new ArrayList<Bullet>();
	}
	
	public void draw(Canvas canvas) {
		for(int i=0; i<bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			bullet.draw(canvas);
		}
	}
}
