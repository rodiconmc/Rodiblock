import com.novoda.gradle.release.PublishExtension

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.novoda:bintray-release:0.9")
    }
}

plugins {
    `java-library`
}

apply(plugin = "com.novoda.bintray-release")

repositories {
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
}

dependencies {
    implementation("com.flowpowered:flow-nbt:1.0.0")
    implementation("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT")
}

configure<PublishExtension> {
    repoName = "RodiconRepo"
    userOrg = "rodiconmc"
    groupId = "com.rodiconmc"
    artifactId = "Rodiblock"
    publishVersion = "1.0.0"
    desc = "Lightweight library that allows placement of structures from Structure Block NBT files"
    website = "https://github.com/rodiconmc/Rodiblock"
}
