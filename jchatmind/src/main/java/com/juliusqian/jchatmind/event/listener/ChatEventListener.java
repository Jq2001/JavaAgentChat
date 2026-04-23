package com.juliusqian.jchatmind.event.listener;

import com.juliusqian.jchatmind.agent.JChatMind;
import com.juliusqian.jchatmind.agent.JChatMindFactory;
import com.juliusqian.jchatmind.event.ChatEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChatEventListener {

    private final JChatMindFactory jChatMindFactory;

    @Async
    @EventListener
    public void handle(ChatEvent event) {
        // 创建一个 Agent 实例处理聊天事件
        JChatMind jChatMind = jChatMindFactory.create(event.getAgentId(), event.getSessionId());
        jChatMind.run();
    }
}
