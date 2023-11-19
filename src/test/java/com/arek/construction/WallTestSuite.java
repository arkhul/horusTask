package com.arek.construction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class WallTestSuite {

    private List<Block> createData() {
        MyBlock myBlock1 = new MyBlock("Brown", "Wood");
        MyBlock myBlock2 = new MyBlock("White", "Ice");
        MyBlock myBlock3 = new MyBlock("Grey", "Steel");
        MyBlock myBlock4 = new MyBlock("Brown", "Block");
        MyBlock myBlock5 = new MyBlock("Grey", "Concrete");
        MyBlock myBlock6 = new MyBlock("White", "Concrete");
        MyBlock myBlock7 = new MyBlock("White", "Wood");
        MyBlock myBlock8 = new MyBlock("White", "Block");
        MyBlock myBlock9 = new MyBlock("Grey", "Block");
        return new ArrayList<>(List.of(
                myBlock1, myBlock2, myBlock3, myBlock4, myBlock5, myBlock6, myBlock7, myBlock8, myBlock9));
    }

    @Test
    void shouldFindBlockByColorWhenElementExist() {
        // Given
        Wall wall = new Wall();
        wall.setBlocks(createData());

        // When
        Optional<Block> color1 = wall.findBlockByColor("Brown");
        Optional<Block> color2 = wall.findBlockByColor("White");
        Optional<Block> color3 = wall.findBlockByColor("Grey");

        // Then
        Assertions.assertEquals("Wood", color1.isPresent() ? color1.get().getMaterial() : "Null");
        Assertions.assertEquals("Ice", color2.isPresent() ? color2.get().getMaterial() : "Null");
        Assertions.assertEquals("Steel", color3.isPresent() ? color3.get().getMaterial() : "Null");
    }

    @Test
    void shouldReturnDefaultValueWhenPassedValueIsNull() {
        // Given
        Wall wall = new Wall();
        wall.setBlocks(createData());

        // When
        Optional<Block> color1 = wall.findBlockByColor(null);
        List<Block> material1 = wall.findBlocksByMaterial(null);

        // Then
        Assertions.assertEquals("Null", color1.isPresent() ? color1.get().getMaterial() : "Null");
        Assertions.assertEquals(0, material1.size());
    }

    @Test
    void shouldNotFindBlockByColorWhenElementDoesNotExist() {
        // Given
        Wall wall = new Wall();
        wall.setBlocks(createData());

        // When
        Optional<Block> color1 = wall.findBlockByColor("Blue");
        Optional<Block> color2 = wall.findBlockByColor("Black");

        // Then
        Assertions.assertEquals(Optional.empty(), color1);
        Assertions.assertEquals(Optional.empty(), color2);
    }

    @Test
    void shouldfindBlocksByMaterialWhenElementExist() {
        // Given
        Wall wall = new Wall();
        wall.setBlocks(createData());

        // When
        List<Block> material1 = wall.findBlocksByMaterial("Ice");
        List<Block> material2 = wall.findBlocksByMaterial("Block");
        List<Block> material3 = wall.findBlocksByMaterial("Concrete");

        // Then
        Assertions.assertEquals(List.of(wall.getBlocks().get(1)), material1);
        Assertions.assertEquals(List.of(wall.getBlocks().get(3), wall.getBlocks().get(7), wall.getBlocks().get(8)), material2);
        Assertions.assertEquals(List.of(wall.getBlocks().get(4), wall.getBlocks().get(5)), material3);
    }

    @Test
    void shouldCountExistingElements() {
        // Given
        Wall wall = new Wall();
        wall.setBlocks(createData());

        // When
        int quantity = wall.count();

        // Then
        Assertions.assertEquals(9, quantity);
    }

    @Test
    void shouldReturnZeroItemsWhenListIsEmpty() {
        // Given
        Wall wall = new Wall();
        wall.setBlocks(new ArrayList<>());

        // When
        int quantity = wall.count();

        // Then
        Assertions.assertEquals(0, quantity);
    }
}