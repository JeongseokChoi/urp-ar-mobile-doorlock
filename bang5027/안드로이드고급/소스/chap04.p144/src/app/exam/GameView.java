package app.exam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {
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
		background = new Background(this);
		actor = new Actor(this);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		background.draw(canvas);
		actor.draw(canvas);
	}
}











