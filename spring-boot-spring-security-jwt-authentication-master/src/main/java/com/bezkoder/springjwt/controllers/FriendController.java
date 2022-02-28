package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.payload.request.AddFriend;
import com.bezkoder.springjwt.security.services.FriendService;
import com.bezkoder.springjwt.security.services.SecurityService;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/test/user")
public class FriendController {
    @Autowired
    FriendService friendService;
    @Autowired
    SecurityService securityService;
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody AddFriend addFriend)
    {
        UserDetailsImpl currentUser =  securityService.getUser();
      //  System.out.println(currentUser.getEmail());
        friendService.saveFriend(currentUser, addFriend.getId());
        Long id = addFriend.getId();
      //  return currentUser.getId();
        return ResponseEntity.ok("Friend added successfully");
    }
  /*  @GetMapping("addFriend")
    public ResponseEntity<?> addUser(@RequestParam("friendId")String friendId) throws NullPointerException{
        UserDto currentUser =  securityService.getUser();
        friendService.saveFriend(currentUser, (long) Integer.parseInt(friendId));
        return ResponseEntity.ok("Friend added successfully");
    }*/
}
