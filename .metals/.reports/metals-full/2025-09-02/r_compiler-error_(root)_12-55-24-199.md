error id: 2FA2C203B6A4C554DD129CC150BB5C2B
file:///C:/Users/anime/Desktop/repos/scala-interview-questions/interview_practice/src/main/scala/ms_interview.scala
### java.lang.IndexOutOfBoundsException: -1

occurred in the presentation compiler.



action parameters:
offset: 98
uri: file:///C:/Users/anime/Desktop/repos/scala-interview-questions/interview_practice/src/main/scala/ms_interview.scala
text:
```scala
class ms_interview {
  val arr = Array(24, 26, 10, 8, 9, 4)

  def findLeaders(Array arr) = Array(@@)
}

```


presentation compiler configuration:
Scala version: 3.7.2-bin-nonbootstrapped
Classpath:
<WORKSPACE>\interview_practice\.bloop\root\bloop-bsp-clients-classes\classes-Metals-YjUTSQpfSwuh8MFYV6mUKA== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.11.0\semanticdb-javac-0.11.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.7.2\scala3-library_3-3.7.2.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.16\scala-library-2.13.16.jar [exists ], <WORKSPACE>\interview_practice\.bloop\root\bloop-bsp-clients-classes\classes-Metals-YjUTSQpfSwuh8MFYV6mUKA==\META-INF\best-effort [missing ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>\interview_practice -Ywith-best-effort-tasty




#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:129)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:244)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:101)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:88)
	dotty.tools.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:46)
	dotty.tools.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:482)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: -1