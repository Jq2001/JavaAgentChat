# JChatMind

JChatMind is a full-stack AI agent assistant built with Spring AI, React, PostgreSQL and pgvector. It supports multi-turn agent reasoning, tool execution, knowledge-base retrieval and real-time execution status streaming.

This repository is maintained by JuliusQian as a personal learning and development project. 
## Features

- Agent loop with thinking, execution, completion and error states
- Tool registry for fixed and optional tools
- RAG workflow with Markdown parsing, embedding storage and vector search
- PostgreSQL + pgvector based knowledge-base storage
- Multi-model configuration for DeepSeek and Zhipu AI
- SSE streaming for real-time agent progress
- React + Ant Design frontend for agent chat and knowledge-base management

## Tech Stack

- Backend: Java 17, Spring Boot, Spring AI, MyBatis
- Database: PostgreSQL, pgvector
- Frontend: React, TypeScript, Vite, Ant Design
- Build tools: Maven, npm

## Project Structure

```text
.
├── jchatmind/        # Spring Boot backend
├── ui/               # React frontend
├── examples/         # API / UI examples
├── README.md
└── LICENSE
```

## Configuration

Sensitive values are read from environment variables. Do not commit real API keys, email authorization codes or local database passwords.

Backend variables:

| Name | Default | Description |
| --- | --- | --- |
| `DB_URL` | `jdbc:postgresql://localhost:5433/postgres` | PostgreSQL connection URL |
| `DB_USERNAME` | `postgres` | PostgreSQL username |
| `DB_PASSWORD` | `postgres` | PostgreSQL password |
| `MAIL_HOST` | `smtp.qq.com` | SMTP host |
| `MAIL_PORT` | `587` | SMTP port |
| `MAIL_USERNAME` | empty | SMTP username |
| `MAIL_PASSWORD` | empty | SMTP authorization code |
| `DEEPSEEK_API_KEY` | empty | DeepSeek API key |
| `DEEPSEEK_BASE_URL` | `https://api.deepseek.com` | DeepSeek API base URL |
| `DEEPSEEK_MODEL` | `deepseek-chat` | DeepSeek chat model |
| `ZHIPUAI_API_KEY` | empty | Zhipu AI API key |
| `ZHIPUAI_BASE_URL` | `https://open.bigmodel.cn/api/paas` | Zhipu AI API base URL |
| `ZHIPUAI_MODEL` | `glm-4.6` | Zhipu AI chat model |

Frontend variables:

```bash
cp ui/.env.example ui/.env
```

Then adjust `VITE_API_BASE_URL` if the backend is not running at `http://localhost:8080`.

## Run Locally

Start the backend:

```bash
cd jchatmind
./mvnw spring-boot:run
```

On Windows:

```powershell
cd jchatmind
.\mvnw.cmd spring-boot:run
```

Start the frontend:

```bash
cd ui
npm install
npm run dev
```

## Upload Notes

Before pushing to GitHub, make sure these files are not committed:

- local logs such as `*.log`
- runtime data such as `jchatmind/data/`
- dependency folders such as `ui/node_modules/`
- build output such as `jchatmind/target/` and `ui/dist/`
- real environment files such as `.env`

If any API key or email authorization code has already been exposed locally, rotate it in the provider console before making the repository public.
