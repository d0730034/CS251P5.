David Chen(0028625587)


Compile:
javac -classpath .:stdlib.jar HexDump.java
javac -classpath .:stdlib.jar BurrowsWheeler.java
javac -classpath .:stdlib.jar MoveToFront.java
javac -classpath .:stdlib.jar:algs4.jar Huffman.java




Run:

	java -classpath .:stdlib.jar HexDump < abra.txt

	java -classpath .:stdlib.jar BurrowsWheeler - < abra.txt | java -classpath .:stdlib.jar HexDump

	java -classpath .:stdlib.jar BurrowsWheeler - < abra.txt | java -classpath .:stdlib.jar BurrowsWheeler +

	java -classpath .:stdlib.jar MoveToFront - < abra.txt | java -classpath .:stdlib.jar HexDump 16

	java -classpath .:stdlib.jar MoveToFront - < abra.txt | java -classpath .:stdlib.jar MoveToFront +

	java -classpath .:stdlib.jar:algs4.jar Huffman - < abra.txt | java -classpath .:stdlib.jar HexDump 16

	java -classpath .:stdlib.jar:algs4.jar Huffman - < abra.txt | java -classpath .:stdlib.jar Huffman +
