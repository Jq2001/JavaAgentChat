package com.juliusqian.jchatmind.service;

import com.juliusqian.jchatmind.agent.tools.Tool;

import java.util.List;

public interface ToolFacadeService {
    List<Tool> getAllTools();

    List<Tool> getOptionalTools();

    List<Tool> getFixedTools();
}
