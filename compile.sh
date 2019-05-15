find ./src -name *.java > sources.txt
javac -d bin/ -sourcepath src/ @sources.txt
