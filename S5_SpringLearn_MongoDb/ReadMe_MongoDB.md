DCB ===> https://www.youtube.com/watch?v=vl6DstgPoW8

1) Store in 
		JSON (Doc format) (Scalable)
		NO_SQL DB
		EnableSwagger2 ----> Rest API GUI
		
3) DB Structure
		Table - Collection
		row  - Documnet
		colum  - Fileds
			
4) create (spring web+ mongoDb+ labbok)


5) INSTALL MongoDB
		---- 5.1) Docker install (start Docker desttop app) --- can use, not not used localy
				cmd
				>>docker run -d --name mongodb -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password -p 27017:27017 mongo [container|un|pd|image]
				>> docker run -d --name mongodbkc -e MONGO_INITDB_ROOT_USERNAME=mongodbku -e MONGO_INITDB_ROOT_PASSWORD=password -p 27018:27018 mongo
				
				>> docker images
				>> docker ps  [Docker Desktop --> image -> monge -> run ]
				
					
		---- 5.2) Cloude DB - need to pay
				MongoDB Atlas Database
				Can Create in [AWS | Google Cloude | Azure ]
		
		5.3) Download And install in locall ----> INSTALL DB SUCCESS
				5.3.1) https://www.mongodb.com/try/download/community   ---> install mongo db+ commpass
				
				5.3.2) https://www.mongodb.com/try/download/compass     ---> mongo db compass is GUI  ----> SUCESS
				
				5.3.3) https://www.mongodb.com/try/download/shell       ---> shell
						cd C:\PORTABLE_K\MONGO_SHELL_mongosh-1.10.6-win32-x64\bin\
						run mongosh.exe
						>> mongodb://kreshan:password@127.0.0.1:27017/?authSource=admin
						>> json Script
			
		
		5.4) GUI DB TOOL for Mondo DB [Min5] -  success
			Studio 3T [ https://studio3t.com/download/  ]
			Connection 
				Server 127.0.l0.1 27017
				Authondication ==> Basic| kreshan| password | db:admin   ---> connection success 
					
				URL: mongodb://admin:password@127.0.0.1:27017/?authSource=admin   
	

6) MONGO DB AUTH SCRIPT [run in Studio 3T]
		6.1) new user create  [ 3T-> intellShell-> run]
		-----------------------------------------------------------------
		   mongo
			use admin
			db.createUser(
			 {
			     user: "kreshan",
			     pwd: "password",
			     roles: [
			           { role: "userAdminAnyDatabase", db: "admin" },
			           { role: "readWriteAnyDatabase", db: "admin" }
			        ]
			 })
	  -----------------------------------------------------------------
	
7) CODEING 	[Min 10 ---]
		Regular Code 
			1) controller
			2) Service
			3) MongoRepository
			4) Entity --> @Document			
			5) SWAGGER-UI  --> API GUI
					5.1) pom (springfox + springfox-swagger-ui)
					5.2) SpringApplication  add @EnableSwagger2
					5.3) proporty
					5.4) Congiguration -> Andd Bean
					5.5) URL ========> http://localhost:8080/swagger-ui/  (no need postman)
							5.5.1) RUN 
									swagger-ui URL -> click function -> TryItOut -> (prepair data) -> Execute
	
			6) Functions
					1) save
					2) getPersonStartWith()
					3) getByPersonAge(min,max) --> @Query JPQL-mongo
					4) Pagenation [34-47]
							interview (core.Query + List<Criteria> criteria) avaliable hear............. :(  now success
							
					5.1) Aggregation| Group by[47--56]
						-->olderest persion in each city (group by function) | return Json [Document]
								Aggregation
									UnwindOperation
									SortOperation
									GroupOperation
								List<Document> person = mongoTemplate.aggregate(aggregation, Person.class,Document.class).getMappedResults();
								
								
					5.2) Aggregation| Group by[56-1.04]
								Aggregation
									UnwindOperation
									SortOperation
									GroupOperation
									ProjectionOperation
					

			7) IMAGE STORE ---[1.04-1.17]
					http://localhost:8080/swagger-ui/
					
					[POSTMAN]
					7.1) addPhoto POST http://localhost:8080/photo/
							post -> url -> body => form-data -> Key:image & type:File| select photo
							6505919f2e6bcf21d208a543
					
					7.2) downloadPhoto 
							POSTMAN ==> GET http://localhost:8080/photo/6505919f2e6bcf21d208a543
							SWIGGER-UI ==> id: 6505919f2e6bcf21d208a543 ---> execute -> download
							

################################## COMPLETED DONE #############################################################################


================================================
NodeJs
Express.js
https://www.youtube.com/watch?v=ZfzGquJLCAA&t=0s

51 min
done -> 3 min/ 8 min / done
================================================		

	
	




