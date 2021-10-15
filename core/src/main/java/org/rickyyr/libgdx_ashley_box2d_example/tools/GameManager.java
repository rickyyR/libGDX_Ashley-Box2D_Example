package org.rickyyr.libgdx_ashley_box2d_example.tools;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.*;
import org.rickyyr.libgdx_ashley_box2d_example.systems.RenderSystem;

//------------------------------------------------------------------------------
// Class for convenient access to World, Engine, Camera and Viewport
//------------------------------------------------------------------------------

public class GameManager {

  public static World world1 = new World(new Vector2(0,-1f), true);
  public static OrthographicCamera camera = new OrthographicCamera();
  public static ScreenViewport viewport = new ScreenViewport(camera);
  public static Engine engine = new Engine();

  public static void dispose() {
    world1.dispose();
  }
}
