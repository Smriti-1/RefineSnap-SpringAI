package com.refinesnap.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.*;
import org.springframework.ai.openai.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {

    private final ImageModel imageModel;
    private final ChatClient chatClient;

    public ImageService(ImageModel imageModel, OpenAiChatModel openAiChatModel) {
        this.imageModel = imageModel;
        this.chatClient = ChatClient.create(openAiChatModel);
    }

    public String generateImage(String prompt) {
        ImageResponse response = imageModel.call(new ImagePrompt(
                prompt,
                OpenAiImageOptions.builder()
                        .quality("hd")
                        .height(1024)
                        .width(1792)
                        .style("natural")
                        .build()
        ));
        return response.getResult().getOutput().getUrl();
    }

}