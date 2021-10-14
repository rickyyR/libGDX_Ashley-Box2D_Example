package org.rickyyr.libgdx_ashley_box2d_example;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

//----------------------------------------------------------------------------------------------------------
// The MenuScreen is independent of the World and Engine (for now) so it has its own render and input logic
//----------------------------------------------------------------------------------------------------------

public class MenuScreen implements Screen {

  private final TopdownGame game;
  private OrthographicCamera camera;
  private SpriteBatch batch;
  private BitmapFont font;
  private Viewport viewport;
  private int width;
  private int height;

  public MenuScreen(final TopdownGame game) {
    this.game = game;

    this.width = Gdx.graphics.getWidth();
    this.height = Gdx.graphics.getHeight();

    this.camera = new OrthographicCamera();
    this.camera.setToOrtho(false, width ,height);
    this.viewport = new ExtendViewport(width, height, camera);

    this.font = new BitmapFont(); // use libGDX's default Arial font.
    this.batch = new SpriteBatch();
  }

  @Override
  public void render(float delta) {

    ScreenUtils.clear(0, 0, 0.2f, 1);

    this.camera.update();
    this.batch.setProjectionMatrix(camera.combined);

    this.batch.begin();

    this.font.draw(batch, "Tap anywhere to begin!", width / 2f -70 , height / 2f );

    this.batch.end();

    if (Gdx.input.isTouched()) {
      this.game.setScreen(new GameScreen());
      dispose();
    }
  }

  @Override
  public void resize(int width, int height) {
    viewport.update(width, height);
  }

  @Override
  public void dispose() {
    batch.dispose();
    font.dispose();
  }

  @Override
  public void show(){}

  @Override
  public void pause(){}

  @Override
  public void resume(){}

  @Override
  public void hide(){}

}
