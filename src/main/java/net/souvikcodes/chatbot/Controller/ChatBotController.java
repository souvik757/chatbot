package net.souvikcodes.chatbot.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/chatbot")
public class ChatBotController {

    private ChatClient chatClient;

    public ChatBotController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/")
    public ResponseEntity<String> getResponse(@PathParam("prompt") String prompt) {
        String response = chatClient.prompt(prompt).call().content();
        return ResponseEntity.ok(response);
    }
}
