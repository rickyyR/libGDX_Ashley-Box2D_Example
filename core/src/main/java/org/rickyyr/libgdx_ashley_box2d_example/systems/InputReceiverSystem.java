package org.rickyyr.libgdx_ashley_box2d_example.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Body;
import org.rickyyr.libgdx_ashley_box2d_example.MenuScreen;
import org.rickyyr.libgdx_ashley_box2d_example.TopdownGame;
import org.rickyyr.libgdx_ashley_box2d_example.components.IsPlayerComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;

//------------------------------------------------------------------------------------------------------------------
// System for handling the users input.
// Note: This way of handling input is ok for this example but one should use a remapable setup for a game release.
//------------------------------------------------------------------------------------------------------------------

public class InputReceiverSystem extends IteratingSystem {

  private ComponentMapper<TransformComponent> bodyMapper = ComponentMapper.getFor(TransformComponent.class);
  private Body playerBody;
  private TopdownGame topdownGame;

  public InputReceiverSystem(TopdownGame topdownGame) {
    super(Family.all(IsPlayerComponent.class).get());
    this.topdownGame = topdownGame;
  }

  @Override
  protected void processEntity(Entity entity, float deltaTime) {

    playerBody = this.bodyMapper.get(entity).body;

    if(Gdx.input.isKeyPressed(Input.Keys.W)) {
      playerBody.setLinearVelocity(0,20);
    }
    if(Gdx.input.isKeyPressed(Input.Keys.A)) {
      playerBody.setLinearVelocity(-20,0);
    }
    if(Gdx.input.isKeyPressed(Input.Keys.S)) {
      playerBody.setLinearVelocity(0,-20);
    }
    if(Gdx.input.isKeyPressed(Input.Keys.D)) {
      playerBody.setLinearVelocity(20,0);
    }
    if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
      topdownGame.setScreen(new MenuScreen(topdownGame));
    }
  }
}
