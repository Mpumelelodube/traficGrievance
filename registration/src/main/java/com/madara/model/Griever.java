package com.madara.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class Griever extends GenericNameEntity{

    private String firstNane;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String imageUrl;
}
