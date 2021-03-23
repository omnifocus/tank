package com.shilei.dp.builder.terrain;

public class Main {
    public static void main(String[] args) {
       TerrainBuilder builder = new SimpleTerrainBuilder();
        builder.buildFort().buildWall().buildGround().build();
        
    }
}
