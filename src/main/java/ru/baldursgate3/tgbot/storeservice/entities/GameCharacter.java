package ru.baldursgate3.tgbot.storeservice.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "characters")
public class GameCharacter {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private short strength;
    private short dexterity;
    private short toughness;
    private short intellect;
    private short wisdom;
    private short charisma;


    
}
