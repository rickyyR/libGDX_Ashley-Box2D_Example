package org.rickyyr.libgdx_ashley_box2d_example.systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.Body;
import org.rickyyr.libgdx_ashley_box2d_example.components.MovementComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TextureComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;

//----------------------------------
// System applying force to bodies.
//----------------------------------

public class MovementSystem extends IteratingSystem {

  private ComponentMapper<MovementComponent> movementMapper = ComponentMapper.getFor(MovementComponent.class);
  private ComponentMapper<TransformComponent> transformMapper = ComponentMapper.getFor(TransformComponent.class);
  private Body entityBody;

  public MovementSystem() {
    super(Family.all(TransformComponent.class, TextureComponent.class).get());
  }

  @Override
  protected void processEntity(Entity entity, float deltaTime) {

    entityBody = transformMapper.get(entity).body;
    MovementComponent movementComponent = this.movementMapper.get(entity);

    entityBody.setLinearVelocity(movementComponent.force.x / deltaTime , movementComponent.force.y / deltaTime);

    }
}



