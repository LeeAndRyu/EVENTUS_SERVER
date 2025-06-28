package com.hsryuuu.eventus;

import com.hsryuuu.eventus.appllication.security.SecurityUtils;
import com.hsryuuu.eventus.appllication.security.principal.AuthPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "TEST API")
@RequiredArgsConstructor
@RequestMapping("/api/test")
@RestController
public class TestController {

    private final Environment env;
    private final TestService testService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "현재 서버 properties")
    @GetMapping("/properties")
    public Map<String, Object> test() {
        Map<String, Object> response = new LinkedHashMap<>();

        List<String> profiles = Arrays.stream(env.getActiveProfiles()).toList();
        Map<String, Object> basicProperties = new LinkedHashMap<>();
        basicProperties.put("PROFILE", profiles);
        basicProperties.put("APP_NAME", env.getProperty("spring.application.name"));
        basicProperties.put("SWAGGER", env.getProperty("springdoc.swagger-ui.path") + "/index.html");

        Map<String, Object> secureProperties = new LinkedHashMap<>();
        secureProperties.put("DATASOURCE_URL", env.getProperty("spring.datasource.url"));
        secureProperties.put("DATASOURCE_USERNAME", env.getProperty("spring.datasource.username"));
        secureProperties.put("DATASOURCE_PASSWORD", env.getProperty("spring.datasource.password"));
        secureProperties.put("REDIS_HOST", env.getProperty("spring.data.redis.host"));
        secureProperties.put("REDIS_PORT", env.getProperty("spring.data.redis.port"));

        response.put("basic", basicProperties);

        if (!profiles.contains("prod")) {
            response.put("secure", secureProperties);
        }

        return response;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "현재 인증 유저 정보")
    @GetMapping("/current-user")
    public AuthPrincipal currentUser() {
        return SecurityUtils.getCurrentUser();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "이벤트 관련 전체 삭제")
    @DeleteMapping("/delete-event")
    public void deleteEvent() {
        testService.deleteAllEvents();
    }

}
