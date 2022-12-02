package aoc.y2022.day01
import problemutils.*
import extensions.*

import scala.collection.mutable.ListBuffer

def parse(data: List[String]): List[Int] = 
  data.mkString("\n").split("\n\n").map(_.split("\n").map(_.toInt).sum).toList