rm JCalc*.java
rm *.tokens
rm *.class
antlr4 -no-listener -visitor JCalc.g4
javac jcalc*.java mainvisit.java
.\test.ps1