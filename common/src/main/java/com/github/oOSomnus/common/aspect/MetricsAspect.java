package com.github.oOSomnus.common.aspect;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricsAspect {
    private final MeterRegistry registry;
    private Timer requestTimer;
    private Counter requestCounter;

    @Value("${spring.application.name:unknown-service}") // 添加默认值
    private String serviceName;

    // 注入 MeterRegistry
    public MetricsAspect(MeterRegistry registry) {
        this.registry = registry;
    }

    @PostConstruct
    public void initMetrics() {
        // 确保 serviceName 和 registry 已初始化
        requestTimer = Timer.builder(serviceName + ".http.requests")
                .description("HTTP request duration")
                .register(registry);
        requestCounter = Counter.builder(serviceName + ".http.requests.total")
                .description("Total amount of HTTP requests")
                .register(registry);
    }

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object trackRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        requestCounter.increment();
        return requestTimer.record(() -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                // 记录异常（可选）
                throw new RuntimeException(e);
            }
        });
    }
}