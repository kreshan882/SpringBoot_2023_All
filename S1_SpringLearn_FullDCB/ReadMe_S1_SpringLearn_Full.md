========> learn spring Boot  [3.11 hours]
https://www.youtube.com/watch?v=c3gKseNAs9w&t=7399s

1) Spring Framework --> more configuration on(hibernet, message Queue, need app server to deploy....)
2) Spring boot   ---> 	emberded Application server 
						Spring (JPA, CORE,WEB,JDBC,TEST(jUnit/MOKITO testing)) 
						with less configuration app is ready to deploy
						developrt need to consider only bussiness logic, not the configuration
						Rapid Application Developemtn-> create and deploy very fast
						Auto configuration (Eg: When JPA pom Addedd , then we can use use JPA)
						microservice - spring boot is default 
						
					  
3) IOC(Inversion of control) = dependinct injection ,control given to Spring framework	(it is inside spring RADAR control)	

4) Dependinct Injection- (Sprong Boot create Bean Factory) | all the bean store in spring container			  
					  

5) START APPLICATION [Min 10.00..........]
		project generate [ https://start.spring.io/ ]
		open project in STS 4.0.0  [Min 20....................................]
		dependency(spring-boot-starter-web) Auto loaded ==> tomcat+ json+spring web mvc
		dependency(spring-boot-starter-test) Auto loaded ==> json-path+ autoconfigure+ jakarta+ junit + mockito-core+ spring-core ....
		
		Explanation given 
		min 27...

6) Can run in terminal manuwaly [ min 34]
	cd D:\1_JAVA_SPRINGBOOT_K\S1_SpringLearn_FullDCB
	mvn spring-boot:run
	
   How to run in production?????
   
7) AUTO BUILD & RUN ,when code change
	DEPENDENCY: Spring Boot DevTools
	STS--> project --> select build automaticaly
	
	
8) Min-45- done .................
	http://localhost:8082/departments   ====> POST
		{
			"departmentName":"ucsc",
			"departmentAddress":"colombo",
			"departmentCode":"001"
		}
		
9) RequstController--> add/viewById/viewAll/update/delete / ViewByName min 59- 1.30
   DB data: JPA with methon nane --> JPQL ---> Native Query

10) hibernate validation [Min 1.30...]
		spring-boot-starter-validation --> hibernate-validator
		
11) Logger add	
		sla4j ---> spring default logger
		log4j ---> can add libeary
		
12) Exception Handeling [1.48 Min-1.59 done]
		new 
			ErrorMessage
			error/DepartmentNotFoundException
			error/RestResponseEntityExceptionHandler
			
		modified
			DepartmentServiceImpl
			DepartmentService
			DepartmentController


13) h2-> mysql (proporty file & libeary change only)

14) junit-jupiter(5) & mockito-junit-jupiter testing [2.05--2.20] ----> success 
		14.1) integration TEST ( end to end , all 3 layer) 
		
		14.2) unit testing( service/ repositery / controler seperately
				MOCKING: only test controler layer [not service layer | mocking the service layer]
				
				14.2.1) Test service layer 
					Testing --> DepartmentService
					Mock --> DepartmentRepository
					
				14.2.2) Test Repo layer [min 2.20] 
				
				14.2.3) Test Control Layer [2.28- 2.38 ]
				
15) read conf file data from java code

16) CONVERT TO YML file [2.41]  =====> https://mageddo.com/tools/yaml-converter 
	more human redable + remove duplicate value
	application.proporty ---> application.YML
	
17) SpringBoot Profile (in YML file)
		Dev
		QA
		PROD
18) BUILD the project & RUN with profile
		cd D:\1_JAVA_SPRINGBOOT_K\S1_SpringLearn_FullDCB
		mvn clean install
		java -jar target/S1_SpringLearn_FullDCB_K-1.0.1.jar --some.profiles.active=PROD
		
19) ACTUATOR (view and block spring main modules ex:beans, schadulers...) [2.55]
		helthi
		beans
		schaduler
		
		Monitor PATH: http://127.0.0.1:8082/actuator
			END POINTS 
				1) helth up [default enabled] 
				2) info 
				3) loggers
				4) schadule task
				5) env
				
			Enable all end POINTS
				Update yml file

20) create NEW ENDPOINT [3.02]
		create new calss --> MyEndpoint_Actuvator_k 	
		CHECk new end POINTS
			http://127.0.0.1:8082/actuator/features
			http://127.0.0.1:8082/actuator/features/Department
			http://127.0.0.1:8082/actuator/features/User

		
		
########################################### End Completed ##################################################
		

	




		
		
		
