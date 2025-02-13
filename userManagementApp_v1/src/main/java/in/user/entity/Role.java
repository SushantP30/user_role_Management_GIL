package in.user.entity;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Role {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	 @NotBlank(message = "Role name is mandatory")
	    @Size(min = 3, max = 50, message = "Role name must be between 3 and 50 characters")
	private String roleName;
	 
	  @ManyToMany(mappedBy = "roles")
	    private Set<User> users = new HashSet<>();;

//	@OneToMany
//	private List<Permission> permissions;
	    
	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "role_permissions",
	            joinColumns = @JoinColumn(name = "role_id"),
	            inverseJoinColumns = @JoinColumn(name = "per_id"))
	    private Set<Permission> permissions = new HashSet<>();

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

		public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}


}
