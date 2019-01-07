package com.travelagency.app.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
	private Long id;
	
	@Column(name = "name", nullable = true, insertable = true, updatable = true)
    private String name;

	@ManyToMany
	@JoinTable(name = "agent_roles", joinColumns = @JoinColumn(name = "role_id"),
	            inverseJoinColumns = @JoinColumn(name = "agent_id"))
    private Set<AgentEntity> agents = new HashSet<AgentEntity>();

    public RoleEntity() {
    }

    
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

    public Set<AgentEntity> getAgents() {
        return agents;
    }

    public void setAgents(Set<AgentEntity> agents) {
        this.agents = agents;
    }

}