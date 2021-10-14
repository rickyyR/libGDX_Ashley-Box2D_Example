package org.rickyyr.libgdx_ashley_box2d_example;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import org.rickyyr.libgdx_ashley_box2d_example.tools.GameManager;

public class GameScreen implements Screen {

  @Override
  public void render(float delta) {
    // Update the engine
    GameManager.engine.update(Gdx.graphics.getDeltaTime());
    // Step the world. One could also step the world inside a system.
    GameManager.world1.step(1/60f, 6, 2);
  }

  @Override
  public void resize(int width, int height) {
    GameManager.viewport.update(width,height);
  }

  @Override
  public void dispose() {
    // Dispose the render systems contents (batch e.t.c)
    GameManager.dispose();
  }

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void hide() {}

  @Override
  public void show() {}

}
