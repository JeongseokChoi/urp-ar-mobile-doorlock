package app.exam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
	private Bitmap bitmap;
	
	public DrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.compass);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		int cx = getWidth()/2;
		int cy = getHeight()/2;
		
		int x = cx - bitmap.getWidth()/2;
		int y = cy - bitmap.getHeight()/2;
		
		canvas.drawBitmap(bitmap, x, y, null);
		
		/*
		canvas.rotate(-90, cx, cy);
		canvas.drawBitmap(bitmap, x, y, null);
		*/
		
		/*
		Paint paint = new Paint();
		paint.setColor(Color.YELLOW);		
		canvas.drawLine(cx-100, cy, cx+100, cy, paint);
		*/
		
		/*
		canvas.translate(0, -100);
		Paint paint = new Paint();
		paint.setColor(Color.YELLOW);		
		canvas.drawLine(cx-100, cy, cx+100, cy, paint);
		*/
	}
}
