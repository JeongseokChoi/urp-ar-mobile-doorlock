package app.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Rect;

public class MonsterPool {
	private GameView gameView;
	public List<Monster> monsters;
	private Random random;
	
	public MonsterPool(GameView gameView) {
		this.gameView = gameView;
		monsters = new ArrayList<Monster>();
		random = new Random();
		
		for(int i=0; i<20; i++) {
			while(true) {
				int vTileIndex = random.nextInt(gameView.background.mapData.length);
				int hTileIndex = random.nextInt(gameView.background.mapData[0].length);
				
				if((vTileIndex == 0 || vTileIndex == 1) && hTileIndex == 0) { continue; }
				
				int tileNo = gameView.background.mapData[vTileIndex][hTileIndex];
				if(tileNo==2 || tileNo==3) {
					Rect rect = new Rect(hTileIndex*32, vTileIndex*32, hTileIndex*32+32, vTileIndex*32+32);
					monsters.add(new Monster(gameView, rect));
					break;
				}
			}
		}
	}
	
	public void draw(Canvas canvas) {
		for(int i=0; i<monsters.size(); i++) {
			Monster monster = monsters.get(i);
			monster.draw(canvas);
		}
	}
}







