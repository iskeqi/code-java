package com.keqi.serversendevents;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class DemoController {

	private static final Map<Integer, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

	@GetMapping(value = "/sse/open/{clientId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter openConnection(@PathVariable Integer clientId) {
		SseEmitter sseEmitter = new SseEmitter(0L);
		sseEmitterMap.put(clientId, sseEmitter);
		return sseEmitter;
	}

	@PostMapping("/sse/send/{clientId}/{message}")
	public void sendMessage(@PathVariable Integer clientId, @PathVariable String message) throws IOException {
		SseEmitter sseEmitter = sseEmitterMap.get(clientId);
		sseEmitter.send(message);
	}

	/**
	 * 将SseEmitter对象设置成完成
	 *
	 * @param clientId
	 * @return
	 */
	@RequestMapping("/end")
	public void completeSseEmitter(String clientId) {
		SseEmitter sseEmitter = sseEmitterMap.get(clientId);
		sseEmitter.complete();
	}
}
