package level.tile;

import IO.Texture;
import graphics.Screen;
import utils.Vector2i;

public class WaterTile extends Tile {

	public WaterTile(Texture sprite) {
		super(sprite);
	}

	public void render(int x, int y) {
		Screen.renderTiles(new Vector2i(x, y), this);
	}

	public boolean isWater() {
		return true;
	}

	public boolean isSolid() {
		return false;
	}
}
