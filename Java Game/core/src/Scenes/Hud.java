package Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

public class Hud {
	public Stage stage;
	private Viewport viewport;
	
	private Integer worldTimer;
	private float timeCount;
	private Integer score;
	
	Label countdownLabel;
	Label scoreLabel;
	Label timeLabel;
	Label levelLabel;
	Label worldLabel;
	Label tankLabel;
	
	public Hud(SpriteBatch sb){
		worldTimer = 300;
		timeCount = 0;
		score = 0;
		
		viewport = new FitViewport(MyGdxGame.V_WIDTH,MyGdxGame.V_HEIGHT, new OrthographicCamera());
		stage = new Stage(viewport , sb);
		
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		
		countdownLabel = new Label(String.format("%03d" , worldTimer) , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		scoreLabel = new Label(String.format("%06d", score) , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		timeLabel = new Label("TIME" , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		levelLabel = new Label("Chin" , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		worldLabel = new Label("World" , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		tankLabel = new Label("Test" , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		table.add(tankLabel).expandX().padTop(10);
		table.add(worldLabel).expandX().padTop(10);
		table.add(timeLabel).expandX().padTop(10);
		table.row();
		table.add(scoreLabel).expandX();
		table.add(levelLabel).expandX();
		table.add(countdownLabel).expandX();
		
		stage.addActor(table);
	}
}
