import React, {
  createContext,
  useCallback,
  useContext,
  useEffect,
  useState,
} from "react";
import {
  createKnowledgeBase,
  type CreateKnowledgeBaseRequest,
  getKnowledgeBases,
} from "../api/api.ts";
import type { KnowledgeBase } from "../types";

interface KnowledgeBasesContextType {
  knowledgeBases: KnowledgeBase[];
  refreshKnowledgeBases: () => Promise<void>;
  createKnowledgeBaseHandle: (
    request: CreateKnowledgeBaseRequest,
  ) => Promise<void>;
}

const KnowledgeBasesContext = createContext<
  KnowledgeBasesContextType | undefined
>(undefined);

function convertKnowledgeBases(
  knowledgeBases: Awaited<ReturnType<typeof getKnowledgeBases>>["knowledgeBases"],
): KnowledgeBase[] {
  return knowledgeBases.map((kb) => ({
    knowledgeBaseId: kb.id,
    name: kb.name,
    description: kb.description || "",
  }));
}

export function KnowledgeBasesProvider({
  children,
}: {
  children: React.ReactNode;
}) {
  const [knowledgeBases, setKnowledgeBases] = useState<KnowledgeBase[]>([]);

  const refreshKnowledgeBases = useCallback(async () => {
    const resp = await getKnowledgeBases();
    setKnowledgeBases(convertKnowledgeBases(resp.knowledgeBases));
  }, []);

  useEffect(() => {
    refreshKnowledgeBases().then();
  }, [refreshKnowledgeBases]);

  const createKnowledgeBaseHandle = useCallback(
    async (request: CreateKnowledgeBaseRequest) => {
      await createKnowledgeBase(request);
      await refreshKnowledgeBases();
    },
    [refreshKnowledgeBases],
  );

  return (
    <KnowledgeBasesContext.Provider
      value={{
        knowledgeBases,
        createKnowledgeBaseHandle,
        refreshKnowledgeBases,
      }}
    >
      {children}
    </KnowledgeBasesContext.Provider>
  );
}

export function useKnowledgeBasesContext() {
  const context = useContext(KnowledgeBasesContext);
  if (context === undefined) {
    throw new Error(
      "useKnowledgeBasesContext must be used within a KnowledgeBasesProvider",
    );
  }
  return context;
}
