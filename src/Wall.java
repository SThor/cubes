import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Wall {
	public static float WIDTH = 100f;
	public static float OFFSET = WIDTH / 2;
	private final PVector origin;
	private final PApplet sketch;
	private Orientation orientation;
	private Color color;

	public Wall(PApplet sketch, PVector origin, Orientation orientation) {
		this.origin = origin;
		this.sketch = sketch;
		this.orientation = orientation;
		this.color = new Color(sketch.random(360), 75, 75);
	}

	public void render() {
		sketch.fill(color.getH(), color.getS(), color.getV());
		sketch.stroke(color.getH(), color.getS(), color.getV());
		switch (orientation) {
			case FACE:
				sketch.rectMode(PConstants.CORNERS);
				sketch.rect(origin.x, origin.y, origin.x + WIDTH, origin.y - WIDTH);
				break;
			case BOTTOM:
				sketch.beginShape();
				sketch.vertex(origin.x, origin.y);
				sketch.vertex(origin.x + WIDTH, origin.y);
				sketch.vertex(origin.x + WIDTH - OFFSET, origin.y + OFFSET);
				sketch.vertex(origin.x - OFFSET, origin.y + OFFSET);
				sketch.endShape();
				break;
			case SIDE:
				sketch.beginShape();
				sketch.vertex(origin.x, origin.y);
				sketch.vertex(origin.x, origin.y - WIDTH);
				sketch.vertex(origin.x - OFFSET, origin.y - WIDTH + OFFSET);
				sketch.vertex(origin.x - OFFSET, origin.y + OFFSET);
				sketch.endShape();
				break;
		}
	}

	public enum Orientation {
		FACE,
		BOTTOM,
		SIDE
	}
}
