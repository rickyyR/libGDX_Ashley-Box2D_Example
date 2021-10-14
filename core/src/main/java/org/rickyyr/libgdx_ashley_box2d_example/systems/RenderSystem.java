package org.rickyyr.libgdx_ashley_box2d_example.systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import org.rickyyr.libgdx_ashley_box2d_example.components.TextureComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;
import org.rickyyr.libgdx_ashley_box2d_example.tools.GameManager;

import java.util.ArrayList;

//-------------------------
// System for rendering.
//-------------------------

public class RenderSystem extends IteratingSystem {

  private final boolean debug = false; // Set this to true to show Box2DDebugRenderer rendering.
  private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
  private SpriteBatch batch;
  private ArrayList<Entity> renderQueue = new ArrayList<>();
  private ComponentMapper<TransformComponent> transformMapper = ComponentMapper.getFor(TransformComponent.class);
  private ComponentMapper<TextureComponent> textureMapper = ComponentMapper.getFor(TextureComponent.class);

  public RenderSystem() {
    super(Family.all(TransformComponent.class, TextureComponent.class).get());

    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();

    this.batch = new SpriteBatch();
  }

  public void dispose() {
    this.batch.dispose();
  }

  @Override
  public void processEntity(Entity entity, float deltaTime) {renderQueue.add(entity);}

  @Override
  public void update(float deltaTime) {

    super.update(deltaTime);

    GameManager.camera.update();
    this.batch.setProjectionMatrix(GameManager.camera.combined);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    Gdx.gl.glClearColor(0, 0, 0, 1);

    this.batch.begin();

    for (Entity entity : renderQueue) {

      TextureComponent textureComponent = this.textureMapper.get(entity);
      TransformComponent transformComponent = this.transformMapper.get(entity);
      Body body  = this.transformMapper.get(entity).body;
      this.batch.draw(textureComponent.texture, body.getPosition().x, body.getPosition().y);

    }

    this.batch.end();

    if(this.debug) {
      this.debugRenderer.render(GameManager.world1, GameManager.camera.combined);
    }
    this.renderQueue.clear();
  }

}