package ru.baldursgate3.tgbot.storeservice.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity(name = "GameCharacter")
@Table(name = "gamecharacters")
public class GameCharacter {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    @JoinColumn(name = "id",nullable = false)
    private User user;

    private short strength;
    private short dexterity;
    private short constitution;
    private short intellect;
    private short wisdom;
    private short charisma;


    
}
