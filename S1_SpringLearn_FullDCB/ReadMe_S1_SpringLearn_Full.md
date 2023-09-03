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

10) hibernate validation [Min 1.30...
	


	




		
		
		
