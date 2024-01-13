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
version="$(PRINT_VERSION=true ./gradlew --quiet :printVersion)"
git tag "${version}" -m "v${version}"
git push origin "${version}"
url="https://api.github.com/repos/PacificEngine/DockerDeployment/releases"
body="{\"tag_name\":\"${version}\",\"name\":\"v${version}\",\"draft\":false,\"prerelease\":false,\"generate_release_notes\":true}"
curl --request POST --location --fail --header 'Accept: application/vnd.github+json' --header "Authorization: Bearer ${GIT_TOKEN}" $url --data $body
./gradlew publish
```

__Windows__
```PowerShell
set PRINT_VERSION=true
$version="$(./gradlew.bat --quiet :printVersion)"
set PRINT_VERSION=
git tag "${version}" -m "v${version}"
git push origin "${version}"
$url = "https://api.github.com/repos/PacificEngine/DockerDeployment/releases"
$Headers = @{
	'Accept' = 'application/vnd.github+json'
	'Authorization' = "Bearer ${GIT_TOKEN}"
}
$Body = "{`"tag_name`":`"${version}`",`"name`":`"v${version}`",`"draft`":false,`"prerelease`":false,`"generate_release_notes`":true}"
Invoke-WebRequest -Uri $url -Method POST -MaximumRedirection 5 -Headers $Headers -Body $Body
./gradlew.bat publish
```
