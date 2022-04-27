package com.keqi;

import org.jgrapht.graph.DefaultWeightedEdge;

public class MyDefaultWeightedEdge extends DefaultWeightedEdge {

    private Boolean block;

    public Boolean getBlock() {
        return block;
    }

    public void setBlock(Boolean block) {
        this.block = block;
    }
}
