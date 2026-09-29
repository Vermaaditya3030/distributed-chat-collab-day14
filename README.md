# Day 14 — Distributed Real-Time Collaboration & Chat Platform 💬

A Java 17/Spring Boot portfolio project for real-time rooms and WebSocket/STOMP messaging, with PostgreSQL persistence, Redis/Kafka infrastructure, Docker Compose, Prometheus/Grafana, JUnit and GitHub Actions.

## Services
- Chat Service: 8081 — WebSocket/STOMP endpoint `/ws`, message destination `/app/chat`, broadcast `/topic/messages`, message history API.
- Room Service: 8082 — room CRUD.
- PostgreSQL: 5432
- Redis: 6379
- Kafka: 9092
- Prometheus: 9090
- Grafana: 3000

## Run
```powershell
cd distributed-chat-collab-day14
docker compose up --build
```

## Test
```powershell
mvn -B test
```

## Create a room
```powershell
$body='{"name":"Engineering","owner":"aditya"}'
Invoke-RestMethod -Method Post -Uri http://localhost:8082/api/rooms -ContentType 'application/json' -Body $body
```

## REST message history
```powershell
Invoke-RestMethod http://localhost:8081/api/history/ROOM_ID
```

## WebSocket/STOMP
Connect a STOMP client to `ws://localhost:8081/ws`.
Subscribe to `/topic/messages`, then send a STOMP message to `/app/chat` with:
```json
{"roomId":"ROOM_ID","sender":"aditya","content":"Hello team","timestamp":0}
```

## GitHub
Create an empty repository named `distributed-chat-collab-day14`, then:
```powershell
git init
git add .
git commit -m "Day 14: distributed real-time collaboration platform"
git branch -M main
git remote add origin https://github.com/Vermaaditya3030/distributed-chat-collab-day14.git
git push -u origin main
```

## Architecture
Client -> WebSocket/STOMP -> Chat Service -> broadcast/history. Room Service manages durable rooms. PostgreSQL stores rooms and message history. Redis and Kafka are included as infrastructure for scaling fan-out, presence, and event-driven processing.

## Production hardening roadmap
1. Add JWT authentication and WebSocket CONNECT authentication.
2. Use Redis Pub/Sub for multi-instance WebSocket fan-out.
3. Add Redis presence/heartbeats and typing indicators.
4. Add Kafka durable message events and retry/DLT.
5. Add optimistic versioning for collaborative document edits.
6. Add rate limits, message size limits and moderation hooks.
7. Add WebSocket metrics, tracing and centralized logs.
8. Add horizontal scaling behind an API gateway/load balancer.
