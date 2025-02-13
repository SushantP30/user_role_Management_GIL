package in.user.service;

import java.util.List;

import in.user.entity.Role;

public interface roleService {

	public Role createRole(Role role);
	public List<Role> getAllRole();
	public Role updateRole(Role role);
	public Boolean deleteRole(Integer id);
	public Role findByroleId(Integer id);
}
