package com.kit.pillgood.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationContentDTO {
    private Long userIndex;
    private String groupMemberName;
    private int takePillTime;
    private String userFcmToken;
}