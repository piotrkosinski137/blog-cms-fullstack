package com.blogen.auth;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EntityId implements Serializable {

    private static final long serialVersionUID = 4759501283714818043L;

    @Column(name = "ID", columnDefinition = "BINARY(16)")
    private UUID value;

    private EntityId() {
    }

    public static EntityId create() {
        EntityId entityId = new EntityId();
        entityId.setValue(UUID.randomUUID());
        return entityId;
    }

    public static EntityId create(UUID id) {
        EntityId entityId = new EntityId();
        entityId.setValue(id);
        return entityId;
    }

    public static EntityId fromString(String id) {
        EntityId entityId = new EntityId();
        entityId.setValue(UUID.fromString(id));
        return entityId;
    }

    public UUID getValue() {
        return value;
    }

    void setValue(UUID value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityId entityId = (EntityId) o;
        return value.equals(entityId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
