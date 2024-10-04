
package co.decem.aws_sdk_infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsCredentialsConfig {

    @Value("${aws.creds.aws_access_key_id}")
    private String accessKeyId;

    @Value("${aws.creds.aws_secret_access_key}")
    private String secretAccessKey;

    public String getAccessKeyId() { return accessKeyId; }
    public String getSecretAccessKey() { return secretAccessKey; }
}
