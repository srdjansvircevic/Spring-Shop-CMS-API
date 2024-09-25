package co.decem.config;

import io.sentry.spring.jakarta.EnableSentry;
import org.springframework.context.annotation.Configuration;

@EnableSentry(dsn = "https://f3f429c5ee1fce2cc9ff742740d47720@o4507974110085120.ingest.de.sentry.io/4507974111920208")
@Configuration
class SentryConfiguration {
}