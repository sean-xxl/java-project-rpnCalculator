# java-project-rpnCalculator

A java code implement command-line based RPN(reverse polish notation) calculator.
For example:
> Please input:
> 1 2 3 4 5
> stack: 1 2 3 4 5 
> \+ -
> stack: 1 2 -6 
> \* -1 /
> stack: 1 12 
> sqrt
> stack: 1 3.4641016151 
> undo
> stack: 1 12 
> clear
> stack: 

Build
-----------

./gradlew build

Test
------------

./gradlew test

Run
-----------

./gradlew run
