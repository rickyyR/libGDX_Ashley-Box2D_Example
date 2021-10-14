package org.rickyyr.libgdx_ashley_box2d_example;

import com.badlogic.gdx.Game;
import org.rickyyr.libgdx_ashley_box2d_example.tools.EntityFactory;
import org.rickyyr.libgdx_ashley_box2d_example.tools.GameManager;
import org.rickyyr.libgdx_ashley_box2d_example.tools.SystemFactory;

public class TopdownGame extends Game {

  @Override
  public void create() {
    // Set the first screen after start to be MenuScreen
    this.setScreen(new MenuScreen(this));
    // IMPORTANT this will create box2d world and ashley engine
    SystemFactory.createSystems(GameManager.engine, this);
    EntityFactory.createEntities(GameManager.engine);
  }

  @Override
  public void render() {super.render();} // IMPORTANT. The call to the game to actually render stuff.

  @Override
  public void dispose() {}

}