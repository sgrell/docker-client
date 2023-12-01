plugins {
  groovy
  id("com.github.ben-manes.versions")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(8))
  }
}

dependencies {
  constraints {
    implementation("org.slf4j:slf4j-api") {
      version {
        strictly("[1.7,3)")
        prefer("2.0.9")
      }
    }
    implementation("com.squareup.okio:okio") {
      version {
        strictly("[3,4)")
      }
    }
    listOf(
      "org.jetbrains.kotlin:kotlin-reflect",
      "org.jetbrains.kotlin:kotlin-stdlib",
      "org.jetbrains.kotlin:kotlin-stdlib-jdk7",
      "org.jetbrains.kotlin:kotlin-stdlib-jdk8",
      "org.jetbrains.kotlin:kotlin-stdlib-common",
      "org.jetbrains.kotlin:kotlin-test"
    ).onEach {
      implementation(it) {
        version {
          strictly("[1.6,1.10)")
          prefer("1.9.21")
        }
      }
    }
    listOf(
        "org.codehaus.groovy:groovy",
        "org.codehaus.groovy:groovy-json"
    ).onEach {
      implementation(it) {
        version {
          strictly("[3,4)")
          prefer("3.0.19")
        }
      }
    }
    listOf(
      "org.apache.groovy:groovy",
      "org.apache.groovy:groovy-json"
    ).onEach {
      implementation(it) {
        version {
          strictly("[4,)")
          prefer("4.0.15")
        }
      }
    }
  }
//  implementation(project(":client"))
  implementation(project(":client-groovy4"))
//  implementation("org.codehaus.groovy:groovy:[3,4)")
  implementation("org.apache.groovy:groovy:4.0.16")
  testImplementation("org.apache.commons:commons-compress:1.25.0")

  implementation("org.slf4j:slf4j-api:2.0.9")
  runtimeOnly("ch.qos.logback:logback-classic:[1.2,2)!!1.3.11")

//  testImplementation("org.spockframework:spock-core:2.3-groovy-3.0")
  testImplementation("org.spockframework:spock-core:2.3-groovy-4.0")
  testRuntimeOnly("net.bytebuddy:byte-buddy:1.14.10")
  testRuntimeOnly("ch.qos.logback:logback-classic:[1.2,2)!!1.3.11")
}

tasks {
  withType<JavaCompile> {
    options.encoding = "UTF-8"
  }
  withType<Test> {
    useJUnitPlatform()
  }
}
