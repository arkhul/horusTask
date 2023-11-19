package com.arek.construction;

import java.util.List;

public interface CompositeBlock extends Block {

    List<Block> getBlocks();
}
