package app.exam;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder holder;
	private boolean gameover;
	private DrawThread drawThread;
	
	private Background background;
	private Actor actor;
	
	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public GameView(Context context) {
		super(context);
		init();
	}

	private void init() {		
		holder = getHolder();
		holder.addCallback(this);
		
		background = new Background(this);
		actor = new Actor(this);
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		drawThread = new DrawThread();
		drawThread.start();
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {		
	}
	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {		
	}
	
	private class DrawThread extends Thread {
		@Override
		public void run() {
			boolean stop = false;
			Canvas canvas = null;
			while(!stop) {
				canvas = holder.lockCanvas();
				
				background.draw(canvas);
				actor.draw(canvas);
				
				if(gameover) {
					stop = true;
				}
				
				holder.unlockCanvasAndPost(canvas);
			}
		}
	};
	
	public void gameOver() {
		try {
			gameover = true;
			
			drawThread.join();
		} catch(Exception e) {	}
	}
}











