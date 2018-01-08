node {
    stage("checkout") {
        git branch: 'development', url: 'https://github.com/Diluv/Identicons4J'
    }

    stage("build") {
        sh './gradlew clean build'
    }

    stage("deploy") {
        sh './gradlew uploadArchives'
    }
}