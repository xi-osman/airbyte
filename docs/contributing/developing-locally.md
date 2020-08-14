# Developing Locally

## Getting Started

```text
$ git clone git@github.com:datalineio/dataline.git
$ cd dataline
$ docker-compose -f docker-compose.dev.yaml up --build
```

The first build will take a few minutes, next ones will go faster. 

Once it completes, Dataline will be running your environment.

## Compile with Gradle

Dataline uses `java 14` and `node 14`

```text
$ cd dataline
$ ./gradlew clean build
```

## Code Style

‌For all the `java` code we follow Google's Open Sourced [style guide](https://google.github.io/styleguide/).‌

### Configure Java Style for IntelliJ <a id="configure-for-intellij"></a>

First download the style configuration

```text
$ curl https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml -o ~/Downloads/intellij-java-google-style.xml
```

Install it in IntelliJ:‌

1. Go to `Preferences > Editor > Code Style`
2. Press the little cog:
   1. `Import Scheme > IntelliJ IDEA code style XML`
   2. Select the file we just downloaded
3. Select `GoogleStyle` in the drop down
4. You're done!
