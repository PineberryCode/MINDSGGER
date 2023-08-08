
mkdir target | mkdir target/classes | mkdir target/classes/my
mkdir target | mkdir target/test-classes

find src -name "test.java" -print | xargs javac -d target/test-classes
find src -name "Main.java" -print | xargs javac -d target/classes/my

alias test='java -cp target/classes test'