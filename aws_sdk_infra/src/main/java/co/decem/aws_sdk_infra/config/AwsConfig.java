package co.decem.aws_sdk_infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ssm.SsmClient;

@Configuration
public class AwsConfig {

    private final co.decem.aws_sdk_infra.config.Ec2Config ec2Config;
    private final AwsCredentialsConfig awsCredentialsConfig;

    public AwsConfig(co.decem.aws_sdk_infra.config.Ec2Config ec2Config, AwsCredentialsConfig awsCredentialsConfig) {
        this.ec2Config = ec2Config;
        this.awsCredentialsConfig = awsCredentialsConfig;
    }

    @Bean
    public Ec2Client ec2Client() {
        return Ec2Client.builder()
            .region(Region.of(ec2Config.getRegion()))
            .credentialsProvider(StaticCredentialsProvider.create(
                AwsBasicCredentials.create(
                    awsCredentialsConfig.getAccessKeyId(),
                    awsCredentialsConfig.getSecretAccessKey()
                )
            ))
            .build();
    }

    @Bean
    public SsmClient ssmClient() {
        return SsmClient.builder()
            .region(Region.of(ec2Config.getRegion()))
            .credentialsProvider(StaticCredentialsProvider.create(
                AwsBasicCredentials.create(
                    awsCredentialsConfig.getAccessKeyId(),
                    awsCredentialsConfig.getSecretAccessKey()
                )
            ))
            .build();
    }
}
