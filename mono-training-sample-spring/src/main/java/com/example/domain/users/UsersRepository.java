package com.example.domain.users;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer>{
    
    public List<UsersEntity> findById(int id);
    public List<UsersEntity> findByName(String name);

    @Modifying
    @Query("update UsersEntity u set name = :name where id = :id")
    void update(@Param("id") int id, @Param("name") String name);
}
