import processing.core.PApplet;
import processing.core.PVector;

import java.util.Arrays;
import java.util.List;

public class Corner {

	private PApplet sketch;
	private Wall face, bottom, side;
	private PVector origin;

	public Corner(PApplet sketch, PVector origin) {
		this(sketch, new Wall(sketch, origin, Wall.Orientation.FACE), new Wall(sketch, origin, Wall.Orientation.BOTTOM), new Wall(sketch, origin, Wall.Orientation.SIDE), origin);
	}

	public Corner(PApplet sketch, Wall face, Wall bottom, Wall side, PVector origin) {
		this.sketch = sketch;
		this.face = face;
		this.bottom = bottom;
		this.side = side;
		this.origin = origin;
	}

	public void render() {
		face.render();
		bottom.render();
		side.render();
	}

	public List<Wall> getWalls() {
		return Arrays.asList(face, bottom, side);
	}
}