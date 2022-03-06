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
@Table(name = "mechanics_type")
public class MechanicsType {

    @Id
    @SequenceGenerator(
            name = "mechanics_type_sequence",
            sequenceName = "mechanics_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "mechanics_type_sequence"
    )
    @Column(
            name = "mechanics_type_ID",
            updatable = false
    )
    private Long mechanicsTypeId;

    @Column(
            name = "type"
    )
    private Type type;

    enum Type {
        COMPOUND, ISOLATION, NOT_APPLICABLE
    }
}
