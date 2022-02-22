package org.rickyyr.libgdx_ashley_box2d_example.tools;

import com.badlogic.ashley.core.ComponentMapper;
import org.rickyyr.libgdx_ashley_box2d_example.components.TransformComponent;

public abstract class Mappers {
  public static final ComponentMapper<TransformComponent> transformMapper = ComponentMapper.getFor(TransformComponent.class);
}
