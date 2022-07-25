package com.madara.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class Personnel extends GenericNamedEntity{
    private String firstName;
    private String lastName;
    private String contact;//
    private String email;//


    @ManyToOne
    private Role role;

    @JsonBackReference
    @ManyToOne
    private Vehicle vehicleID;

}
