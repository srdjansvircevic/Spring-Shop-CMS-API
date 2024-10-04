
package co.decem.aws_sdk_infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aws.ec2")
public class Ec2Config {

    private String amiId;
    private String instanceType;
    private String region;
    private String securityGroup;
    private int volumeSize;
    private String keyName;

    // Getters and Setters
    public String getAmiId() { return amiId; }
    public void setAmiId(String amiId) { this.amiId = amiId; }
    public String getInstanceType() { return instanceType; }
    public void setInstanceType(String instanceType) { this.instanceType = instanceType; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getSecurityGroup() { return securityGroup; }
    public void setSecurityGroup(String securityGroup) { this.securityGroup = securityGroup; }
    public int getVolumeSize() { return volumeSize; }
    public void setVolumeSize(int volumeSize) { this.volumeSize = volumeSize; }
    public String getKeyName() { return keyName; }
    public void setKeyName(String keyName) { this.keyName = keyName; }
}
