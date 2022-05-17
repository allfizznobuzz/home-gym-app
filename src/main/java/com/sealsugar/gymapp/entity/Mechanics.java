package com.sealsugar.gymapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mechanics")
public class Mechanics {

    @Id
    @SequenceGenerator(
            name = "mechanics_sequence",
            sequenceName = "mechanics_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "mechanics_sequence"
    )
    @Column(
            name = "mechanics_ID",
            updatable = false
    )
    private Long mechanicsId;

    @Column(
            name = "type",
            columnDefinition = "varchar(255)"
    )
    private String mechanicsType;

    public enum MechanicsType {
        COMPOUND, ISOLATION, NOT_APPLICABLE
    }
}
