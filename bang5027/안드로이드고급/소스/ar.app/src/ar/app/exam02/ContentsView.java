package ar.app.exam02;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import ar.app.R;

public class ContentsView extends View {	
	//ÇÊµå
	private Bitmap[] bitmap;
	//»ý¼ºÀÚ
	public ContentsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bitmap = new Bitmap[3];
		bitmap[0] = BitmapFactory.decodeResource(getResources(), R.drawable.burgerking_icon);
		bitmap[1] = BitmapFactory.decodeResource(getResources(), R.drawable.mcdonald_icon);
		bitmap[2] = BitmapFactory.decodeResource(getResources(), R.drawable.starbucks_icon);
	}
	//ÄÁÅÙÃ÷ µå·ÎÀ×
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(bitmap[0], 100, 200, null);
		canvas.drawBitmap(bitmap[1], 200, 100, null);
		canvas.drawBitmap(bitmap[2], 300, 150, null);
	}
}

