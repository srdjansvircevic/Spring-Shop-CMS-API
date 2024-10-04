
package co.decem.aws_sdk_infra.command;


import co.decem.aws_sdk_infra.config.Ec2Config;
import co.decem.aws_sdk_infra.service.Ec2Service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Ec2Commands {

    private final Ec2Service ec2Service;
    private final Ec2Config ec2Config;

    public Ec2Commands(Ec2Service ec2Service, Ec2Config ec2Config) {
        this.ec2Service = ec2Service;
        this.ec2Config = ec2Config;
    }

    @ShellMethod("Launch an EC2 instance with config-based details.")
    public String launchEc2Instance() {
        String instanceId = ec2Service.createEc2InstanceWithConfig();
        return "EC2 instance launched with ID: " + instanceId + " in region: " + ec2Config.getRegion();
    }
}
