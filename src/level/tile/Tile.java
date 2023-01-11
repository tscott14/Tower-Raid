package level.tile;

import IO.Texture;

public abstract class Tile {
	protected int x, y;
	public Texture sprite;

	public static Tile t_empty = new EmptyTile(Texture.t_empty);

	// ground
	public static Tile t_dirt01 = new GroundTile(Texture.t_dirt01);
	public static Tile t_grass01 = new GroundTile(Texture.t_grass01);
	public static Tile t_sand01 = new GroundTile(Texture.t_sand01);
	public static Tile t_redbrick01 = new WallTile(Texture.t_redbrick01);
	public static Tile t_greybrick01 = new WallTile(Texture.t_greybrick01);
	public static Tile t_water01 = new WaterTile(Texture.t_water01);

	// Transition ground
	public static Tile t_grassToDirt01 = new GroundTile(Texture.t_grassToDirt01);
	public static Tile t_grassToDirt02 = new GroundTile(Texture.t_grassToDirt02);
	public static Tile t_grassToDirt03 = new GroundTile(Texture.t_grassToDirt03);
	public static Tile t_grassToDirt04 = new GroundTile(Texture.t_grassToDirt04);
	public static Tile t_grassToDirt06 = new GroundTile(Texture.t_grassToDirt06);
	public static Tile t_grassToDirt07 = new GroundTile(Texture.t_grassToDirt07);
	public static Tile t_grassToDirt08 = new GroundTile(Texture.t_grassToDirt08);
	public static Tile t_grassToDirt09 = new GroundTile(Texture.t_grassToDirt09);

	public static Tile t_dirtToGrass01 = new GroundTile(Texture.t_dirtToGrass01);
	public static Tile t_dirtToGrass02 = new GroundTile(Texture.t_dirtToGrass02);
	public static Tile t_dirtToGrass03 = new GroundTile(Texture.t_dirtToGrass03);
	public static Tile t_dirtToGrass04 = new GroundTile(Texture.t_dirtToGrass04);
	public static Tile t_dirtToGrass06 = new GroundTile(Texture.t_dirtToGrass06);
	public static Tile t_dirtToGrass07 = new GroundTile(Texture.t_dirtToGrass07);
	public static Tile t_dirtToGrass08 = new GroundTile(Texture.t_dirtToGrass08);
	public static Tile t_dirtToGrass09 = new GroundTile(Texture.t_dirtToGrass09);

	public static Tile t_grassToSand01 = new GroundTile(Texture.t_grassToSand01);
	public static Tile t_grassToSand02 = new GroundTile(Texture.t_grassToSand02);
	public static Tile t_grassToSand03 = new GroundTile(Texture.t_grassToSand03);
	public static Tile t_grassToSand04 = new GroundTile(Texture.t_grassToSand04);
	public static Tile t_grassToSand05 = new GroundTile(Texture.t_grassToSand06);
	public static Tile t_grassToSand06 = new GroundTile(Texture.t_grassToSand07);
	public static Tile t_grassToSand07 = new GroundTile(Texture.t_grassToSand08);
	public static Tile t_grassToSand08 = new GroundTile(Texture.t_grassToSand09);

	public static Tile t_sandToGrass01 = new GroundTile(Texture.t_sandToGrass01);
	public static Tile t_sandToGrass02 = new GroundTile(Texture.t_sandToGrass02);
	public static Tile t_sandToGrass03 = new GroundTile(Texture.t_sandToGrass03);
	public static Tile t_sandToGrass04 = new GroundTile(Texture.t_sandToGrass04);
	public static Tile t_sandToGrass06 = new GroundTile(Texture.t_sandToGrass06);
	public static Tile t_sandToGrass07 = new GroundTile(Texture.t_sandToGrass07);
	public static Tile t_sandToGrass08 = new GroundTile(Texture.t_sandToGrass08);
	public static Tile t_sandToGrass09 = new GroundTile(Texture.t_sandToGrass09);

	public static Tile t_grassToGreybrick01 = new WallTile(Texture.t_grassToGraybrick01);
	public static Tile t_grassToGreybrick02 = new WallTile(Texture.t_grassToGraybrick02);
	public static Tile t_grassToGreybrick03 = new WallTile(Texture.t_grassToGraybrick03);
	public static Tile t_grassToGreybrick04 = new WallTile(Texture.t_grassToGraybrick04);
	public static Tile t_grassToGreybrick06 = new WallTile(Texture.t_grassToGraybrick06);
	public static Tile t_grassToGreybrick07 = new WallTile(Texture.t_grassToGraybrick07);
	public static Tile t_grassToGreybrick08 = new WallTile(Texture.t_grassToGraybrick08);
	public static Tile t_grassToGreybrick09 = new WallTile(Texture.t_grassToGraybrick09);

	public static Tile t_grassToRedbrick01 = new WallTile(Texture.t_grassToRedbrick01);
	public static Tile t_grassToRedbrick02 = new WallTile(Texture.t_grassToRedbrick02);
	public static Tile t_grassToRedbrick03 = new WallTile(Texture.t_grassToRedbrick03);
	public static Tile t_grassToRedbrick04 = new WallTile(Texture.t_grassToRedbrick04);
	public static Tile t_grassToRedbrick06 = new WallTile(Texture.t_grassToRedbrick06);
	public static Tile t_grassToRedbrick07 = new WallTile(Texture.t_grassToRedbrick07);
	public static Tile t_grassToRedbrick08 = new WallTile(Texture.t_grassToRedbrick08);
	public static Tile t_grassToRedbrick09 = new WallTile(Texture.t_grassToRedbrick09);

	public Tile(Texture sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y) {

	}

	public boolean isSolid() {
		return false;
	}

	public boolean canRotate() {
		return true;
	}

	public boolean isWater() {
		return false;
	}

}
