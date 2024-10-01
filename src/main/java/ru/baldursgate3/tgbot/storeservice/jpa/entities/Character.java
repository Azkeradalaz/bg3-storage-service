package ru.baldursgate3.tgbot.storeservice.jpa.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "characters")
public class Character {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id.equals(character.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
