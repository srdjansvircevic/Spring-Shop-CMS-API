package co.decem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.decem.dao.RoleRepository;
import co.decem.dao.UserDao;
import co.decem.model.Role;
import co.decem.model.User;
import co.decem.model.UserDto;
import co.decem.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDao userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create roles
        if(isAlreadySeeded("ADMIN")){
            return;
        }
        Role userRole = new Role();
        userRole.setName("USER");
        userRole = roleRepository.save(userRole);

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        adminRole = roleRepository.save(adminRole);

        Role employeeRole = new Role();
        employeeRole.setName("EMPLOYEE");
        employeeRole = roleRepository.save(employeeRole);

        // Create users
        createUser("user1", "user1@example.com", "password", userRole);
        createUser("test", "test@test.test", "test", adminRole);
        createUser("admin1", "admin1@example.com", "password", adminRole);
        createUser("employee1", "employee1@example.com", "password", employeeRole);
    }

    private boolean isAlreadySeeded(String roleName) {
        Role role = roleRepository.findByName(roleName);
        return role != null;
    }

    private void createUser(String username, String email, String password, Role role) {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setName(username);
        userDto.setPhone("+1234567890");

        User user = userDto.getUserFromDto();
        user.setPassword(bcryptEncoder.encode(userDto.getPassword()));

        user = userRepository.save(user);

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);
    }
}