# Maze Solver
This is app to Solve Maze Challenge.
## Usage

mvn exec:java -Dexec.args="filename xStartPoint yStartPoint xEndPoint yEndPoint"

**Example ->**

mvn exec:java -Dexec.args="Sample1(tsv).txt 31 6 19 17"

mvn exec:java -Dexec.args="Sample2(tsv).txt 31 22 13 11"

mvn exec:java -Dexec.args="\\"Hound Maze(tsv).txt\\" 60 83 18 26"

mvn exec:java -Dexec.args="Hound_Maze(tsv).txt 60 83 18 26"

mvn exec:java -Dexec.args="default"
