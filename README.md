# COSC-2436
In regard to my [Data Structures & Algoritms](https://www.geeksforgeeks.org/courses/dsa-self-paced) class. Mostly notes will be posted. Perhaps maybe a program or two in Java.

Book: [Grokking Algorithms, Second Edition](<./Grokking Algorithms, 2nd Edition -- Aditya Y Bhargava.pdf>)

## Notes for the Professor
Lab 1:
* On step 10 of `Updating Java Version in Replit`, you do not use the `./gradlew` program, but rather `gradle` itself.
* A.K.A `gradle wrapper --gradle-version=8.5 --distribution-type=bin` for `Java 21`
    * See the [compatibility matrix](https://docs.gradle.org/current/userguide/compatibility.html) for more information on whcih gradle version to use.
* Moreover if you want to list dependencies on `build.gradle`, make sure that you remove the `compile`, `runtime`, and other options under `dependencies` since they are [outdated](https://stackoverflow.com/a/66910991)
    * [Link for more information on dependencies](https://docs.gradle.org/current/userguide/declaring_dependencies.html)
