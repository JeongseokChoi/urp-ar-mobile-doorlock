package app.exam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GridView extends View {
	private Paint gridPaint, textPaint;
	private int hGridNo, vGridNo;
	private int centerX, centerY;
	
	public GridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		gridPaint = new Paint();
		gridPaint.setColor(Color.argb(100, 255, 255, 255));
		gridPaint.setAntiAlias(true);
		
		textPaint = new Paint();
		textPaint.setColor(Color.WHITE);
		textPaint.setAntiAlias(true);
		textPaint.setTextSize(15);
		textPaint.setFakeBoldText(true);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		if(hGridNo == 0) {
			hGridNo = getWidth()/10;
			vGridNo = getHeight()/10;
			centerX = getWidth()/2;
			centerY = getHeight()/2;
		}
		
		for(int i=0; i<hGridNo; i++) {
			canvas.drawLine(i*getPx(10), 0, i*getPx(10), getHeight(), gridPaint);
		}
		
		for(int i=0; i<vGridNo; i++) {
			canvas.drawLine(0, i*getPx(10), getWidth(), i*getPx(10), gridPaint);
		}
		
		canvas.drawCircle(centerX, centerY, getPx(100), gridPaint);
		canvas.drawCircle(centerX, centerY, getPx(200), gridPaint);
		canvas.drawText("100m", centerX+getPx(102), centerY, textPaint);
		canvas.drawText("200m", centerX+getPx(202), centerY, textPaint);
	}
	
	
	private int getPx(int dp) {
		float dencity = getResources().getDisplayMetrics().density;
		int px = (int) (dp * dencity);
		return px;
	}
	
}





