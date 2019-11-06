package Screens;

import Scenes.Hud;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

public class PlayScreen implements Screen{
	private MyGdxGame game;
	Texture texture;
	private OrthographicCamera gamecam;
	private Viewport gamePort;
	private Hud hud;
	
	private TmxMapLoader maploader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	public PlayScreen(MyGdxGame asd){
		this.game = asd;
		
		
		gamePort = new FitViewport(MyGdxGame.V_WIDTH,MyGdxGame.V_HEIGHT,gamecam);
		hud = new Hud(game.batch);
		maploader = new TmxMapLoader();
		gamecam = new OrthographicCamera();
		map = maploader.load("untitled.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		gamecam.position.set(gamePort.getWorldWidth() / 2 , gamePort.getWorldHeight() / 2 , 0);
		
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	public void handleInput(float dt){
		if(Gdx.input.isTouched()){
			gamecam.position.x += 100 * dt;
		}
	}
	
	public void update ( float dt){
		handleInput(dt);
		gamecam.update();
		renderer.setView(gamecam);
		
	}

	@Override
	public void render(float delta) {
		update(delta);
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.setView(gamecam);
		renderer.render();
		game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();
//		game.batch.setProjectionMatrix(gamecam.combined);
//		game.batch.begin();
//		game.batch.draw(texture, 0 ,0);
//		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		//gamePort.update(width, height);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		map.dispose();
		renderer.dispose();
	}

}
