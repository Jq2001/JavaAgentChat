package com.juliusqian.jchatmind.service;

import com.juliusqian.jchatmind.model.request.CreateKnowledgeBaseRequest;
import com.juliusqian.jchatmind.model.request.UpdateKnowledgeBaseRequest;
import com.juliusqian.jchatmind.model.response.CreateKnowledgeBaseResponse;
import com.juliusqian.jchatmind.model.response.GetKnowledgeBasesResponse;

public interface KnowledgeBaseFacadeService {
    GetKnowledgeBasesResponse getKnowledgeBases();

    CreateKnowledgeBaseResponse createKnowledgeBase(CreateKnowledgeBaseRequest request);

    void deleteKnowledgeBase(String knowledgeBaseId);

    void updateKnowledgeBase(String knowledgeBaseId, UpdateKnowledgeBaseRequest request);
}

