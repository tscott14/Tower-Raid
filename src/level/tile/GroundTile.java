package level.tile;

import IO.Texture;
import graphics.Screen;
import utils.Vector2i;

public class GroundTile extends Tile {

	public GroundTile(Texture sprite) {
		super(sprite);
	}

	public void render(int x, int y) {
		Screen.renderTiles(new Vector2i(x, y), this);
	}

}
