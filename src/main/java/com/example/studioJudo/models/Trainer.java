package com.example.studioJudo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="trainers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    @OneToMany(mappedBy = "trainer")
    @JsonIgnore
    private List<Session> sessions;

}
