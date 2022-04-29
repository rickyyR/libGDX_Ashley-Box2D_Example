# libGDX-Ashley-Box2D-EXAMPLE
An example (mostly for myself) on how to structure a [libGDX](https://github.com/libgdx/libgdx) project with [Ashley](https://github.com/libgdx/ashley) and [Box2D](https://box2d.org/).
The initial problem was that Box2D has it's own world and entity system. 

My solution is to use helper methods which will create an object inside the Box2D world and an entity in Ashleys engine as reference to that object simultaneously.

### Controls:
Hold A or D to charge the ball, release to shoot. R to reset position. Hold P to spawn balls at pointer. ESC to enter the menu and reset the level.

### [Components](https://github.com/rickyyR/libGDX-Ashley-Box2D-EXAMPLE/tree/master/core/src/main/java/org/rickyyr/libgdx_ashley_box2d_example/components)
Data bags without any logic, used by systems.

### [Systems](https://github.com/rickyyR/libGDX-Ashley-Box2D-EXAMPLE/tree/master/core/src/main/java/org/rickyyr/libgdx_ashley_box2d_example/systems)
Systems are the logic of the game world (rendering, physics, combat, handling user input e.t.c).

### [Tools](https://github.com/rickyyR/libGDX-Ashley-Box2D-EXAMPLE/tree/master/core/src/main/java/org/rickyyr/libgdx_ashley_box2d_example/systems)
The classes inside the Tools folder are convenience classes like a class for creating all the entities and one for creating the systems. 
There is also GameManager for passing reusable objects like Ashley-Engine and Box2d-World or the Camera around.
