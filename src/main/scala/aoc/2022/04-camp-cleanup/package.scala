package aoc.y2022.day04
import problemutils.*, extensions.*

def parse(data: List[String]): List[Vector[Range]] = 
  data
    .map(s => s.split(",").toVector.map(s => s.split("-")).map(xs => xs(0).toInt to xs(1).toInt))
