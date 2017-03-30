ISTRUZIONI PER UTENTI Linux/UNIX (Java 1.8) [Attenzione, in laboratorio Dijkstra assicurarsi che il file .cshrc contenga la linea: 

setenv PATH /usr/NFS/Linux/jdk1.8.0_74/bin:${PATH}

)

Dalla directory OrderedArray_Java/src, usare i seguenti comandi.

=========================================================================

PER COMPILARE il progetto contenuto nel package “orderedarray:

javac -cp .:../junit-4.12.jar:../hamcrest-core-1.3.jar orderedarray/OrderedArrayJava_TestsRunner.java

PER ESEGUIRE il progetto contenuto nel package “orderedarray”:

java -cp .:../junit-4.12.jar:../hamcrest-core-1.3.jar orderedarray.OrderedArrayJava_TestsRunner

=========================================================================

PER COMPILARE il progetto contenuto nel package “orderedarrayusagejava”:

javac -cp .:../junit-4.12.jar:../hamcrest-core-1.3.jar orderedarrayusagejava/OrderedArrayUsageJava.java

PER ESEGUIRE il progetto contenuto nel package “orderedarrayusagejava”:

java -cp .:../junit-4.12.jar:..\hamcrest-core-1.3.jar orderedarrayusagejava.OrderedArrayUsageJava ../../ordered_array_sample_file.csv

=========================================================================
