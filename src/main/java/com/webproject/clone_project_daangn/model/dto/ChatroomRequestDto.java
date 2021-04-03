package com.webproject.clone_project_daangn.model.dto;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class ChatroomRequestDto {

    private Long userId;
    private String seller;
    private String buyer;

}
