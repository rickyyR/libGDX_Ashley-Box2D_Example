# libGDX-Ashley-Box2D-EXAMPLE
An example (mostly for myself) on how to structure a libGDX project with Ashley and Box2D.

# [Components](https://github.com/rickyyR/libGDX-Ashley-Box2D-EXAMPLE/tree/master/core/src/main/java/org/rickyyr/libgdx_ashley_box2d_example/components)
Data bags without any logic, used by systems.

# [Systems](https://github.com/rickyyR/libGDX-Ashley-Box2D-EXAMPLE/tree/master/core/src/main/java/org/rickyyr/libgdx_ashley_box2d_example/systems)
Systems are the logic of the game world (rendering, physics, combat, handling user input e.t.c).

# [Tools](https://github.com/rickyyR/libGDX-Ashley-Box2D-EXAMPLE/tree/master/core/src/main/java/org/rickyyr/libgdx_ashley_box2d_example/systems)
The classes inside the Tools folder are convenience classes like a class for creating all the entities and one for creating the systems. 
There is also GameManager for passing reusable objects like Ashley-Engine and Box2d-World or the Camera around.
