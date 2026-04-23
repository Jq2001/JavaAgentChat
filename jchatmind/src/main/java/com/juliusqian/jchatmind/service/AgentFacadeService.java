package com.juliusqian.jchatmind.service;

import com.juliusqian.jchatmind.model.request.CreateAgentRequest;
import com.juliusqian.jchatmind.model.request.UpdateAgentRequest;
import com.juliusqian.jchatmind.model.response.CreateAgentResponse;
import com.juliusqian.jchatmind.model.response.GetAgentsResponse;

public interface AgentFacadeService {
    GetAgentsResponse getAgents();

    CreateAgentResponse createAgent(CreateAgentRequest request);

    void deleteAgent(String agentId);

    void updateAgent(String agentId, UpdateAgentRequest request);
}
