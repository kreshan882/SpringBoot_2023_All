# GIT UPLOAD TO SPRINGBOOT

1) Upload to GIT
cd D:\1_JAVA_SPRINGBOOT_K
git init
	git add ReadMeGitUoload.txt .gitignore (when new project come) 
	git add SpringLearn_JPA/ 
	git add SpringLearn_MongoDb/ 
	git add SpringLearn_Docker-JAR/ 
	git add S1_SpringLearn_FullDCB/ 
	git add S2_SpringLearn_Sequrity_TKN_OAUTH/
	git add S3_SpringLearn_JWT/
	
git commit -m "commit 1"AS
git branch -M main
git remote add origin https://github.com/kreshan882/SpringBoot_2023_All.git
git push -u origin main


2) PULL
    git pull https://github.com/kreshan882/SpringBoot_2023_All.git





==============================
revert local changes
==============================
cd D:\1_JAVA_SPRINGBOOT_K
git reset --hard