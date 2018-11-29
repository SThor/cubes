import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends PApplet {

	private List<Wall> walls;

	public static void main(String[] args) {
		String[] processingArgs = {"Cards"};
		Main sketch = new Main();
		PApplet.runSketch(processingArgs, sketch);
	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB, 360, 100, 100);
		background(40, 1.27f, 92.55f);
		walls = new ArrayList<>();
		walls.addAll(new Corner(this, new PVector(width / 2f - Wall.WIDTH, height / 2f + Wall.WIDTH)).getWalls());
		walls.addAll(new Corner(this, new PVector(width / 2f, height / 2f + Wall.WIDTH)).getWalls());
		walls.addAll(new Corner(this, new PVector(width / 2f + Wall.WIDTH, height / 2f + Wall.WIDTH)).getWalls());

		walls.addAll(new Corner(this, new PVector(width / 2f - Wall.WIDTH, height / 2f)).getWalls());
		walls.addAll(new Corner(this, new PVector(width / 2f, height / 2f)).getWalls());
		walls.addAll(new Corner(this, new PVector(width / 2f + Wall.WIDTH, height / 2f)).getWalls());

		walls.addAll(new Corner(this, new PVector(width / 2f - Wall.WIDTH, height / 2f - Wall.WIDTH)).getWalls());
		walls.addAll(new Corner(this, new PVector(width / 2f, height / 2f - Wall.WIDTH)).getWalls());
		walls.addAll(new Corner(this, new PVector(width / 2f + Wall.WIDTH, height / 2f - Wall.WIDTH)).getWalls());

		walls.addAll(Arrays.asList(
				new Wall(this, new PVector(width / 2f - Wall.WIDTH - Wall.OFFSET, height / 2f + Wall.OFFSET + Wall.WIDTH), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f - Wall.OFFSET, height / 2f + Wall.OFFSET + Wall.WIDTH), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f + Wall.WIDTH - Wall.OFFSET, height / 2f + Wall.OFFSET + Wall.WIDTH), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f + 2 * Wall.WIDTH, height / 2f + Wall.WIDTH), Wall.Orientation.SIDE)
		));
		walls.addAll(Arrays.asList(
				new Wall(this, new PVector(width / 2f - Wall.WIDTH - Wall.OFFSET, height / 2f + Wall.OFFSET), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f - Wall.OFFSET, height / 2f + Wall.OFFSET), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f + Wall.WIDTH - Wall.OFFSET, height / 2f + Wall.OFFSET), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f + 2 * Wall.WIDTH, height / 2f), Wall.Orientation.SIDE)
		));
		walls.addAll(Arrays.asList(
				new Wall(this, new PVector(width / 2f - Wall.WIDTH - Wall.OFFSET, height / 2f + Wall.OFFSET - Wall.WIDTH), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f - Wall.OFFSET, height / 2f + Wall.OFFSET - Wall.WIDTH), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f + Wall.WIDTH - Wall.OFFSET, height / 2f + Wall.OFFSET - Wall.WIDTH), Wall.Orientation.FACE),
				new Wall(this, new PVector(width / 2f + 2 * Wall.WIDTH, height / 2f - Wall.WIDTH), Wall.Orientation.SIDE)
		));
		walls.addAll(Arrays.asList(
				new Wall(this, new PVector(width / 2f - Wall.WIDTH, height / 2f - Wall.WIDTH * 2), Wall.Orientation.BOTTOM),
				new Wall(this, new PVector(width / 2f, height / 2f - Wall.WIDTH * 2), Wall.Orientation.BOTTOM),
				new Wall(this, new PVector(width / 2f + Wall.WIDTH, height / 2f - Wall.WIDTH * 2), Wall.Orientation.BOTTOM)
		));
	}

	public void draw() {
		for (Wall wall : walls) {
			wall.render();
		}
		if (walls.size() > 25) {
			int random = (int) random(walls.size() - 1);
			walls.remove(random);
		} else {
			noLoop();
			save("image.png");
		}
	}

	public void mousePressed() {
		background(64);
	}
}
