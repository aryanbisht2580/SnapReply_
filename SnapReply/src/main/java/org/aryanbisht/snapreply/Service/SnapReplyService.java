package org.aryanbisht.snapreply.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aryanbisht.snapreply.Model.SnapReplyModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SnapReplyService {

    @Value("${gemini.api.url}")
    String url;

    @Value("${gemini.api.key}")
    String key;

    private final WebClient webClient;

    public SnapReplyService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String generateSnapReply(SnapReplyModel snp) throws JsonProcessingException {
        String prompt=getPrompt(snp);
        System.out.println(prompt);
        Map<String, Object> format=getFormat(prompt);
        String result=webClient
                .post()
                .uri(url+key)
                .header("Content-Type","application/json")
                .bodyValue(format)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        String extractedResult=extract(result);
        return extractedResult;
    }

    private String extract(String result) throws JsonProcessingException {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode=mapper.readTree(result);
            return rootNode
                    .path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();



    }

    private String getPrompt(SnapReplyModel snp) {

        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a email in ").append(snp.getType()).append(" tone without subject in response to email: ").append(snp.getContent());
        return prompt.toString();
    }

    private Map<String, Object> getFormat(String prompt) {
        Map<String, Object> result=Map.of("contents",new Object[]{Map.of("parts",new Object[]{Map.of("text",prompt)})});
        return result;
    }

    public void callItself() {
            String backendUrl = "https://snapreply-lb6t.onrender.com/api/hello";
             String result=webClient.get()
                    .uri(backendUrl)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();  // Blocking for simplicity; avoid in reactive apps

    }
}
