# **Tugas Besar Pemrograman Berorientasi Objek (PBO)** 
Tubes yang kami buat mengusung tema website quiz yang menerapkan konsep gabungan dari web quiz yang sudah ada yaitu LMS, Quizziz, dan Schoology. Sistem ini dikembangkan dengan bahasa pemrograman Java yang menggunakan framework Spring Boot, Spring Data JPA, Thymeleaf Template Engine dan Bootstrap.

## Requirement

Ada beberapa requirement yang diperlukan untuk menjalankan sistem QuiZZila ini:
  1. Download [MySQL](https://dev.mysql.com/downloads/mysql/) dan [XAMPP](https://www.apachefriends.org/download.html).
  3. Disarankan menggunakan code editor [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows) atau [Visual Studio Code](https://code.visualstudio.com/download).
  4. Jika ingin run application, pada file [application.properties](QuiZZilaFix/src/main/resources/application.properties)
seusaikan nama server, database, user, dan password pada XAMPP admin anda.
  
 ![image](https://github.com/SuryaaAulia/OOP-TUBES/assets/120304394/771cb3f5-a384-4583-84d7-a0af1e5f304e)

  ```java
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/quizzila
spring.datasource.username=root
spring.datasource.password=
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.datasource.initialization-mode=always
  ```

To-do:
  1. Menghitung nilai dari hasil jawaban.
  2. Login.
  3. Fitur tambah pertanyaan dan custom jumlah pertanyaan yang tersedia jika user melakukan login.
  4. Timer untuk setiap pengerjaan quiz.

