package org.rickyyr.libgdx_ashley_box2d_example.tools;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import org.rickyyr.libgdx_ashley_box2d_example.components.IsPlayerComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;

//---------------------------------------------------------------------------------------------
// This is a helper class for creating all the entities. It is used by GameManager.setupGame().
//---------------------------------------------------------------------------------------------

public abstract class EntityFactory {

  private static BodyDef bdef = new BodyDef();
  private static FixtureDef fdef = new FixtureDef();

  public static void createAllEntities(Engine engine, World world) {
    engine.addEntity(createPlayer(world, new Vector2(0,2)));
    engine.addEntity(createFloor(world));
    engine.addEntity(createGoal(world));
  }

  public static Entity createPlayer(World world, Vector2 position) {
    Entity entity = new Entity();

    TransformComponent transformComponent = new TransformComponent();
    CircleShape shape = new CircleShape();
    shape.setRadius(0.11f);
    fdef.shape = shape;
    fdef.density = 8.8f;
    fdef.restitution = 0.5f;
    bdef.position.set(position);
    bdef.type = BodyDef.BodyType.DynamicBody;
    transformComponent.body = world.createBody(bdef);
    transformComponent.body.createFixture(fdef);

    entity.add(transformComponent);

    IsPlayerComponent isPlayerComponent = new IsPlayerComponent();
    entity.add(isPlayerComponent);

    return entity;
  }

  public static void spawnSimpleBall(World world, Vector2 position) {

    Entity entity = new Entity();
    TransformComponent transformComponent = new TransformComponent();
    CircleShape shape = new CircleShape();
    shape.setRadius(0.11f);
    fdef.shape = shape;
    fdef.density = 8.8f;
    fdef.restitution = 0.5f;
    bdef.position.set(position);
    bdef.type = BodyDef.BodyType.DynamicBody;
    transformComponent.body = world.createBody(bdef);
    transformComponent.body.createFixture(fdef);
    entity.add(transformComponent);

    GameManager.engine.addEntity(entity);
  }

  public static Entity createFloor(World world) {
    Entity entity = new Entity();

    TransformComponent transformComponent = new TransformComponent();
    PolygonShape rectangle = new PolygonShape();
    rectangle.setAsBox(Gdx.graphics.getWidth() / 2, 0.1f);

    fdef.shape = rectangle;
    bdef.position.set(0,0);
    bdef.type = BodyDef.BodyType.StaticBody;
    transformComponent.body = world.createBody(bdef);
    transformComponent.body.createFixture(fdef);
    entity.add(transformComponent);

    return entity;
  }

  public static Entity createGoal(World world) {
    Entity entity = new Entity();

    TransformComponent transformComponent = new TransformComponent();
    PolygonShape rectangle = new PolygonShape();
    rectangle.setAsBox(0.1f, 1.22f);

    fdef.shape = rectangle;
    bdef.position.set(10, 1.31f);
    bdef.type = BodyDef.BodyType.StaticBody;
    transformComponent.body = world.createBody(bdef);
    transformComponent.body.createFixture(fdef);
    entity.add(transformComponent);

    return entity;
  }
}
