package com.sealsugar.gymapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "exercise_equipment")
public class ExerciseEquipment {

    @Id
    @SequenceGenerator(
            name = "exercise_equipment_sequence",
            sequenceName = "exercise_equipment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "exercise_equipment_sequence"
    )
    @Column(
            name = "exercise_equipment_ID",
            updatable = false
    )
    private Long exerciseEquipmentId;

    @Column(
            name = "equipment"
    )
    private String equipment;
}