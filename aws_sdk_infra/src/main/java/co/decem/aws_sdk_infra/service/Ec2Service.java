package co.decem.aws_sdk_infra.service;

import co.decem.aws_sdk_infra.config.Ec2Config;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.SendCommandRequest;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class Ec2Service {

    private final Ec2Client ec2Client;
    private final SsmClient ssmClient;
    private final Ec2Config ec2Config;

    public Ec2Service(Ec2Client ec2Client, SsmClient ssmClient, Ec2Config ec2Config) {
        this.ec2Client = ec2Client;
        this.ssmClient = ssmClient;
        this.ec2Config = ec2Config;
    }

    public String createEc2InstanceWithConfig() {
        String userDataScript = "#!/bin/bash\nsudo yum update -y\necho Hello World > /var/tmp/helloworld.txt\n";
        String userData = Base64.getEncoder().encodeToString(userDataScript.getBytes());

        RunInstancesRequest runInstancesRequest = RunInstancesRequest.builder()
            .imageId(ec2Config.getAmiId())
            .instanceType(InstanceType.fromValue(ec2Config.getInstanceType()))
            .minCount(1)
            .maxCount(1)
            .securityGroupIds(ec2Config.getSecurityGroup())
            .keyName(ec2Config.getKeyName())
            .blockDeviceMappings(BlockDeviceMapping.builder()
                .deviceName("/dev/xvda")
                .ebs(EbsBlockDevice.builder()
                    .volumeSize(ec2Config.getVolumeSize())
                    .build())
                .build())
            .userData(userData)
            .build();

        RunInstancesResponse response = ec2Client.runInstances(runInstancesRequest);
        return response.instances().get(0).instanceId();
    }

    public void runCommandOnEc2(String instanceId, String command) {
        SendCommandRequest commandRequest = SendCommandRequest.builder()
            .instanceIds(instanceId)
            .documentName("AWS-RunShellScript")
            .parameters(Map.of("commands", List.of(command)))
            .build();

        ssmClient.sendCommand(commandRequest);
    }
}
