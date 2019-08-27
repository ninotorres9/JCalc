./clear
antlr4 -no-listener -visitor ./source/JCalc.g4 -o ./output
javac ./output/jcalc*.java ./source/mainvisit.java -d ./output