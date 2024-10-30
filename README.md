# COSC-2436
In regard to my [Data Structures & Algoritms](https://www.geeksforgeeks.org/courses/dsa-self-paced) class. Mostly notes will be posted. Perhaps maybe a program or two in Java.

Book: [Grokking Algorithms, Second Edition](<./Grokking Algorithms, 2nd Edition -- Aditya Y Bhargava.pdf>)

## Notes for the Professor
Lab 1:
* On step 10 of `Updating Java Version in Replit`, you do not use the `./gradlew` program, but rather `gradle` itself.
* A.K.A `gradle wrapper --gradle-version=8.5 --distribution-type=bin` for `Java 21`
    * See the [compatibility matrix](https://docs.gradle.org/current/userguide/compatibility.html) for more information on which gradle version to use.
* Moreover if you want to list dependencies on `build.gradle`, make sure that you remove the `compile`, `runtime`, and other options under `dependencies` since they are [outdated.](https://stackoverflow.com/a/66910991)
    * [Link for more information on dependencies](https://docs.gradle.org/current/userguide/declaring_dependencies.html)

Lab 3:
    - On `II. Setting Up the Development Environment`, make sure that on Step 7, correct it to `./gradlew build` since we're not using the application, but rather the wrapper.

Lab 4:
    - On `V. Implementing the Main Algorithm/Concept` you forgot to mention that you added `getDuration()` in the `Song.java` file which was easy to spot, but it must be said nevertheless.
