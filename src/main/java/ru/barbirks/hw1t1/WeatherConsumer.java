package ru.barbirks.hw1t1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WeatherConsumer {
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();
    @KafkaListener(topics = {"weather"})
    public void consume(String message) {
        try {
            WeatherStamp weatherStamp = mapper.readValue(message, WeatherStamp.class);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
