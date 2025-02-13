package in.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.user.entity.User;
@Repository
public interface userRepository extends JpaRepository<User, Integer> {

}
