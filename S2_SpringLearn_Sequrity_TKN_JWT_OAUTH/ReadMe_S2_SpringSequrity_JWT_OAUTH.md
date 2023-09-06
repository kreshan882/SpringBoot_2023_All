Video: https://www.youtube.com/watch?v=tWcqSIQr6Ks&t=4661s  [2.38 min]
1) token based Authondication [0-1.30)
	1) project startup [0 - 8 Min]
	
	2) User Registeration [Min 13 -- 20]
			2.1) register(with user details) 
			2.2) store data with encoded password(@EnableWebSecurity)--> WebSecurityConfig.java) :::: BCryptPasswordEncoder(11);--> encoded lenthe change
			2.3) send email link to activate the account ( create event to create tocken & send email) [min 20-- 28.....]
						2.3.1) create TOKEN and stored in  the Db [min 20-- 33]
						
						2.3.2) send the link with tocken to varification
						
						2.3.3) http://localhost:8082/register
							{
							    "email":"kre@hhh.com",
							    "firstName":"rajjj",
							    "lastName":"kreeeee",
							    "password":"passsword"
							}
							Not working : after white list /register ????????????????????????????????????????????
					
2) oAuth (1.30- 2.30)




3) JWT - not avaliable					
					
					
					
		

		