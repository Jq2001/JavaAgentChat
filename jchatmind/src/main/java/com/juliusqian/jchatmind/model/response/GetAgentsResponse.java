package com.juliusqian.jchatmind.model.response;

import com.juliusqian.jchatmind.model.vo.AgentVO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetAgentsResponse {
    private AgentVO[] agents;
}
