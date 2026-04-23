package com.juliusqian.jchatmind.model.response;

import com.juliusqian.jchatmind.model.vo.KnowledgeBaseVO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetKnowledgeBasesResponse {
    private KnowledgeBaseVO[] knowledgeBases;
}

