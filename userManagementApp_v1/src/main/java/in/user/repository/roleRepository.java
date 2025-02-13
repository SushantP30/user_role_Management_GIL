package in.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.user.entity.Role;
@Repository
public interface roleRepository extends JpaRepository<Role, Integer> {

}
