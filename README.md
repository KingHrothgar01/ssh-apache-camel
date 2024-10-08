# ssh-apache-camel

Proof of Concept to integrate **SpringBoot** with **SSH :: Apache Camel**.

## Execution
This POC has two entry points:

1. At Startup camel register a route to open an SSH and execute the command
	**date >> ssh/journal-startup.dat && cat ssh/journal-startup.dat%0A**
	
2. On demand you can call a rest service to execute the command
	**date >> ssh/journal-ondemand.dat && cat ssh/journal-ondemand.dat%0A**
	
	**end-point:** http://*domain:port*/camel/SshProducer/produce

The command above will generate a file inside of **ssh** directory (located inside of the **/home/user/** path) containing the system date and time.

> **Note:** Change the domain and port according to your deployment configuration.

## Authentication

The SSH Component can authenticate against the remote SSH server using one of two mechanisms: Public Key certificate or username/password. 

### Public Key

1. Place your Private and Public Key in **src/main/resources** path.
2. Place your ssh_known_hosts file in **src/main/resources** path.
3. Configure the following camel properties in application.yaml or application.properties file:
	**camel.component.ssh.key-type=**
    **camel.component.ssh.cert-resource**
    **camel.component.ssh.cert-resource-password**
    **camel.component.ssh.known-hosts-resource**

> **Note:** Currently this option is not working ;(