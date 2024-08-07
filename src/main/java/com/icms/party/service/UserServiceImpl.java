package com.icms.party.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.icms.party.entity.Role;
import com.icms.party.entity.User;
import com.icms.party.entity.UserInfo;
import com.icms.party.repository.UserInfoRepository;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {


    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private UserInfoRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmail(username);
	        if(user == null){
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }

	        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
	}
	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getClass()));
        });
        return authorities;
    }
	public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User findOne(String email) {
        return userRepo.findByEmail(email);
    }

    public User save(UserInfo user) {

    	 User nUser = user.getUser();
        nUser.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if(nUser.getEmail().split("@")[1].equals("admin.edu")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return userRepo.save(nUser);
    }
}
