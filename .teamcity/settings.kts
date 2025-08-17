import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.03"

project {

    subProject(Teamcity2)
}


object Teamcity2 : Project({
    name = "Teamcity2"

    vcsRoot(Teamcity2_HttpsGithubComArunM3teamcity2refsHeadsMain)

    buildType(Teamcity2_Build)
})

object Teamcity2_Build : BuildType({
    name = "Build"

    vcs {
        root(Teamcity2_HttpsGithubComArunM3teamcity2refsHeadsMain)
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object Teamcity2_HttpsGithubComArunM3teamcity2refsHeadsMain : GitVcsRoot({
    name = "https://github.com/arun-m3/teamcity2#refs/heads/main"
    url = "https://github.com/arun-m3/teamcity2"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        password = "credentialsJSON:3afb7e0f-f544-46d4-bc88-a8c126bc40c3"
    }
})
