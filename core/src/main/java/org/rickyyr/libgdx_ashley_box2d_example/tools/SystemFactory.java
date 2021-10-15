package org.rickyyr.libgdx_ashley_box2d_example.tools;

import com.badlogic.ashley.core.Engine;
import org.rickyyr.libgdx_ashley_box2d_example.TopdownGame;
import org.rickyyr.libgdx_ashley_box2d_example.systems.InputReceiverSystem;
import org.rickyyr.libgdx_ashley_box2d_example.systems.RenderSystem;

public class SystemFactory {

  public static void createSystems(Engine engine, TopdownGame topdownGame) {

      RenderSystem renderSystem = new RenderSystem();
      engine.addSystem(renderSystem);

      // TODO: Implement movement sys for gravity?
      //MovementSystem movementSystem = new MovementSystem();
     // engine.addSystem(movementSystem);
      // IMPORTANT: InputReceiverSystem has to be added AFTER MovementSystem or will not work without error.
      // Engine will process systems and entities in order.
      InputReceiverSystem inputReceiverSystem = new InputReceiverSystem(topdownGame);
      engine.addSystem(inputReceiverSystem);

  }
}
