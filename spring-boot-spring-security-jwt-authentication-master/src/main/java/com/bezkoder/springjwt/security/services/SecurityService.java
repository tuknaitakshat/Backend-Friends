package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserDto;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SecurityService {
    @Autowired
    HttpServletRequest httpServletRequest;

//    @Autowired
 //   CookieUtils cookieUtils;

  //  @Autowired
 //   SecurityProperties securityProps;

    public UserDetailsImpl getUser() {
        UserDetailsImpl userDtoPrincipal = null;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object principal = securityContext.getAuthentication().getPrincipal();
        if (principal instanceof UserDetailsImpl) {
            userDtoPrincipal = ((UserDetailsImpl) principal);
        }
        return userDtoPrincipal;
    }
}
