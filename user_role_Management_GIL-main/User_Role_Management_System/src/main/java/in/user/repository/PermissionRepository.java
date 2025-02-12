package in.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.user.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	Permission findByName(String name);
}
