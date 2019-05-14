find ./src -name *.java > sources.txt
javac -sourcepath src/ @sources.txt
java -classpath src zfaria/avajlauncher/Simulator