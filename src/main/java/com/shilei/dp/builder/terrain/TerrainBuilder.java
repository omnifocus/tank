package com.shilei.dp.builder.terrain;

public interface TerrainBuilder {
    TerrainBuilder buildWall();
    TerrainBuilder buildGround();
    TerrainBuilder buildFort();
    Terrain build();
}
