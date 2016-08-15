package app.exam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {
	
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
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.map_01);
		Bitmap actor = BitmapFactory.decodeResource(getResources(), R.drawable.actor_01_09);
		
		canvas.drawBitmap(background, 0, 0, null);
		canvas.drawBitmap(actor, 100, 100, null);
	}
}











