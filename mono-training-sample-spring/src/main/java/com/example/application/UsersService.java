package com.example.application;

import com.example.domain.users.UsersEntity;
import com.example.domain.users.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.domain.users.UsersDto;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    Logger logger = LoggerFactory.getLogger(UsersService.class);

    public List<UsersDto> findById(int id) {

        List<UsersEntity> usersRopoList;

        usersRopoList = usersRepository.findById(id);

        List<UsersDto> usersList = new ArrayList<UsersDto>();

        if(usersRopoList == null || usersRopoList.isEmpty()){
            return usersList;
        }

        for(UsersEntity repoList : usersRopoList){
            UsersDto usersDto = new UsersDto();
            usersDto.setId(repoList.getId());
            usersDto.setName(repoList.getName());
            usersList.add(usersDto);
        }

        return usersList;
    }
    
    public List<UsersDto> findByName(String name) {

        List<UsersEntity> usersRopoList;

        usersRopoList = usersRepository.findByName(name);

        List<UsersDto> usersList = new ArrayList<UsersDto>();

        for(UsersEntity repoList : usersRopoList){
            UsersDto usersDto = new UsersDto();
            usersDto.setId(repoList.getId());
            usersDto.setName(repoList.getName());
            usersList.add(usersDto);
        }

        return usersList;
    }

    public void insertUsers(UsersDto usersDto) {

        UsersEntity usersEntity = new UsersEntity();

        usersEntity.setId(usersDto.getId());
        usersEntity.setName(usersDto.getName());

        logger.info(usersEntity.getCreatedBy());
        logger.info(usersEntity.getUpdatedBy());

        usersRepository.save(usersEntity);
    }

    public void updateUsers(UsersDto usersDto) {

        usersRepository.update(usersDto.getId(),usersDto.getName());
    }

    public void deleteUsers(int id) {

        usersRepository.deleteById(id);
    }
}
