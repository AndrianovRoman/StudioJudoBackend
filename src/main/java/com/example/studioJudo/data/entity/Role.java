package com.example.studioJudo.data.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "id")
    Short id;

    @Column(name = "name")
    String name;

    @ManyToMany(mappedBy = "roles")
    List<User> users;

}
