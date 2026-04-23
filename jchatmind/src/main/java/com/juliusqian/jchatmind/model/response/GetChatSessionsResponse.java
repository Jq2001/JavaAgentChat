package com.juliusqian.jchatmind.model.response;

import com.juliusqian.jchatmind.model.vo.ChatSessionVO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetChatSessionsResponse {
    private ChatSessionVO[] chatSessions;
}
