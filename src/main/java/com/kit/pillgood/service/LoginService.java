package com.kit.pillgood.service;

import com.kit.pillgood.exeptions.exeption.NonRegistrationFirebaseException;
import com.kit.pillgood.persistence.dto.LoginDTO;
import com.kit.pillgood.persistence.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 로그인 기능
     * @param: 생성 될 userDTO
     * @return: 생성 된 userDTO
     **/
    public UserDTO login(LoginDTO loginDTO) throws NonRegistrationFirebaseException {
        String userEmail = loginDTO.getUserEamil();
        String userToken = loginDTO.getUserToken();

        // firebase에 등록 여부 확인
        if(!userService.isFirebaseUser(userEmail)){
            throw new NonRegistrationFirebaseException();
        }

        // mysql에 등록되지 않은 유저
        UserDTO userDTO = userService.searchUser(userEmail);
        if(userDTO == null){
            // mysql 생성
            userDTO = UserDTO.builder()
                            .userIndex(null)
                            .userFcmToken(userToken)
                            .userEmail(userEmail)
                            .build();

            userService.createUser(userDTO);
        }

        return userDTO;

    }
}
