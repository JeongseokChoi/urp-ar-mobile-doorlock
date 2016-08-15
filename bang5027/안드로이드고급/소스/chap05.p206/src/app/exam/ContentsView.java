package app.exam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class ContentsView extends View {
	private Bitmap[] bitmaps;
	
	public ContentsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(getResources(), R.drawable.burgerking_icon),
			BitmapFactory.decodeResource(getResources(), R.drawable.mcdonald_icon),
			BitmapFactory.decodeResource(getResources(), R.drawable.starbucks_icon)
		};
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(bitmaps[0], 100, 200, null);
		canvas.drawBitmap(bitmaps[1], 200, 100, null);
		canvas.drawBitmap(bitmaps[2], 300, 150, null);
	}
}
