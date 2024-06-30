package com.example.studioJudo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="sessions")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date session_date;
    private Time start_time;
    private Time end_time;
    private String description;

    @OneToOne(mappedBy = "session")
    @JsonIgnore
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
}
