package platform.codingnomads.co.springdata.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.example.jpa.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByName(String name);
}

