package aoc.y2022.day08
import problemutils.*, extensions.*

def parse(data: List[String]): Vector[Vector[Int]] = data.map(xs => xs.split("").map(s => s.toInt).toVector).toVector
