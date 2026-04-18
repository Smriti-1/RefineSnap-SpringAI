# RefineSnap — AI Image Generator

> Turn a text prompt into a stunning HD image in seconds.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F?style=flat&logo=springboot&logoColor=white)
![Spring AI](https://img.shields.io/badge/Spring_AI-0.8-6DB33F?style=flat&logo=spring&logoColor=white)
![OpenAI](https://img.shields.io/badge/OpenAI-DALL·E_3-412991?style=flat&logo=openai&logoColor=white)
![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat&logo=openjdk&logoColor=white)

A full-stack AI image generation platform built with a vanilla JavaScript frontend and a Spring Boot backend powered by Spring AI. Type a prompt, hit generate, get a 1792×1024 HD image — no fuss.

---

## Demo
<img width="1171" height="869" alt="Screenshot 2026-04-17 203058" src="https://github.com/user-attachments/assets/835e8741-daaa-4b32-b60a-93b792f04d66" />


---

## Features

- HD image generation via OpenAI DALL·E 3 (1792×1024, natural style)
- Clean, responsive UI — no framework dependencies
- Spring AI `ImageModel` abstraction for easy provider swapping
- Fully configurable quality, dimensions, and style via `OpenAiImageOptions`
- RESTful API backend ready to plug into any frontend or mobile app

---

## Tech Stack

| Layer | Technology |
|---|---|
| Frontend | HTML5, CSS3, Vanilla JavaScript |
| Backend | Java 21, Spring Boot 3, Spring AI |
| AI Provider | OpenAI DALL·E 3 |
| Build | Maven |

---

## Getting Started

### Prerequisites
- Java 21+
- Maven
- OpenAI API key

### Clone & run

```bash
git clone https://github.com/your-username/refine-snap-image-generator.git
cd refine-snap-image-generator
```

### Set your API key

In `src/main/resources/application.properties`:

```properties
spring.ai.openai.api-key=YOUR_OPENAI_API_KEY
```

### Start the server

```bash
mvn spring-boot:run
```

Open `index.html` in your browser or serve it with any static file server.

---

## API Reference

```http
POST /api/images/generate
Content-Type: application/json

{
  "prompt": "A futuristic city skyline at golden hour, photorealistic"
}
```

**Response:**
```json
{
  "imageUrl": "https://..."
}
```

---

## Architecture

The backend uses Spring AI's `ImageModel` abstraction to decouple the application from OpenAI's SDK directly. Swapping to another image provider (Stability AI, etc.) requires changing a single bean — no business logic changes.

```
Frontend (HTML/JS)
    └── POST /api/images/generate
          └── ImageService
                └── Spring AI ImageModel
                      └── OpenAI DALL·E 3
```

---

## Contributing

PRs are welcome. Please open an issue first for major changes.

---

## License

MIT

---

*Built by [Your Name] · Open to full-stack and AI engineering roles · [LinkedIn](https://linkedin.com/in/your-profile)*
