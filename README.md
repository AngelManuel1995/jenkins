# jenkins
1. Create a image with the docker file Dockerfile_jenkins_docker called jenkins-docker: (docker build -t deleteme -f Dockerfile_jenkins_docker .)
2. Execute docker-compose up -d
3. Jenkins trabaja con los recursos de la máquina donde está instalado.

###### Jobs:
1. ¿What is a Job?: It's the most importat unite of jenkins.
2. Options when creating a job.
	- We can select this option - Discard old builds to set how many job we want to have.
	- Source code Management: We can use our repositories.
	- We can paramateriz the project with a kind of environment varibles we can access writing the job definition.
	- Build triggers: Here we can define where we want the jon runs. even if we want a new job runs after other is done (Build before other proects are built).
	- Build envarionment: A good practice here it's to select - delete workspace before build starts. Another good option is - Abort the build if it's stuck and select: absolute and select the time. and we can also select the option of - add timestamo to the console output.

###### Plugins:
1. Docker Pipeline: Permite administrar contenedores de docker
n. Adding nodes to jenkins:
	- Management jenkins - management nodes - new node - type the name and select (Permanent Agent).
	- Some of those job we are going to work with.
		- NodeJS: Allow us to run node commands - we can configure node in: Management Jenkins - Global tools configuration - and add NodeJS and type de name. it can be the version we want to install. 
			- To use NodeJs Plugin in a free project we have select the option Provide Node & npm bin/ folder to PATH in environment execution section and select the version we want to use.
		- CloudBees Docker build and publish plugin: It allows us to so it allows to build and publish images. (Configurar correctamente los permisos de usuario jenkins en el grupo de docker para que se pueda conectar con el socket que permite la conexión a la API)
		-

###### Nodos:
1. A jenkins node is a server we can manager with a jenkins agent. Step to set up a jenkins node.
	- via ssh:
	- We need to generata a private and public ssh key, and we can do it running the next command in the master node: ssh-keygen -f key_name - [ ssh-keygen -f mypubkey ].
	- Let's type intro and it's going to ask for Enter passphrase (empty for no passphrase) and Enter same passphrase again. Just hit intro.
	- Now we have two new files: mypubkey.pub (Public key) and mypubkey (Private key - no shared).
	- Now in Jenkins we can go to the next option: Manager jenkins - Manager nodes - new nodo and let's type the node name and let's check Permanent Agent and click ok.
	-	Now we have to configure the slave-node.
	-	We have to say we are going to access to this node via ssh with de public key
	-	After that we must configure the agen in the node with the script that is in this repo called (configuration_jenkins_node_file.sh)
	-	Now we have to run this commant to validate the connection between nodes. ssh-keyscan -p aget-port-is-published server-ip
	-	Now we have to to add this scan to the /var/jenkins_home/.ssh/known-hosts with this command: ssh-keyscan -p aget-port-is-published server-ip >> /var/jenkins_home/.ssh/known-hosts
	-	Now en Jenkins let's finish of filling in the form of node creation.
	-	Let's set Number of executors: 2
	-	Remote root directory: /var/jenkins_home
	-	Labels: a label we can identify it with
	- Execution method: 
		- Nombre de máquina: server-ip where we are going to install the agent.
		-	Credentials: If we don't have a credential yet we are going to set it up
		-	Click in Add - Kind: SSH Username with a private key - ID: Name of the credentia, any name we want - Description: Option - Private Key: We have to select Enter Directory and pase the private key.
		-	Let's type the username and click on save

###### User management.
1. We can manager users in the jenkins management - user management. [ Estudiar más a profundidad. ]

###### Validar usos de SSH Agent plug in

###### Instalation jenkins as a service
1. The first thing we have to do is get the server updated.
2. Then we hace to istall the next packages apt-get install openjdk-8-jdk wget gnupg.
3. Let's add the repository: wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
4. Let's add the repo address: sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
5. Now we have to update de packages: apt update.
6. After that we have to install jenkins: apt install jenkins
7. We have to start the jenkins service: systemctl start jenkins and check the status: systemctl status jenkins
8. Allow the firewall access: ufw allow 8080 - ufw enable

###### CI (Continuos integreation):
1. The CI is the software enginer practice that allow us to make integrations coutinuosly and frecuenly so then we can detect bugs as soon as posible.


