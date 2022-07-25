package com.madara.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class Vehicle extends GenericNamedEntity{
    private String licencePlate;//
    private String route;
    private String contact;//
    private String vehicleType;//
    private String vehicleModel;//
    private String numberOfpassengers;//
    private String company;//
    private String description;


    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "vehicleID")
    private List<Personnel> personnelList = new ArrayList<>();
}
