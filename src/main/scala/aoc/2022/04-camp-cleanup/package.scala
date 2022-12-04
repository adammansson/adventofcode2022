package aoc.y2022.day04
import problemutils.*, extensions.*

def parse(data: List[String]): List[Vector[Range]] =
  data
    .map(s => s.split(",").map(s => s.split("-")).map(xs => xs(0).toInt to xs(1).toInt).toVector)
    .map(xs => xs.sortWith((x, y) => x.length <= y.length))
