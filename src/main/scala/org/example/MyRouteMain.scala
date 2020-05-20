package org.example

import org.apache.camel.main.Main
import org.apache.camel.scala.dsl.builder.RouteBuilderSupport
import org.apache.spark.{SparkConf, SparkContext}

/**
 * A Main to run Camel with MyRouteBuilder
 */
object MyRouteMain extends RouteBuilderSupport {

  def main(args: Array[String]): Unit = {
     val a = new SparkConf().setAppName("ddd")

    new SparkContext(a)
      .parallelize(List(1,2,3,4,5,6))
      .map(x=> x*x)
      .filter(_>10)
      .collect()
      .foreach(println);
  }
}

