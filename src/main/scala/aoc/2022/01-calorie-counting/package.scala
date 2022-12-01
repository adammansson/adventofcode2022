package aoc.y2022.day01
import problemutils.*, extensions.*

def parse(data: List[String]): List[Int] =
  data.mkString(":").split("::").map(_.split(":").map(_.toInt)).map(_.sum).toList
