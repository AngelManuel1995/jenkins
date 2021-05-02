# jenkins
1. Create a image with the docker file Dockerfile_jenkins_docker called jenkins-docker: (docker build -t deleteme -f Dockerfile_jenkins_docker .)
2. Execute docker-compose up -d


Plugins:
1. Docker Pipeline: Permite administrar contenedores de docker
n. Adding nodes to jenkins:
	- Management jenkins - management nodes - new node - type the name and select (Permanent Agent)

Nodos:
1. A jenkins node is a server we can manager with a jenkins agent. Step to set up a jenkins node.
	- via ssh:
	- We need to generata a private and public ssh key, and we can do it running the next command: ssh-keygen -f key_name - [ ssh-keygen -f mypubkey ].
	- Let's hit intro and it's going to ask for Enter passphrase (empty for no passphrase) and Enter same passphrase again. Just hit intro.
	- Now we have two new files: mypubkey.pub (Public key) and mypubkey (Private key - no shared).
	- Now in Jenkins we can go to the next option: Manager jenkins - Manager nodes - new nodo and let's type the node name and let's check Permanent Agent and click ok.
	-	Now we have to configure the slave-node.
	-	We have to say we are going to access to this node via ssh with de public key
	-	After that we must configure the agen in the node with the script that is in this repo called (configuration_jenkins_node_file.sh)
	-	Now we have to run this commant to validate the connection between nodes. ssh-keyscan -p aget-port-is-published server-ip
	-	Now we have to to add this scan to the /var/jenkins-file/.ssh/known-hosts with this command: ssh-keyscan -p aget-port-is-published server-ip >> /var/jenkins-file/.ssh/known-hosts
	-	Now en Jenkins let's finish of filling in the form of node creation.
	-	Let's set Number of executors: 2
	-	Remote root directory: /var/jenkins_home
	-	Labels: a label we can identify it with
	- Execution method: 
		- Nombre de máquina: server-ip where we are going to install the agent.
		-	Credentials: If we don't have a credential yet we are going to set it up
		-	Click in Add - Kind: SSH Username with a private key - ID: Name of the credentia, any name we want - Description: Option - Private Key: We have to select Enter Directory and pase the private key.
		-	Let's type the username and click on save
