package aoc.y2022.day11
import problemutils.*
import extensions.*

import scala.collection.mutable.ArrayBuffer

class Monkey():
  var items: ArrayBuffer[Int] = ArrayBuffer[Int]()
  var operation: Array[String] = Array.fill(2)("")
  var test: Array[Int] = Array.fill(3)(0)
  var timesInspected = 0

def parse(data: List[String]): Vector[Monkey] =
  val groups = data.mkString("\n").split("\n\n").map(s => s.split("\n").toVector).toVector
  for g <- groups yield
    val monk = Monkey()
    val items = g(1).split(": ")(1).split(", ").map(s => s.toInt)
    for item <- items do
      monk.items.addOne(item)

    monk.operation = g(2).split("new = old")(1).split(" ").drop(1)
    val n = g(3).split(" ").last.toInt
    val t = g(4).split(" ").last.toInt
    val f = g(5).split(" ").last.toInt
    monk.test = Array(n, t, f)

    monk