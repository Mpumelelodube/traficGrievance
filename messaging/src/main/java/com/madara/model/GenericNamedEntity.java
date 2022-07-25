package com.madara.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@EqualsAndHashCode
public abstract class GenericNamedEntity extends BaseID {

   
    //@NotNull(message = "name must not be null")
    protected String name;
    protected static final long serialVersionUID = 1L;

}
