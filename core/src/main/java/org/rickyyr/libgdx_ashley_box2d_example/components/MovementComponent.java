package org.rickyyr.libgdx_ashley_box2d_example.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class MovementComponent implements Component {
  public Vector2 force = new Vector2();
}
