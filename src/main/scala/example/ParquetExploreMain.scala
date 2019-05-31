package example

import org.apache.parquet.schema.{GroupType, MessageType, PrimitiveType}
import org.apache.parquet.schema.PrimitiveType.PrimitiveTypeName.{BINARY, INT64}
import org.apache.parquet.schema.Type.Repetition.{OPTIONAL, REPEATED, REQUIRED}

// Julien's example
//https://github.com/apache/parquet-mr/blob/apache-parquet-1.8.1/parquet-column/src/main/java/org/apache/parquet/example/Paper.java
//

object ParquetExploreMain extends App {
  println("Blah")
}

object Schemas {
  
  val docSchema =
    new MessageType("Document",
      new PrimitiveType(REQUIRED, INT64, "DocId"),
      new GroupType(OPTIONAL, "Links",
        new PrimitiveType(REPEATED, INT64, "Backward"),
        new PrimitiveType(REPEATED, INT64, "Forward")
      ),
      new GroupType(REPEATED, "Name",
        new GroupType(REPEATED, "Language",
          new PrimitiveType(REQUIRED, BINARY, "Code"),
          new PrimitiveType(OPTIONAL, BINARY, "Country")
        ),
        new PrimitiveType(OPTIONAL, BINARY, "Url")
      )
    )
  
  
}
