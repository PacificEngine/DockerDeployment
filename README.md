# Compile
__Mac/Linux__
```bash
./gradlew clean build
docker build --tag <tagname> .
```

__Windows__
```cmd
./gradlew.bat clean build
docker build --tag <tagname> .
```

## Update Gradle
```bash
rm -rf gradle/wrapper gradlew gradlew.bat
gradle wrapper --gradle-version=8.5 --distribution-type=all
git add gradle/wrapper/ gradlew gradlew.bat
git update-index --chmod=+x gradle/wrapper/gradle-wrapper.jar gradlew gradlew.bat
git add gradle/wrapper/ gradlew gradlew.bat
```

# Publish
Requires `GIT_USERNAME` and `GIT_TOKEN` environment variables to be set with a token generated at https://github.com/settings/tokens/new with `write:packages` permissions.

__Mac/Linux__
```bash
./gradlew publish
```

__Windows__
```PowerShell
./gradlew.bat publish
```
