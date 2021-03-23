package com.shilei.dp.builder.terrain;

public class SimpleTerrainBuilder implements TerrainBuilder{
    private Terrain terrain = new Terrain();
    @Override
    public TerrainBuilder buildWall() {
        terrain.wall = new Wall("wall");
        return this;
    }

    @Override
    public TerrainBuilder buildGround() {
        terrain.ground = new Ground("ground");
        return this;
    }

    @Override
    public TerrainBuilder buildFort() {
        terrain.fort = new Fort("fort");
        return this;
    }

    @Override
    public Terrain build() {
        return terrain;
    }
}
