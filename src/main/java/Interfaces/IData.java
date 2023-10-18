package Interfaces;

import java.util.Optional;

public interface IData <Entity, IdType> {
    Optional<Entity> add(Entity entity);
    Optional<Entity> update(Entity entity);
    boolean delete(IdType id);
}
