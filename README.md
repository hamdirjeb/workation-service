# Spring Boot + Elasticsearch Demo

A simple Spring Boot application that integrates with Elasticsearch using the official Java client.  
It provides basic REST APIs to index and search `Student` documents.

---

## 🧰 Tech Stack

- Java 21
- Spring Boot 3.2
- Elasticsearch 8.x
- REST API
- Maven
- Docker (optional)

---

## 🚀 How to Run (Locally)

### 1. Start Elasticsearch (Docker recommended)
```bash
docker run -p 9200:9200 -e "discovery.type=single-node" \
  -e "xpack.security.enabled=false" \
  docker.elastic.co/elasticsearch/elasticsearch:8.13.4