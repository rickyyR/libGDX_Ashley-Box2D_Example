package org.rickyyr.libgdx_ashley_box2d_example.tools;

import com.badlogic.ashley.core.Engine;
import org.rickyyr.libgdx_ashley_box2d_example.TopdownGame;
import org.rickyyr.libgdx_ashley_box2d_example.systems.InputReceiverSystem;
import org.rickyyr.libgdx_ashley_box2d_example.systems.RenderSystem;

//---------------------------------------------------------------------------------------------
// This is a helper class for creating all the systems. It is used by GameManager.setupGame().
//---------------------------------------------------------------------------------------------

public abstract class SystemFactory {

  public static void createAllSystems(Engine engine, TopdownGame topdownGame) {

      RenderSystem renderSystem = new RenderSystem();
      engine.addSystem(renderSystem);

      InputReceiverSystem inputReceiverSystem = new InputReceiverSystem(topdownGame);
      engine.addSystem(inputReceiverSystem);

  }
}
