package com.travelagency.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "role_id", nullable = false, insertable = true, updatable = true)
	private Long id;
	
	@Column(name = "name", nullable = true, insertable = true, updatable = true)
    private String name;
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}