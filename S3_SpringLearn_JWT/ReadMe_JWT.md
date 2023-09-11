# Getting Started
https://www.youtube.com/watch?v=lA18U8dGKF8&t=21s

1) Versions
	Java- 1.8
	Spring -2.3.4.RELEASE
	
2) header  -- algorithen
   payload body - user details
   signature - server authondication
   
   
2) Codeing 
		login with DB user --[3-12]
	

3) testing (not working 0- 12 min)-------?????????????????
		3.1) login  with our db username & password
			http://localhost:8083/
			UN: kreshan
			PW: password
			
	    3.2) Postman (token not generated)-----??????
	    	3.2.1) GENERETE TOKEN
		    	post http://localhost:8084/authenticate
		    	Body -> row-> json
		    		{
					    "username":"admin",
					    "password":"password"
					}
					
				RESPONCE : *****JWT_TOKEN*******
		
			3.2.2) VALIDATE token
					GET http://localhost:8084/
					Header
						Authorization : Bearer *****JWT_TOKEN*******
						
					RESPONCE: Access success
