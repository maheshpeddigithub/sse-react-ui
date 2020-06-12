package com.example.sbssereactui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class SbSseReactUIApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSseReactUIApplication.class, args);
	}

	@RestController
	class ResourceController {
		@CrossOrigin(allowedHeaders = "*")
		@GetMapping(value = "/resource", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
		public Flux<Usage> getResourceUsage() {
			Random random = new Random();
			return Flux.interval(Duration.ofSeconds(1))
					.map(it -> new Usage(
							random.nextInt(101),
							random.nextInt(101),
							new Date()));
		}
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	class Usage {
		private int cpuUsage;
		private int memoryUsage;
		private Date date;

	}

}




