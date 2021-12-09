package io.learning.coffeeshop.error.handler;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GlobalErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
		log.info("Sanitizing error attributes for: {}", request.path());
		Map<String, Object> map = super.getErrorAttributes(request, options);
		// map.put("status", HttpStatus.BAD_REQUEST); we can change the http_status
		// here
		// map.put("message", "Please contact Administrator!");
		return map;

	}

}
