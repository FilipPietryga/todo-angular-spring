package com.example.springboot;

import com.example.springboot.model.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.springboot.repository.TaskRepository;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(TaskRepository taskRepository) {
		return args -> {
			Stream.of("do laundry", "finish the homework", "finish housework").forEach(title -> {
				Task task = new Task(title, title + " right now", new Date());
				taskRepository.save(task);
			});
			taskRepository.findAll().forEach(task -> System.out.println(task));
		};
	}

}
