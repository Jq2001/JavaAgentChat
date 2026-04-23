import { useKnowledgeBasesContext } from "../contexts/KnowledgeBasesContext.tsx";

export function useKnowledgeBases() {
  return useKnowledgeBasesContext();
}
