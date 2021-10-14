package org.rickyyr.libgdx_ashley_box2d_example.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import org.rickyyr.libgdx_ashley_box2d_example.MenuScreen;
import org.rickyyr.libgdx_ashley_box2d_example.TopdownGame;
import org.rickyyr.libgdx_ashley_box2d_example.components.IsPlayerComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.MovementComponent;

//------------------------------------------------------------------------------------------------------------------
// System for handling the users input.
// Note: This way of handling input is ok for this example but one should use a remapable setup for a game release.
//------------------------------------------------------------------------------------------------------------------

public class InputReceiverSystem extends IteratingSystem implements InputProcessor {

  private ComponentMapper<MovementComponent> movementMapper = ComponentMapper.getFor(MovementComponent.class);
  private Vector2 playerForce;
  private TopdownGame topdownGame;

  public InputReceiverSystem(TopdownGame topdownGame) {
    super(Family.all(IsPlayerComponent.class).get());
    this.topdownGame = topdownGame;
    Gdx.input.setInputProcessor(this);
  }

  @Override
  protected void processEntity(Entity entity, float deltaTime) {

    playerForce = this.movementMapper.get(entity).force;

    if(Gdx.input.isKeyPressed(Input.Keys.W)) {
      playerForce.y += 2;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.A)) {
      playerForce.x += 2;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.S)) {
      playerForce.y -= 2;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.D)) {
      playerForce.x -= 2;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
      topdownGame.setScreen(new MenuScreen(topdownGame));
    }

  }

  @Override
  public boolean keyDown(int keycode) {
    return false;
  }

  @Override
  public boolean keyUp(int keycode) {

    if(keycode == Input.Keys.W) {
      playerForce.y = 0;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.A)) {
      playerForce.x = 0;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.S)) {
      playerForce.y = 0;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.D)) {
      playerForce.x = 0;
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
