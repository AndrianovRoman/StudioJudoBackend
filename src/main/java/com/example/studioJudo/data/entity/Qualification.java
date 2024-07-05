package com.example.studioJudo.data.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name="qualifications")
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

//    @OneToMany(mappedBy = "qualification") //Узнать
    @OneToMany
    @JoinColumn(name = "qualification_id")
//    @JsonIgnore
    List<User> user;


}
