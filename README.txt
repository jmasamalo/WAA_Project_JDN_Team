1. Create a new empty database named "jdn" in MySQL.
2. Modify the url, username, and password to connect to MySQL if necessary: WEB-INF/config/persistence-config.xml
3. Run the application.

4.Demo accounts

Username: admin@mum.edu 	/password:admin
Username: doctor@mum.edu	/password:doctor
Username: receptionist@mum.edu   /password:receptionist
Username: patient@mum.edu	/password:patient

5. To have image upload functionality working properly, you have to
make changes the image path in two controller and messages.property
eg: change the below path

upload.location=C:\\Users\\Niroj\\Desktop\\WAA_Project_JDN_Team\\clinic-appointment-system\\src\\main\\webapp\\resources\\images\\
 in messages.property and set it as your path where images folder is located

same goes for the DoctorController and ReceptionistController
and  please refresh the image folder before viewing the profile. only one time refresh is enough to see the profile
it is saved forever unless you delete the image.