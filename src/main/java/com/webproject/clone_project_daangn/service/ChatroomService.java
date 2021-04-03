package com.webproject.clone_project_daangn.service;

import com.webproject.clone_project_daangn.model.entity.Chatroom;
import com.webproject.clone_project_daangn.repository.ChatroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatroomService {

    private final ChatroomRepository chatroomRepository;

    public Chatroom findById(Long id) {
        return chatroomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾는 아이디가 없습니다"));
    }

}
