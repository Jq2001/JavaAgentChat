package com.juliusqian.jchatmind.model.request;

import com.juliusqian.jchatmind.model.dto.ChatMessageDTO;
import lombok.Data;

@Data
public class UpdateChatMessageRequest {
    private String content;
    private ChatMessageDTO.MetaData metadata;
}

