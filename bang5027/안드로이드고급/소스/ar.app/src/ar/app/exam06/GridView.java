package ar.app.exam06;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GridView extends View {
	//�ʵ�
	private Paint gridPaint, textPaint;
	private int hGridNo, vGridNo;
	private int centerX, centerY;
	//������
	public GridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		gridPaint = new Paint();
		gridPaint.setColor(Color.argb(100, 255, 255, 255));
		gridPaint.setAntiAlias(true);
		textPaint = new Paint();
		textPaint.setColor(Color.argb(255, 255, 255, 255));
		textPaint.setAntiAlias(true);
		textPaint.setTextSize(15);
		textPaint.setFakeBoldText(true);
	}
	//�׸���, ��, �ؽ�Ʈ �����
	@Override
	protected void onDraw(Canvas canvas) {
		if(hGridNo == 0) {
			hGridNo = getWidth()/10;
			vGridNo = getWidth()/10;
			centerX = getWidth()/2;
			centerY = getHeight()/2;
		}
		for(int i=0; i<hGridNo; i++) {
			canvas.drawLine(i*10, 0, i*10, getHeight(), gridPaint);
		}
		for(int i=0; i<vGridNo; i++) {
			canvas.drawLine(0, i*10, getWidth(), i*10, gridPaint);
		}		
		canvas.drawCircle(centerX, centerY, 100, gridPaint);
		canvas.drawCircle(centerX, centerY, 200, gridPaint);
		canvas.drawText("100m", centerX+102, centerY, textPaint);
		canvas.drawText("200m", centerX+202, centerY, textPaint);
	}
}

