package in.user.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer perId;
    
    @NotBlank(message = "Permission name is mandatory")
    @Size(min = 3, max = 50, message = "Permission name must be between 3 and 50 characters")
	private String perName;
    
//	@ManyToOne
//	@JoinColumn(name="roleId")
//	private Role role;
    
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();
	
	public Integer getPerId() {
		return perId;
	}
	public void setPerId(Integer perId) {
		this.perId = perId;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
