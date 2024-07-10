package org.example.developer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    private final ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostMapping("/receive")
    public Response receiveJson(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            logger.error("Error reading JSON data", e);
            return new Response("error", "Error reading JSON data");
        }

        String jsonData = stringBuilder.toString();
        logger.debug("Received JSON data: {}", jsonData);

        Request requestData;
        try {
            requestData = objectMapper.readValue(jsonData, Request.class);
        } catch (IOException e) {
            logger.error("Error parsing JSON data", e);
            return new Response("error", "Error parsing JSON data");
        }

        logger.debug("Parsed Request data: {}", requestData);

        Response response = new Response();
        response.setStatus("success");
        response.setMessage("Data received successfully");

        return response;
    }
}
