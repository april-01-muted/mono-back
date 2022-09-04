package com.example.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.application.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.domain.users.UsersDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
public class RestDataController {

    @Autowired
    UsersService userService;

    @RequestMapping("/getUsersById")
    public List<UsersDto> getUsersById(@RequestParam String id) {
	
    List<UsersDto> userslist;
    userslist = userService.findById(Integer.parseInt(id));

     return userslist;  
	}

    @RequestMapping("/getUsersByName")
    public List<UsersDto> getUsersByName(@RequestParam String name) {

    List<UsersDto> userslist;
    userslist = userService.findByName(name);

     return userslist;  
	}

    @PostMapping("/insertUsers")
    public void insertUsers(@RequestBody UsersDto usersDto) {

    userService.insertUsers(usersDto);

    }

    @PutMapping("/updateUsers")
    public void updateUsers(@RequestParam String id,@RequestBody UsersDto usersDto) {
    
        usersDto.setId(Integer.parseInt(id)); 
        userService.updateUsers(usersDto);

    }

    @DeleteMapping("/deleteUsers")
    public void deleteUsers(@RequestParam String id) {

    userService.deleteUsers(Integer.parseInt(id));

    }
}
