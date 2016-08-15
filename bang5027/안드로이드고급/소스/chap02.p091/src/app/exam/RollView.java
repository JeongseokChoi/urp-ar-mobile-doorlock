package app.exam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class RollView extends View {
	private Bitmap bitmap;
	public int roll;
	
	public RollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.horizontality);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.rotate(roll, this.getWidth()/2, this.getHeight()/2);
		canvas.drawBitmap(bitmap, 
				this.getWidth()/2-bitmap.getWidth()/2, 
				this.getHeight()/2-bitmap.getHeight()/2, 
				null);
	}
}
