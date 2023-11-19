package com.arek.construction;

import java.util.List;

public class MyBlock implements CompositeBlock {

    private final String color;
    private final String material;

    public MyBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public List<Block> getBlocks() {
        return List.of(new MyBlock(color, material));
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
