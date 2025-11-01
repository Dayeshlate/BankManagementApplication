package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.users;

public interface usersRepo extends JpaRepository<users,Integer> {

}
