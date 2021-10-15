package org.rickyyr.libgdx_ashley_box2d_example.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import org.rickyyr.libgdx_ashley_box2d_example.MenuScreen;
import org.rickyyr.libgdx_ashley_box2d_example.TopdownGame;
import org.rickyyr.libgdx_ashley_box2d_example.components.IsPlayerComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;
import org.rickyyr.libgdx_ashley_box2d_example.tools.GameManager;

//------------------------------------------------------------------------------------------------------------------
// System for handling the users input.
// Note: This way of handling input is ok for this example but one should use a remapable setup for a game release.
//------------------------------------------------------------------------------------------------------------------

public class InputReceiverSystem extends IteratingSystem implements InputProcessor {

  ComponentMapper<TransformComponent> transformMapper = ComponentMapper.getFor(TransformComponent.class);
  private TopdownGame topdownGame;
  private Body playerBody;

  public InputReceiverSystem(TopdownGame topdownGame) {
    super(Family.all(IsPlayerComponent.class).get());
    init(topdownGame);
  }

  private void init(TopdownGame topdownGame) {
    this.topdownGame = topdownGame;
    playerBody = transformMapper.get(GameManager.engine.getEntities().get(0)).body;
    Gdx.input.setInputProcessor(this);
  }

  @Override
  protected void processEntity(Entity entity, float deltaTime) {

    if(Gdx.input.isKeyPressed(Input.Keys.W)) {
      playerBody.applyLinearImpulse(0,0.3f, playerBody.getWorldCenter().x, playerBody.getWorldCenter().y, true);
    }
    if(Gdx.input.isKeyPressed(Input.Keys.A)) {

    }
    if(Gdx.input.isKeyPressed(Input.Keys.S)) {

    }
    if(Gdx.input.isKeyPressed(Input.Keys.D)) {

    }
    if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
      topdownGame.setScreen(new MenuScreen(topdownGame));
    }
    if(Gdx.input.isKeyPressed(Input.Keys.P)) {

    }

  }

  @Override
  public boolean keyDown(int keycode) {
    return false;
  }

  @Override
  public boolean keyUp(int keycode) {

    if(keycode == Input.Keys.W) {
      playerBody.setLinearVelocity(new Vector2(0,0));
    }
    if(keycode == Input.Keys.A) {

    }
    if(keycode == Input.Keys.S) {

    }
    if(keycode == Input.Keys.D) {

    }


    return false;
  }

  @Override
  public boolean keyTyped(char character) {
    return false;
  }

  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  @Override
  public boolean touchDragged(int screenX, int screenY, int pointer) {
    return false;
  }

  @Override
  public boolean mouseMoved(int screenX, int screenY) {
    return false;
  }

  @Override
  public boolean scrolled(float amountX, float amountY) {
    return false;
  }
}
