package com.beliefdrivendesign.afatj.factory_pattern.fp.shapes;

import com.beliefdrivendesign.afatj.factory_pattern.fp.Color;
import com.beliefdrivendesign.afatj.factory_pattern.fp.ShapeType;

public abstract class Shape {

    public Shape(int corners, Color color, ShapeType type) {
        this.corners = corners;
        this.color = color;
        this.type = type;
    }

    private final int corners;
    private final Color color;
    private final ShapeType type;

    public int corners() {
        return this.corners;
    }

    Color color() {
        return this.color;
    }

    ShapeType type() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("%s[corners=%d, color=%s]", type(), corners(), color());
    }
}
