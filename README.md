# Escuela Colombiana de Ingeniería Julio Garavito

# Funciones matemáticas

#### Autor🙎
> - María Angélica Alfaro Fandiño

#### 🔎 Descripción
Construcción de dos servicios de funciones matemáticas (cos y exp) usando Spark y un contenedor Docker, desplegados en una instancia EC2 de AWS.

## ⚙️ Descargar el proyecto
1. Para clonar el proyecto use el comando:
    ```sh
    git clone https://github.com/Angelica-Alfaro/AREP_PARCIAL2.git
    ```
  
2. Dentro del cmd ubicado en el directorio del proyecto, ejecute:
     ```sh
    mvn clean install
    java -cp "target/classes;target/dependency/*" edu.escuelaing.arep.App
    ```
  
  ***Nota:*** Si el equipo en donde va a correr el proyecto tiene OS Linux debe cambiar el **;** por **:**
  
 3. Ingrese a su browser de preferencia y ponga cualquiera de las siguientes rutas:
    ```sh
    http://localhost:4567/exp?value=3.456
    http://localhost:4567/cos?value=3.456 
    ```
  
## 💡 Correrlo en EC2 de AWS
1. Para el despliegue en aws, debemos tener previamente instalada una máquina virtual EC2 y los contenedores subidos en un repositorio de DockerHub. 
    Ejecutamos los siguientes comandos para actualizar la máquina e instalar docker:
    ```sh
    sudo yum update -y
    sudo yum install docker
    ```

2. Iniciamos el servicio de docker y configuramos nuestro usuario en el grupo de docker para no tener que ingresar “sudo” cada vez que se invoca un comando: **
    ```sh
    sudo service docker start
    sudo usermod -a -G docker ec2-user
    ```
    ***Nota:*** Debemos desconectamos de la máquina e ingresar nuevamente para que la configuración de grupos de usuarios tenga efecto.
    
3.  A partir de la imagen creada en Dockerhub cree una instancia de un contenedor docker independiente de la consola (opción “-d”) y con el puerto 6000 enlazado a un puerto         físico de su máquina (opción -p)
    ```sh
    docker run -d -p 46000:6000 --name mathfunction angelicaalfaro/mathfunction
    ```

4. Abra los puertos de entrada del security group de la máquina virtual para acceder al servicio.

5. A través del browser de preferencia será posible acceder a los servicios con el DNS público de la máquina virtual y el puerto en donde corre el servicio.

## 🛠️ Arquitectura

El proyecto está compuesto por:

  - Dos endpoints de funciones matemáticas:
       
     📌 ***(GET)*** /exp. Permite obtener el ex, donde e hace referencia al número de Euler y x es el número dado como parámetro, retorna el resultado en formato JSON.
     
     📌 ***(GET)*** /cos. Permite obtener el coseno de un número dado como parámetro y retorna el resultado en formato JSON.

## 📝 Evidencia
### Instancia EC2 de AWS
<!DOCTYPE html>
<html>
    <head></head>
    <body>
          <img src="https://github.com/Angelica-Alfaro/AREP_PARCIAL2/blob/master/img/aws.PNG" width="800"/>
    </body>
</html>

### Función exp
<!DOCTYPE html>
<html>
    <head></head>
    <body>
          <img src="https://github.com/Angelica-Alfaro/AREP_PARCIAL2/blob/master/img/exp.PNG"/>
    </body>
</html>

### Función cos
<!DOCTYPE html>
<html>
    <head></head>
    <body>
          <img src="https://github.com/Angelica-Alfaro/AREP_PARCIAL2/blob/master/img/cos.PNG"/>
    </body>
</html>

### Control de errores
<!DOCTYPE html>
<html>
    <head></head>
    <body>
          <img src="https://github.com/Angelica-Alfaro/AREP_PARCIAL2/blob/master/img/sinParametro.PNG"/>
    </body>
</html>
<!DOCTYPE html>
<html>
    <head></head>
    <body>
          <img src="https://github.com/Angelica-Alfaro/AREP_PARCIAL2/blob/master/img/SinParametroExp.PNG"/>
    </body>
</html>

### Video expermiental
[Demostración de lo realizado en AWS](https://github.com/Angelica-Alfaro/AREP_PARCIAL2/blob/master/DemoParcial.mp4)


