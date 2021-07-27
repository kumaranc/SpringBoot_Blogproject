package com.blogproject.users;

import com.blogproject.address.Address;
import com.blogproject.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService ;

    public User createUser(UserDTO userDTO) {
        //Do Address creation
        Address address = addressService.createAddress(userDTO.getAddress());
        User user = mapUserDTOtoUser.apply(userDTO);
        user.setAddress(address);
        User user1 = userRepository.save(user);

        return user1;
    }

    Function<UserDTO, User> mapUserDTOtoUser = (userdto) -> {
        User user = new User();
        user.setEmail(userdto.getEmail());
        user.setLocation(userdto.getLocation());
        user.setName(userdto.getName());
        return user;
    };
}
