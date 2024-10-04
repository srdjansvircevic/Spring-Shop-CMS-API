package co.decem.aws_sdk_infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("external-api")
public class ExternalApiConfig {

    private String uri;
    private String apiKey;


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
