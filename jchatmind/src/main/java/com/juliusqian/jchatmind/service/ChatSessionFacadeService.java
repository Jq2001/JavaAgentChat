package com.juliusqian.jchatmind.service;

import com.juliusqian.jchatmind.model.request.CreateChatSessionRequest;
import com.juliusqian.jchatmind.model.request.UpdateChatSessionRequest;
import com.juliusqian.jchatmind.model.response.CreateChatSessionResponse;
import com.juliusqian.jchatmind.model.response.GetChatSessionResponse;
import com.juliusqian.jchatmind.model.response.GetChatSessionsResponse;

public interface ChatSessionFacadeService {
    GetChatSessionsResponse getChatSessions();

    GetChatSessionResponse getChatSession(String chatSessionId);

    GetChatSessionsResponse getChatSessionsByAgentId(String agentId);

    CreateChatSessionResponse createChatSession(CreateChatSessionRequest request);

    void deleteChatSession(String chatSessionId);

    void updateChatSession(String chatSessionId, UpdateChatSessionRequest request);
}
