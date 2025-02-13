package in.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.user.entity.Permission;
@Repository
public interface permissionRepo extends JpaRepository<Permission, Integer> {

}
