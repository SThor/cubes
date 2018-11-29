public class Color {
	private float h;
	private float s;
	private float v;

	public Color(float h, float s, float v) {
		this.h = h;
		this.s = s;
		this.v = v;
	}

	public Color() {
		this(360, 100, 0);
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public float getS() {
		return s;
	}

	public void setS(float s) {
		this.s = s;
	}

	public float getV() {
		return v;
	}

	public void setV(float v) {
		this.v = v;
	}
}
