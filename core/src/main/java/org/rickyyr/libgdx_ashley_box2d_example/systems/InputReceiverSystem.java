package org.rickyyr.libgdx_ashley_box2d_example.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import org.rickyyr.libgdx_ashley_box2d_example.TopdownGame;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;
import org.rickyyr.libgdx_ashley_box2d_example.tools.EntityFactory;
import org.rickyyr.libgdx_ashley_box2d_example.tools.GameManager;

//------------------------------------------------------------------------------------------------------------------
// System for handling the users input.
// Note: This way of handling input is ok for this example but one should use a remapable setup for a game release.
//------------------------------------------------------------------------------------------------------------------

public class InputReceiverSystem extends EntitySystem implements InputProcessor {

  ComponentMapper<TransformComponent> transformMapper = ComponentMapper.getFor(TransformComponent.class);
  private TopdownGame topdownGame;
  private Body playerBody;
  private float forceCounter = 0;

  public InputReceiverSystem(TopdownGame topdownGame) {
    init(topdownGame);
  }

  private void init(TopdownGame topdownGame) {
    this.topdownGame = topdownGame;
    playerBody = transformMapper.get(GameManager.getPlayerEntity()).body;
    Gdx.input.setInputProcessor(this);
  }

  @Override
  public void update(float deltaTime) {

    if(Gdx.input.isKeyPressed(Input.Keys.W)) {
      playerBody.applyLinearImpulse(0,0.3f, playerBody.getWorldCenter().x, playerBody.getWorldCenter().y, true);
    }
    if(Gdx.input.isKeyPressed(Input.Keys.A)) {
      forceCounter += 6 *  deltaTime;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.S)) {

    }
    if(Gdx.input.isKeyPressed(Input.Keys.D)) {
      forceCounter += 6 *  deltaTime;
    }

    if(Gdx.input.isKeyPressed(Input.Keys.P)) {

      Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(),  0);
      GameManager.camera.unproject(touchPos);
      EntityFactory.spawnSimpleBall(GameManager.world1, new Vector2(touchPos.x, touchPos.y));

    }
  }

  @Override
  public boolean keyUp(int keycode) {

    if(keycode == Input.Keys.W) {
      playerBody.setLinearVelocity(new Vector2(playerBody.getLinearVelocity().x,0));
    }
    if(keycode == Input.Keys.A) {
      playerBody.applyLinearImpulse(0 - forceCounter,0.5f,playerBody.getWorldCenter().x,
        playerBody.getWorldCenter().y, true);
      forceCounter = 0;
    }
    if(keycode == Input.Keys.S) {

    }
    if(keycode == Input.Keys.D) {
      playerBody.applyLinearImpulse(0 + forceCounter,5,playerBody.getWorldCenter().x,
        playerBody.getWorldCenter().y, true);
      forceCounter = 0;
    }
    if(keycode == Input.Keys.R) {
      playerBody.setTransform(0,2,0);
      playerBody.setLinearVelocity(0,0);
    }

    return false;
  }

  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    return false;
  }


  @Override
  public boolean keyDown(int keycode) {
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
