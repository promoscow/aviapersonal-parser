package ru.xpendence.aviapersonal.parser.entity;

import ru.xpendence.aviapersonal.parser.attribute.ActiveType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 13:39
 * e-mail: 2262288@gmail.com
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private Long id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private ActiveType activeType = ActiveType.ENABLED;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "created", updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    @Column(name = "updated", insertable = false)
    public LocalDateTime getUpdated() {
        return updated;
    }

    @Column(name = "active")
    public ActiveType getActiveType() {
        return activeType;
    }

    @PrePersist
    public void toCreate() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void toUpdate() {
        this.updated = LocalDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setActiveType(ActiveType activeType) {
        this.activeType = activeType;
    }
}
