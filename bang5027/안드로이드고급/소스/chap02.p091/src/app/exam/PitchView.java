package app.exam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PitchView extends View {
	private Paint paint1, paint2, paint3;
	public int pitch;

	public PitchView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint1 = new Paint();
		paint1.setAntiAlias(true);
		paint1.setColor(Color.YELLOW);
		paint1.setStrokeWidth(2);
		
		paint2 = new Paint();
		paint2.setAntiAlias(true);
		paint2.setColor(Color.YELLOW);
		paint2.setTextSize(20);
		
		paint3 = new Paint();
		paint3.setAntiAlias(true);
		paint3.setColor(Color.YELLOW);
		paint3.setStrokeWidth(2);
		paint3.setPathEffect(new DashPathEffect(new float[]{5, 5}, 0));
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.translate(0, pitch*5);
		
		int cx = getWidth()/2; //ºä Áß¾ÓÀÇ x ÁÂÇ¥
		int cy = getHeight()/2; //ºä Áß¾ÓÀÇ y ÁÂÇ¥
		
		canvas.drawLine(cx-125, cy, cx-25, cy, paint1);
		canvas.drawLine(cx+25, cy, cx+125, cy, paint1);
		canvas.drawText("0", cx-140, cy, paint2);
		canvas.drawText("0", cx+130, cy, paint2);
		
		for(int i=10; i<=90; i+=10) {
			//0 ~ 90±îÁö ¼±±×¸®±â
			canvas.drawLine(cx-125, cy-(i*5), cx-25, cy-(i*5), paint1);
			canvas.drawLine(cx+25, cy-(i*5), cx+125, cy-(i*5), paint1);
			canvas.drawText(String.valueOf(i), cx-145, cy-(i*5), paint2);
			canvas.drawText(String.valueOf(i), cx+130, cy-(i*5), paint2);
			//-10 ~ -90±îÁö ¼±±×¸®±â
			canvas.drawLine(cx-125, cy+(i*5), cx-25, cy+(i*5), paint3);
			canvas.drawLine(cx+25, cy+(i*5), cx+125, cy+(i*5), paint3);
			canvas.drawText("-" + String.valueOf(i), cx-155, cy+(i*5), paint2);
			canvas.drawText("-" + String.valueOf(i), cx+130, cy+(i*5), paint2);
		}
	}
}
