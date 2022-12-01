package aoc.y2022.day01
import problemutils.*
import extensions.*

import scala.collection.mutable.ListBuffer

def parse(data: List[String]): List[Int] =
  //data.mkString(":").split("::").map(_.split(":").map(_.toInt)).map(_.sum).toList

  val res = ListBuffer[ListBuffer[String]]()
  var current = ListBuffer[String]()

  for line <- data do
    if line == "" then
      res += current
      current = ListBuffer[String]()
    else
     current += line
  res += current

  res.map(_.map(_.toInt).sum).toList
