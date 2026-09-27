# Day 14 Architecture

```text
Browser / Client
      |
      | WebSocket STOMP
      v
 Chat Service :8081 ---- PostgreSQL (history)
      |
      +---- Redis (planned presence/fanout)
      +---- Kafka (planned durable events)

 REST -> Room Service :8082 ---- PostgreSQL (rooms)
```

The local build deliberately keeps Redis/Kafka integration lightweight so the project can run without external credentials. The README documents the scaling steps.
