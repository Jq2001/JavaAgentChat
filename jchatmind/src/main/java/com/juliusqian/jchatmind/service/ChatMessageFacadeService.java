package com.juliusqian.jchatmind.service;

import com.juliusqian.jchatmind.model.dto.ChatMessageDTO;
import com.juliusqian.jchatmind.model.request.CreateChatMessageRequest;
import com.juliusqian.jchatmind.model.request.UpdateChatMessageRequest;
import com.juliusqian.jchatmind.model.response.CreateChatMessageResponse;
import com.juliusqian.jchatmind.model.response.GetChatMessagesResponse;

import java.util.List;

public interface ChatMessageFacadeService {
    GetChatMessagesResponse getChatMessagesBySessionId(String sessionId);

    List<ChatMessageDTO> getChatMessagesBySessionIdRecently(String sessionId, int limit);

    CreateChatMessageResponse createChatMessage(CreateChatMessageRequest request);

    CreateChatMessageResponse createChatMessage(ChatMessageDTO chatMessageDTO);

    CreateChatMessageResponse agentCreateChatMessage(CreateChatMessageRequest request);

    CreateChatMessageResponse appendChatMessage(String chatMessageId, String appendContent);

    void deleteChatMessage(String chatMessageId);

    void updateChatMessage(String chatMessageId, UpdateChatMessageRequest request);
}
