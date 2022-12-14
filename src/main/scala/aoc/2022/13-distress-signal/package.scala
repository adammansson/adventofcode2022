package aoc.y2022.day13
import problemutils.*
import extensions.*

import scala.collection.mutable

def parse(data: List[String]): Vector[Vector[String]] =
  data
    .mkString("\n")
    .split("\n\n")
    .map(_.split("\n").toVector)
    .toVector

def parseList(s: String): Vector[String] =
  val ns = s.drop(1).dropRight(1)
  val xs = mutable.ArrayBuffer[String]()
  val q = mutable.Queue[Char]()
  var e = ""

  for c <- ns do
    if q.isEmpty && c == ',' then
      xs.addOne(e)
      e = ""
    else
      if c == '[' then
        q.enqueue('[')
      else if c == ']' then
        q.dequeue()

      e += c
  xs.addOne(e)
  xs.toVector.filterNot(_ == "")
