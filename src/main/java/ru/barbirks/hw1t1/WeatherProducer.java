package ru.barbirks.hw1t1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class WeatherProducer implements CommandLineRunner {
    private String topic = "weather";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    public void send(WeatherStamp weatherStamp) {
        try{
            String weatherJson = mapper.writeValueAsString(weatherStamp);
            kafkaTemplate.send(topic, weatherJson);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendRandomWeather() {
        WeatherStamp weatherStamp = new WeatherStamp();
        weatherStamp.setRandomWeather();
        send(weatherStamp);
    }

    public void run(String... args) {
        System.out.println("Running");
        for (int i = 0; i < 10; i++) {
            sendRandomWeather();
        }
        System.out.println("Done");
    }
}
