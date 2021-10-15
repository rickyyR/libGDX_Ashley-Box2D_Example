package org.rickyyr.libgdx_ashley_box2d_example.systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import org.rickyyr.libgdx_ashley_box2d_example.components.TextureComponent;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;
import org.rickyyr.libgdx_ashley_box2d_example.tools.GameManager;

import java.util.ArrayList;

//-------------------------
// System for rendering.
//-------------------------

public class RenderSystem extends IteratingSystem {

  private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
  private ArrayList<Entity> renderQueue = new ArrayList<>();

  private ComponentMapper<TransformComponent> transformMapper = ComponentMapper.getFor(TransformComponent.class);


  public RenderSystem() {super(Family.one(TransformComponent.class, TextureComponent.class).get());}


  @Override
  public void processEntity(Entity entity, float deltaTime) {renderQueue.add(entity);}

  @Override
  public void update(float deltaTime) {

    super.update(deltaTime);

    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    Gdx.gl.glClearColor(0, 0, 0, 1);

    this.debugRenderer.render(GameManager.world1, GameManager.camera.combined);

  }

}