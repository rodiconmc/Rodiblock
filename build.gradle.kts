plugins {
    `java-library`
    `maven-publish`
}

repositories {
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
}

dependencies {
    implementation("com.flowpowered:flow-nbt:1.0.0")
    implementation("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/rodiconmc/rodiblock")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_REPO_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_REPO_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("RodiconRepo") {
            from(components["java"])
            groupId = "com.rodiconmc"
            artifactId = "rodiblock"
            version = "1.0.1"
            description = "Lightweight library that allows placement of structures from Structure Block NBT files"
        }
    }
}
