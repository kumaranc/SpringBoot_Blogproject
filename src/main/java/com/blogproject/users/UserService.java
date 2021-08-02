package com.blogproject.users;

import com.blogproject.address.Address;
import com.blogproject.address.AddressService;
import com.blogproject.advisor.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService ;

    public User createUser(UserDTO userDTO) {
        //Do Address creation
    	if(userDTO.getName().isEmpty() || userDTO.getName().length() == 0) {
        	throw new CustomException("601", "Input fields are empty", new Date()+"");	
        }
    	try {
    		Address address = addressService.createAddress(userDTO.getAddress());
            User user = mapUserDTOtoUser.apply(userDTO);
            user.setAddress(address);
            User user1 = userRepository.save(user);
            return user1;
    	} catch (IllegalArgumentException ex) {
    		throw new CustomException("602", "Given user is null "+ ex.getMessage(), new Date()+"");	
		} catch (Exception ex) {
    		throw new CustomException("603", "Something went wrong in service "+ex.getMessage() , new Date()+"");	
		}
        
    }

    Function<UserDTO, User> mapUserDTOtoUser = (userdto) -> {
        User user = new User();
        user.setEmail(userdto.getEmail());
        user.setLocation(userdto.getLocation());
        user.setName(userdto.getName());
        return user;
    };
}
