import React, {
  createContext,
  useCallback,
  useContext,
  useEffect,
  useState,
} from "react";
import {
  type AgentVO,
  createAgent,
  type CreateAgentRequest,
  deleteAgent,
  getAgents,
  updateAgent,
  type UpdateAgentRequest,
} from "../api/api.ts";

interface AgentsContextType {
  agents: AgentVO[];
  refreshAgents: () => Promise<void>;
  createAgentHandle: (agent: CreateAgentRequest) => Promise<void>;
  deleteAgentHandle: (agentId: string) => Promise<void>;
  updateAgentHandle: (
    agentId: string,
    request: UpdateAgentRequest,
  ) => Promise<void>;
}

const AgentsContext = createContext<AgentsContextType | undefined>(undefined);

export function AgentsProvider({ children }: { children: React.ReactNode }) {
  const [agents, setAgents] = useState<AgentVO[]>([]);

  const refreshAgents = useCallback(async () => {
    const resp = await getAgents();
    setAgents(resp.agents);
  }, []);

  useEffect(() => {
    refreshAgents().then();
  }, [refreshAgents]);

  const createAgentHandle = useCallback(
    async (agent: CreateAgentRequest) => {
      await createAgent(agent);
      await refreshAgents();
    },
    [refreshAgents],
  );

  const deleteAgentHandle = useCallback(
    async (agentId: string) => {
      await deleteAgent(agentId);
      await refreshAgents();
    },
    [refreshAgents],
  );

  const updateAgentHandle = useCallback(
    async (agentId: string, request: UpdateAgentRequest) => {
      await updateAgent(agentId, request);
      await refreshAgents();
    },
    [refreshAgents],
  );

  return (
    <AgentsContext.Provider
      value={{
        agents,
        createAgentHandle,
        deleteAgentHandle,
        updateAgentHandle,
        refreshAgents,
      }}
    >
      {children}
    </AgentsContext.Provider>
  );
}

export function useAgentsContext() {
  const context = useContext(AgentsContext);
  if (context === undefined) {
    throw new Error("useAgentsContext must be used within an AgentsProvider");
  }
  return context;
}
