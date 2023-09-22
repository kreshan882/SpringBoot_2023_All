# Getting Started

1) DOCKER CONF
	1.1) docker --version
	1.2) docker-compose --version
	1.3) Start Docker Desktop

2) build & Up [locally container create and run ]
	2.1) docker-compose -f D:\PROJECTS_K\SPRINGBOOT_2023_All_GIT\SPRINGBOOT_2023_All\SpringBoot_2023_All\S6_SpringLearn_CloudeDeploy\docker-compose.yml up -d --build
	2.2) docker-compose images
			java 17 + app Showing			
	2.3) http://localhost:8081/home  ----> locally run success


3) UPLOAD to DOCKER HUB [https://hub.docker.com/ --> REPOSITERY]
	3.1) docker login -u kreshan882@gmail.com -p Password#1
	----3.2) docker-compose push 
	3.2) docker-compose -f D:\PROJECTS_K\SPRINGBOOT_2023_All_GIT\SPRINGBOOT_2023_All\SpringBoot_2023_All\S6_SpringLearn_CloudeDeploy\docker-compose.yml push
	


4) DOCKER TEST WITH PLAYGROUND [https://labs.play-with-docker.com/ ] ????????????????????
	1) login -> start
	2) pwd -----> root/    upload docker-compose.yml (drage and drop C:\Users\KRESHAN88\Desktop\Dockertest\COMPOSE_YML_TEST]docker-compose.yml)
	3) pull & up the service								
		ls ----> docker-compose.yml
		docker-compose pull  ---> download all
		docker images
		docker-compose up -d 
		docker-compose ps   ----> runing port 1234 /1235

