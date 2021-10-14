package org.rickyyr.libgdx_ashley_box2d_example.tools;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import org.rickyyr.libgdx_ashley_box2d_example.components.IsPlayerComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.MovementComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TextureComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;

public class EntityFactory {

  private static BodyDef bdef = new BodyDef();
  private static FixtureDef fdef = new FixtureDef();

  public static void createEntities(Engine engine) {
    engine.addEntity(createPlayer(GameManager.world1, new Vector2(0,0)));
    engine.addEntity(createExampleEntity(GameManager.world1, new Vector2(100,0)));

  }

  public static Entity createPlayer(World world, Vector2 position) {
    Entity entity = new Entity();

    MovementComponent movementComponent = new MovementComponent();
    movementComponent.force.x = 0;
    movementComponent.force.y = 0;
    entity.add(movementComponent);

    TransformComponent transformComponent = new TransformComponent();
    CircleShape shape = new CircleShape();
    shape.setRadius(25);
    fdef.shape = shape;
    bdef.position.set(position);
    bdef.type = BodyDef.BodyType.DynamicBody;
    transformComponent.body = world.createBody(bdef);
    transformComponent.body.createFixture(fdef);
    entity.add(transformComponent);

    TextureComponent textureComponent = new TextureComponent();
    Texture playerTexture = new Texture("playerTexture.png");
    textureComponent.texture = playerTexture;
    entity.add(textureComponent);

    IsPlayerComponent isPlayerComponent = new IsPlayerComponent();
    entity.add(isPlayerComponent);

    return entity;
  }

  public static Entity createExampleEntity(World world, Vector2 position) {
    Entity entity = new Entity();

    MovementComponent movementComponent = new MovementComponent();
    movementComponent.force.x = -1;
    movementComponent.force.y = 0;
    entity.add(movementComponent);

    TransformComponent transformComponent = new TransformComponent();
    CircleShape shape = new CircleShape();
    shape.setRadius(25f);
    fdef.shape = shape;
    bdef.position.set(position);
    bdef.type = BodyDef.BodyType.DynamicBody;
    transformComponent.body = world.createBody(bdef);
    transformComponent.body.createFixture(fdef);
    entity.add(transformComponent);

    TextureComponent textureComponent = new TextureComponent();
    Texture playerTexture = new Texture("npcTexture.png");
    textureComponent.texture = playerTexture;
    entity.add(textureComponent);

    return entity;
  }
}
