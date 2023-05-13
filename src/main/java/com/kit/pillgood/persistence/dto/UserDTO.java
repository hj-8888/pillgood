package com.kit.pillgood.persistence.dto;

import com.kit.pillgood.domain.GroupMember;
import com.kit.pillgood.domain.Notification;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserDTO {
    private Long userIndex;

    @NotEmpty(message = "userEmail 누락")
    @Email
    private String userEmail;

    @NotEmpty(message = "userFcmToken 누락")
    private String userFcmToken;

    
}
