import { useAgentsContext } from "../contexts/AgentsContext.tsx";

export function useAgents() {
  return useAgentsContext();
}
