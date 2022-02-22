package org.rickyyr.libgdx_ashley_box2d_example.tools;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.*;
import org.rickyyr.libgdx_ashley_box2d_example.TopdownGame;
import org.rickyyr.libgdx_ashley_box2d_example.components.IsPlayerComponent;

//-----------------------------------------------------------------------------------
// Class for setting up the Game and convenient access to World, Engine and Viewport
//-----------------------------------------------------------------------------------

public abstract class GameManager {

  public static World world1;
  public static OrthographicCamera camera = new OrthographicCamera();
  public static ScreenViewport viewport = new ScreenViewport(camera);
  public static Engine engine = new Engine();

  public static void setupGame(TopdownGame topdownGame) {
    world1  = new World(new Vector2(0,-9f), true);
    EntityFactory.createAllEntities(engine, world1);
    SystemFactory.createAllSystems(engine, topdownGame);
  }

  public static Entity getPlayerEntity() {
    for(Entity e:GameManager.engine.getEntities()) {
      for(Component c:e.getComponents()) {
        if(c instanceof IsPlayerComponent){
          return e;
        }
      }
    }
    return null;
  }

  public static void dispose() {
    world1.dispose();
    engine.removeAllEntities();
  }
}
