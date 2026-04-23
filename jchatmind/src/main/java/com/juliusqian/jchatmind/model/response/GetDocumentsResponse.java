package com.juliusqian.jchatmind.model.response;

import com.juliusqian.jchatmind.model.vo.DocumentVO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetDocumentsResponse {
    private DocumentVO[] documents;
}

