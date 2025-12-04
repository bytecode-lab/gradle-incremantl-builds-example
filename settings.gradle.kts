pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GradleIncrementalBuilds"
include(":app")
project(":app").projectDir = file("apps/app")
include(":module-a")
project(":module-a").projectDir = file("features/module-a")
include(":module-b")
project(":module-b").projectDir = file("features/module-b")
include(":module-c")
project(":module-c").projectDir = file("features/module-c")
include(":module-d")
project(":module-d").projectDir = file("features/module-d")
include(":module-e")
project(":module-e").projectDir = file("features/module-e")
include(":module-f")
project(":module-f").projectDir = file("features/module-f")
include(":module-g")
project(":module-g").projectDir = file("features/module-g")
include(":module-h")
project(":module-h").projectDir = file("features/module-h")
include(":module-i")
project(":module-i").projectDir = file("features/module-i")
include(":module-j")
project(":module-j").projectDir = file("features/module-j")
include(":module-k")
project(":module-k").projectDir = file("features/module-k")
