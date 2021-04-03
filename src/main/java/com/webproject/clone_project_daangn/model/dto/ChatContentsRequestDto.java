package com.webproject.clone_project_daangn.model.dto;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class ChatContentsRequestDto {

   private Long chatroomId;
   private String writer;
   private String contents;

}
