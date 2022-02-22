package org.rickyyr.libgdx_ashley_box2d_example;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import org.rickyyr.libgdx_ashley_box2d_example.tools.GameManager;

//------------------------------
// The actual playing screen
//------------------------------

public class GameScreen implements Screen {

  private TopdownGame topdownGame;

  public GameScreen(TopdownGame topdownGame) {
    this.init(topdownGame);
  }

  private void init(TopdownGame topdownGame) {
    this.topdownGame = topdownGame;
    topdownGame.setScreen(this);
    GameManager.setupGame(topdownGame);
    GameManager.camera.zoom = 0.5f;
    GameManager.camera.position.set(new Vector2(0, 8f), 0);
    GameManager.viewport.setUnitsPerPixel(1 / 32f); // 1 cm, km, or m (can decide for yourself) = 32 pix
  }

  @Override
  public void render(float delta) {

    GameManager.viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    // Update the engine
    GameManager.engine.update(delta);
    // Step the world. One could also step the world inside a system.
    GameManager.world1.step(delta, 6, 2);

    if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
      topdownGame.setScreen(new MenuScreen(topdownGame));
      dispose();
    }
  }

  @Override
  public void resize(int width, int height) {

    GameManager.viewport.update(width, height);
  }

  @Override
  public void pause() {}

  @Override
  public void show() {}

  @Override
  public void resume() {}

  @Override
  public void hide() {}

  @Override
  public void dispose() {
    GameManager.dispose();
  }

}
