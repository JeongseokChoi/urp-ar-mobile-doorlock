package app.exam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Background {
	private GameView gameView;
	private Bitmap[] bitmaps;
	public Rect rect;
	public byte[][] mapData;
	
	public Background(GameView gameView) {
		this.gameView = gameView;
		bitmaps = new Bitmap[] {
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.map_01_01),
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.map_01_02),
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.map_01_03),
			BitmapFactory.decodeResource(gameView.getResources(), R.drawable.map_01_04)
		};
		rect = new Rect(0, 0, 1024, 800);
		mapData = new byte[][] {
				{2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{2,2,1,1,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
				{2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{2,2,2,2,2,1,1,1,2,2,2,2,2,1,1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,2},
				{2,2,2,2,2,0,0,0,2,2,2,2,2,0,0,0,2,2,2,2,2,2,0,0,0,3,2,2,2,2,2,2},
				{2,2,2,2,2,0,0,0,3,2,2,2,2,0,0,0,3,2,2,2,2,2,0,0,0,3,2,2,2,2,2,2},
				{2,2,2,2,2,0,0,0,3,2,2,2,2,0,0,0,3,2,2,2,2,2,0,0,0,3,2,2,2,2,2,2},
				{0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0},			
				{1,1,0,0,0,1,1,1,3,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,3,1,1,0,0},			
				{1,1,0,0,0,1,1,1,3,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,3,1,1,0,0},			
				{2,2,0,0,0,3,2,2,2,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,3,2,2,0,0},			
				{0,2,0,0,0,3,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0},			
				{0,3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0},			
				{1,3,1,1,1,3,1,1,0,0,0,0,0,0,1,1,3,1,1,1,1,1,1,1,0,0,0,0,0,3,0,0},			
				{1,3,1,1,1,3,1,1,0,0,0,0,0,0,1,1,3,1,1,1,1,1,1,1,0,1,1,1,1,3,1,1},			
				{2,2,2,2,2,2,2,2,1,1,1,1,1,1,3,2,2,2,2,2,2,2,2,2,0,1,1,1,1,3,1,1},			
				{2,2,2,2,2,2,2,2,1,1,1,1,1,1,3,2,2,2,2,2,0,0,0,2,0,3,2,2,2,2,2,2},			
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,0,3,1,3,2,2,2,2,2,2},			
				{2,2,2,2,2,2,2,2,0,0,0,0,0,0,2,2,2,2,2,2,0,0,0,3,1,3,2,2,2,2,2,2},			
				{2,2,2,2,2,2,2,2,0,0,1,1,1,1,3,2,2,2,2,2,0,0,0,3,2,2,2,2,2,2,2,2},			
				{2,2,2,2,2,2,2,2,0,0,1,1,1,1,3,2,2,2,2,2,0,0,0,0,0,2,2,2,2,2,2,2},			
				{2,2,2,2,2,2,2,2,0,0,3,2,2,2,2,2,2,2,2,2,0,0,0,0,0,3,2,2,2,2,2,2},			
				{2,2,2,2,2,2,2,2,0,0,3,0,0,0,2,2,2,2,2,2,0,0,0,0,0,3,2,2,2,2,2,2},			
				{0,0,0,2,0,0,0,0,0,0,3,0,0,0,3,2,2,2,2,2,0,0,0,0,0,3,0,0,0,0,0,0}			
			};
	}
	
	public void draw(Canvas canvas) {
		for(int v=0; v<mapData.length; v++) {
			for(int h=0; h<mapData[0].length; h++) {
				int left = rect.left + h*32;
				int top = rect.top + v*32;
				canvas.drawBitmap(bitmaps[mapData[v][h]], left, top, null);
			}
		}
	}
	
	public int getTileIndex(int distance) {
		return distance/32;
	}
	
	public int getTileNo(int vTileIndex, int hTileIndex) {
		return mapData[vTileIndex][hTileIndex];
	}
	
	public void move(int direction) {
		if(direction == Arrow.RIGHT) {
			if(rect.left<0) {
				rect.left += 8;
				rect.right += 8;
			}
		} else if(direction == Arrow.LEFT) {
			if(rect.left > -(rect.width()-gameView.getWidth())) {
				rect.left -= 8;
				rect.right -= 8;
			}
		} else if(direction == Arrow.DOWN) {
			if(rect.top < 0) {
				rect.top += 8;
				rect.bottom += 8;
			}
		} else if(direction == Arrow.UP) {
			if(rect.top > -(rect.height() - gameView.getHeight())) {
				rect.top -= 8;
				rect.bottom -= 8;
			}
		}
	}
}










