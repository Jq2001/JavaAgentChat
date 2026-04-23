import { BrowserRouter } from "react-router-dom";
import JChatMindLayout from "./components/JChatMindLayout.tsx";
import { AgentsProvider } from "./contexts/AgentsContext.tsx";
import { ChatSessionsProvider } from "./contexts/ChatSessionsContext.tsx";
import { KnowledgeBasesProvider } from "./contexts/KnowledgeBasesContext.tsx";

function App() {
  return (
    <BrowserRouter>
      <ChatSessionsProvider>
        <AgentsProvider>
          <KnowledgeBasesProvider>
            <JChatMindLayout />
          </KnowledgeBasesProvider>
        </AgentsProvider>
      </ChatSessionsProvider>
    </BrowserRouter>
  );
}

export default App;
