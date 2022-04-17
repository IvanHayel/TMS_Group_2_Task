package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity {
    protected static final double DOUBLE_DEFAULT_VALUE = 0.0;

    protected int id;
}