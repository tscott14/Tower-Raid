package level.tile;

import IO.Texture;
import graphics.Screen;
import utils.Vector2i;

public class WallTile extends Tile {

	public WallTile(Texture sprite) {
		super(sprite);
	}

	public void render(int x, int y) {
		Screen.renderTiles(new Vector2i(x, y), this);
	}

	public boolean isSolid() {
		return true;
	}
}
