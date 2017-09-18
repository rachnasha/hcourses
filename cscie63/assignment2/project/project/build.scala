import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import com.typesafe.sbt.SbtScalariform._
import sbt.Keys._
import sbt._
import sbtassembly.Plugin.AssemblyKeys._
import sbtassembly.Plugin._


object RestApi extends sbt.Build{

  lazy val root =
    Project(id = "restApi",
      base = file("restApu"),
      settings = Project.defaultSettings ++ Shared.settings ++ Assembly.restApi
    )


  object Assembly {

    /*    packageOptions in assembly += Package.ManifestAttributes(
          "Premain-Class" -> "cs265.sds.ObjectSizeFetcher"
        )*/

   /* private val localAssemblySettings = assemblySettings ++ Seq(test in assembly := {}) ++ Seq(
      packageOptions in assembly += Package.ManifestAttributes(
        "Premain-Class" -> "cs265.sds.ObjectSizeFetcher"
      )
    )*/



  }


  object Shared{

    def loggingDeps(configuration : String = "compile") = Seq(
      "ch.qos.logback" % "logback-core" % "1.0.13" % configuration,
      "ch.qos.logback" % "logback-classic" % "1.0.13" % configuration,
      "org.slf4j" % "slf4j-api" % "1.7.5" % configuration
    )

    val scopt_parser = "com.github.scopt" %% "scopt" % "2.1.0"

    val ne04j = "org.anormcypher"%% "anormcypher" % "0.10.0"
/*
    val ScalaTest = "org.scalatest" %% "scalatest" % "2.2.6" % "test"
    val TestDeps = Seq(ScalaTest)*/


    val settings = Seq(
      scalaVersion := "2.10.3",
      libraryDependencies ++= ne04j ++ Shared.loggingDeps() ++ Seq(scopt_parser)
    ) ++ Format.settings



    object Format {

      import com.typesafe.sbt.SbtScalariform._

      lazy val settings = scalariformSettings ++ Seq(
        ScalariformKeys.preferences := formattingPreferences
      )

      lazy val formattingPreferences = {
        import scalariform.formatter.preferences._
        FormattingPreferences().
          setPreference(AlignParameters, true).
          setPreference(AlignSingleLineCaseStatements, true).
          setPreference(CompactControlReadability, false).
          setPreference(CompactStringConcatenation, false).
          setPreference(DoubleIndentClassDeclaration, true).
          setPreference(FormatXml, true).
          setPreference(IndentLocalDefs, true).
          setPreference(IndentPackageBlocks, true).
          setPreference(IndentSpaces, 2).
          setPreference(MultilineScaladocCommentsStartOnFirstLine, true).
          setPreference(PreserveSpaceBeforeArguments, false).
          setPreference(PreserveDanglingCloseParenthesis, false).
          setPreference(RewriteArrowSymbols, false).
          setPreference(SpaceBeforeColon, false).
          setPreference(SpaceInsideBrackets, false).
          setPreference(SpacesWithinPatternBinders, true)
      }

    }


    lazy val shell = Project("restApi", file("restApi"),
      settings = settings
    )
  }

}
