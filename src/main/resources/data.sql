insert into Rutina(id,nombre,nivel)VALUES(1,'ESPALDA/BICEPS',1);
insert into Rutina(id,nombre,nivel)VALUES(2,'ESPALDA/BICEPS',2);
insert into Rutina(id,nombre,nivel)VALUES(3,'ESPALDA/BICEPS',3);
insert into Rutina(id,nombre,nivel)VALUES(4,'PECHO/HOMBRO',1);
insert into Rutina(id,nombre,nivel)VALUES(5,'PECHO/HOMBRO',2);
insert into Rutina(id,nombre,nivel)VALUES(6,'PECHO/HOMBRO',3);
insert into Rutina(id,nombre,nivel)VALUES(7,'PIERNA',1);
insert into Rutina(id,nombre,nivel)VALUES(8,'PIERNA',2);
insert into Rutina(id,nombre,nivel)VALUES(9,'PIERNA',3);
insert into Rutina(id,nombre,nivel)VALUES(10,'GLUTEO',1);
insert into Rutina(id,nombre,nivel)VALUES(11,'GLUTEO',2);
insert into Rutina(id,nombre,nivel)VALUES(12,'GLUTEO',3);

-- EJERCICIOS ESPALDA
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(1,'Jalon al Pecho','Espalda',4,12,'Será necesario elegir un buen agarre, agarrar la barra con una postura cómoda, asegurar las piernas con las almohadillas para no levantarnos y tirar de la barra hasta llevarla al pecho directamente.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(2,'Remo Gironda','Espalda',4,10,'Elegir un buen agarre, sentarse en el banco apoyando los pies bien en la plataforma y tirar del agarre con los hombros cerrados y la espalda recta hasta llevar el agarre a la zona abdominal.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(3,'Jalon en Maquina','Espalda',4,12,'Agarrar los brazos de la máquina de forma estable y cargar la máquina con un peso asumible para hacer bien el ejercicio. Tirar del brazo de la máquina hasta abajo y subir lentamente.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(4,'Remo en Maquina','Espalda',4,10,'Sentarse en el banco apoyando los pies bien en el suelo y el pecho al apoyo. Cargar la máquina con un peso asumible. Tirar del brazo de la máquina hasta la altura de tu pecho y dejarla caer controlando la caída.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(5,'Remo con Mancuerna','Espalda',4,10,'Apoyarse con la pierna en un banco y coger una mancuerna que podamos manejar. Tirar de la pesa hacia arriba hasta llegar a la altura de las abdominales y bajar lentamente.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(6,'Remo con Barra','Espalda',3,12,'Coger una barra y cargarla con un peso capaz de levantarla sin problemas. Ponte de pie, con la espalda recta agarrar la barra y llevarla hasta la zona abdominal y bajar lentamente.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(7,'Dominadas Asistidas','Espalda',4,10,'Coger una cuerda elástica y engancharla a una barra. Agarrarte a la barra y situar los pies dentro de la goma. Subir hasta llevar el pecho a la barra y bajar.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(8,'Dominadas','Espalda',2,8,'Agarrarte a la barra y situar los pies dentro de la goma. Subir hasta llevar el pecho a la barra y bajar.');
-- EJERCICIOS BICEPS
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(9,'Biceps Predicador Polea','Biceps',4,12,'Sentarse apoyando los brazos, coger el agarre con las dos manos, y subir con fuerza y bajar lentamente.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(10,'Biceps Predicador Barra','Biceps',4,10,'Sentarse apoyando los brazos, coger la barra con las dos manos, y subir con fuerza y bajar lentamente.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(11,'Curl de Biceps Martillo','Biceps',4,10,'Coger dos mancuernas del mismo peso que puedas controlar. Agarrar una con cada mano y hacer un movimiento de palanca con cada brazo desde la cintura hasta alcanzar la altura de tu hombro con la mancuerna.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(12,'Curl de Biceps con Barra','Biceps',3,12,'Coger la barra y agarrarla con las dos manos. Hacer un movimiento de palanca con los dos brazos desde la cintura hasta alcanzar la altura de tu pecho con la barra.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(13,'Biceps Polea Baja','Biceps',4,12,'Situarte en una polea baja con un agarre cómodo, agarrarlo con las dos manos y subir el agarre hasta la altura del pecho y bajarlo lentamente.');

-- EJERCICIOS PECHO
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(14,'Press de Pecho','Pecho',4,10,'Siéntate y pon los brazos agarrando los agarres. Empuja hacia delante con fuerza y controla la vuelta hasta llegar a la altura del pecho.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(15,'Fondos de Pecho','Pecho',4,12,'Siéntate y pon los brazos sobre los agarres. Empuja hacia abajo y controla la subida hasta que tus brazos formen noventa grados.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(16,'Press con Mancuernas','Pecho',4,10,'Túmbate en el banco con dos mancuernas que puedas controlar sin problemas. Sujeta las mancuernas sobre tu pecho, empuja hacia arriba y baja hasta la altura del pecho siempre empujar y bajar vertical al pecho.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(17,'Press Inclinado con Mancuernas','Pecho',3,12,'Túmbate en el banco inclinado con dos mancuernas que puedas controlar sin problemas. Sujeta las mancuernas sobre tu pecho, empuja hacia arriba y baja hasta la altura del pecho siempre empujar y bajar vertical al pecho.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(18,'Press Banca','Pecho',3,10,'Túmbate en el banco con una barra. Sujeta la barra sobre tu pecho, empuja hacia arriba y baja hasta la altura del pecho siempre empujar y bajar vertical al pecho.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(19,'Flexiones','Pecho',3,8,'Coger una colchoneta y situar las manos a la misma altura de la anchura de tus hombros. Bajar hasta abajo y subir lentamente.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(20,'Contractora de Pecho','Pecho',4,12,'Siéntate en la máquina y coloca los brazos de la máquina de forma que te sientas cómodo para hacer el ejercicio. Sujeta los brazos y llévalos al frente hasta unirlos y luego separarlos hasta llevarlos a su posición origen.');

-- EJERCICIOS HOMBRO
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(21,'Press Militar Máquina','Hombro',4,10,'Siéntate en la máquina y pon tus manos sobre el agarre más cómodo. Empujar hacia arriba de los agarres verticalmente a tus hombros y bajar lentamente hasta llegar a la fase inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(22,'Press Militar con Mancuerna','Hombro',3,12,'Siéntate en un banco y coge dos mancuernas y situalas sobre tus hombros. Empujar hacia arriba de los agarres verticalmente a tus hombros y bajar lentamente hasta llegar a la fase inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(23,'Aperturas Laterales Máquina','Hombro',4,10,'Siéntate en la máquina situando tus antebrazos por debajo de los brazos de la máquina. Sube los brazos hasta que tus brazos superen un poco la altura de los hombros.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(24,'Aperturas Laterales con Mancuernas','Hombro',3,12,'Sitúate de pie con una mancuerna en cada brazo. Sube los brazos hasta que tus brazos superen un poco la altura de los hombros.');

-- EJERCICIOS PIERNA
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(25,'Press de Pierna','Pierna',4,12,'Siéntate poniendo los pies en la plataforma para empujar a la altura de los hombros. Empuja la plataforma hasta tener casi rectas las piernas. Empujar fuerte y controlar la vuelta.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(26,'Sentadilla Máquina Body Solid','Pierna',4,10,'Sitúa tus trapecios debajo de las almohadillas de la máquina. Empuja hacia arriba para quitar el seguro y baja hasta abajo hasta lograr noventa grados en tus piernas, entonces subes a la posición inicial y pones el seguro.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(27,'Sentadilla con Barra','Pierna',4,8,'Sitúa tus trapecios debajo de la barra y agarrala con las manos a la altura de las marcas de la barra. Baja hasta abajo hasta lograr noventa grados en tus piernas, entonces subes a la posición inicial y pones el seguro.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(28,'Extensión de Cuádriceps','Pierna',4,12,'Siéntate y sitúa los pies por detrás de la almohadilla con la que levantas el peso. Empuja hacia arriba de la barra hasta tener la pierna recta y bajar lentamente hasta la posición inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(29,'Isquiotibiales Máquina','Pierna',4,12,'Siéntate y sitúa los pies por debajo de la almohadilla con la que levantas el peso. Empuja hacia arriba de la barra hasta tener la almohadilla sobre la altura de los  glúteos y bajar lentamente hasta la posición inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(30,'Elevación de Gemelo Máquina Sentado','Pierna',4,10,'Siéntate y sitúa tus cuádriceps por debajo de las almohadillas y los pies en las plataformas de debajo. Empujar para arriba poniendo tus pies de puntillas y bajar hasta la posición inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(31,'Gemelos de Pie Máquina','Pierna',4,12,'Sitúa tus trapecios por debajo de las almohadillas y los pies en la plataforma. Empujar para arriba poniendo tus pies de puntillas y bajar hasta la posición inicial. ');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(32,'Sentadilla Hack','Pierna',3,10,'Situarte con las almohadillas sobre los hombros y los pies en la plataforma. Bajar hasta que tus piernas formen un ángulo de noventa grados y subir a la posición inicial.');
-- EJERCICIOS GLUTEO
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(33,'Kickback Glúteo','Gluteo',4,12,'Apóyate con el pecho y los brazos en las almohadillas y situar una pierna en la barra a empujar. Una vez situada empujar hasta tener recta la pierna y después volver a la posición inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(34,'Hip Thrust Máquina','Gluteo',4,10,'Sitúa la almohadilla sobre tu cintura y ajustala para estar cómodo. Empuja hacia arriba con tu cintura hasta tener tus piernas a noventa grados, después baja hasta la posición inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(35,'Hip Thrust con Barra','Gluteo',4,10,'Sitúa la barra sobre tu cintura y ajustala con una almohadilla para estar cómodo. Empuja hacia arriba con tu cintura hasta tener tus piernas a noventa grados, después baja hasta la posición inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(36,'Abducción de Cadera Máquina','Gluteo',4,12,'Siéntate en la máquina teniendo las dos almohadillas por fuera de los cuádriceps. Empujar las piernas hacia fuera hasta que llegues al límite de la máquina y volver a la posición inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(37,'Adducción de Cadera Máquina','Gluteo',4,12,'Siéntate en la máquina teniendo las dos almohadillas por dentro de los cuádriceps. Empujar las piernas hacia dentro hasta que llegues al límite de la máquina y volver a la posición inicial.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(38,'Peso Muerto con Barra','Gluteo',3,8,'Colocar una barra a dos palmos de tus pies y con la espalda recta tirar la barra hacia arriba hasta la altura de tu cintura, aguantar dos segundos bajarla al suelo de nuevo.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(39,'Zancadas con Mancuernas','Gluteo',4,10,'Coger dos mancuernas, una con cada mano, e ir dando zancadas bajando a tocar con la rodilla el suelo con la pierna que se queda detrás.');
insert into Ejercicio(id,nombre,parte_muscular,series,repeticiones,descripcion)
VALUES(40,'Peso muerto en Máquina','Gluteo',4,12,'Colocate a dos palmos de los agarres, con la espalda recta tirar hacia arriba hasta la altura de tu cintura, aguantar dos segundos bajarla al suelo de nuevo. ');
